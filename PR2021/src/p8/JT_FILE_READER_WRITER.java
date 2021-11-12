package p8;

import java.io.File;
import java.io.InputStream;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.security.MessageDigest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import java.util.Base64;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class JT_FILE_READER_WRITER {
    
    static String id = "1";
    static BigDecimal date_time = new BigDecimal("1636551505361.000000");
    static String file_path = "/audio_file_test/15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav";//"/audio_file_test/100mb.001_";
    static long md_load_id = 0;
    static BigDecimal md_ins_ts =  new BigDecimal("1636551505361.000000");
    static BigDecimal md_upd_ts =  new BigDecimal("1636551505361.000000");
    static String md_rec_cd = "I";
    static String md_src_cd = "CRM";
    static BigDecimal md_date = new BigDecimal("1636551505361.000000");
    static String host_dwh = "jdbc:oracle:thin:@rdwh.dbs.ubrr.ru:1521:rdwh";
    static String host_hdfs = "hdfs://hdp-main1a.grip.ubrr.ru:8020";
    static String host_hive = "jdbc:hive2://hdp-main1b.grip.ubrr.ru:10000/default;UseNativeQuery=1";
    static String table = "ods_crm.calls";

    static Object lock = new Object();
    static int countRows;
    static int countLoadFile;
    static long load_id;
    static String host_dwh_in;
    static String host_hdfs_in; 
    static String host_hive_in;
    static String table_in;
    static FileSystem fileSystem;
    static long maxlength = 24575250;//Integer.MAX_VALUE (для загрузки через маппинг информатики) или 32767000 (для insert через jdbc)
    static long length;
    static File fileIn; 
    static InputStream is;
    static MessageDigest digest;
    static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat sdfTimeshtamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    static Instant epoch = OffsetDateTime.of(1970,1,1,0,0,0,0,ZoneOffset.UTC).toInstant();


    static void writeLogProfile (String message, String message_type_cd, String severity_cd)  { 
          String sql = "call dwh.md_etl_utils.md_profile (?,?,?,?,?)";
          try {
              Connection conn = DriverManager.getConnection(host_dwh_in, "ADMDWH", "ADMDWH1");
              CallableStatement pstmt = conn.prepareCall(sql);
              pstmt.setLong(1, load_id);
              pstmt.setString(2, "JT_FILE_READER_WRITER");
              pstmt.setString(3, message);
              pstmt.setString(4, message_type_cd);
              pstmt.setString(5, severity_cd);
              pstmt.executeQuery();
              pstmt.close();
          } catch (SQLException e) {
            }
        }

    static void loadFile (String id, String file_path, BigDecimal date_time, long md_load_id, BigDecimal md_ins_ts, BigDecimal md_upd_ts, String md_rec_cd, String md_src_cd, BigDecimal md_date)   {
            try {
                fileIn = new java.io.File(file_path);
                Path hdfsReadPath = new Path(fileIn.toString());
                System.setProperty("HADOOP_USER_NAME", "hive");
                Configuration configuration = new Configuration();
                configuration.set("fs.defaultFS", host_hdfs_in);
                fileSystem = org.apache.hadoop.fs.FileSystem.get(configuration);
                length = fileSystem.getContentSummary(hdfsReadPath).getLength();
                is = fileSystem.open(hdfsReadPath);
                digest = MessageDigest.getInstance("MD5");
                try {
                    if (length > maxlength) {
                        throw new Exception("Превышено ограничение на размер файла: " + file_path + " " + length + " превышает " + maxlength);
                        }
                    byte[] bytes = new byte[(int) length];
                    int offset = 0;
                    int numRead = 0;
                    try {
                        while (offset < bytes.length && (numRead = is.read(bytes, offset, Math.min(bytes.length - offset, 512 * 1024))) >= 0) {
                            offset += numRead;
                            }
                    } catch (Exception e) {
                        writeLogProfile("Ошибка чтения файла: " + e, "ERROR", "LOW");
                    } finally {
                        try {
                            is.close();
                            fileSystem.close();
                        } catch (Exception e) {
                            writeLogProfile("Ошибка закрытия потока чтения файла: " + e, "ERROR", "CRITICAL");
                            }
                        }
                    if (offset < bytes.length) {
                        throw new Exception("Файл не обработан " + file_path);
                    } else {
                        digest.update(bytes,0,bytes.length);
                        String md5 = new BigInteger(1,digest.digest()).toString(16);
                        uploadFileToHive (id, date_time, fileIn.getName(), file_path, bytes, md5, md_load_id, md_ins_ts, md_upd_ts, md_rec_cd, md_src_cd, md_date);                                       }
                    } catch (Exception e) {
                        writeLogProfile(e.toString(), "ERROR", "LOW");
                    } finally {
                        try {
                            is.close();
                            fileSystem.close();
                        } catch (Exception e) {
                            writeLogProfile("Ошибка закрытия потока чтения файла: " + e, "ERROR", "CRITICAL");
                            }
                        }
            } catch (Exception e) {
                writeLogProfile(e.toString(), "ERROR", "LOW");
                }
            }
        
    static void uploadFileToHive (String id, BigDecimal date_time, String file_name, String file_path, byte[] bytes, String file_md5, long md_load_id, BigDecimal md_ins_ts, BigDecimal md_upd_ts, String md_rec_cd, String md_src_cd, BigDecimal md_date)   {
            try {   
                String encodedStr = Base64.getEncoder().encodeToString(bytes);         
                Class.forName("org.apache.hive.jdbc.HiveDriver");//Class.forName("com.cloudera.hive.jdbc.HS2Driver");
                Connection connection = DriverManager.getConnection(host_hive_in, "hive", "");
                PreparedStatement pstmt = connection.prepareStatement("insert into " + table_in + " partition(md_date = ?) (id, date_time, file_name, file_path, file_binary, file_md5, md_load_id, md_ins_ts, md_upd_ts, md_rec_cd, md_src_cd) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, sdfDate.format(md_date));//sdfDate.format(Timestamp.from(epoch.plusNanos(Math.round(md_date.doubleValue())))));
                pstmt.setString(2, id);
                pstmt.setString(3, sdfTimeshtamp.format(date_time));//Timestamp.from(epoch.plusNanos(Math.round(date_time.doubleValue()))).toString());
                pstmt.setString(4, file_name);
                pstmt.setString(5, file_path);
                pstmt.setString(6, encodedStr);
                pstmt.setString(7, file_md5);
                pstmt.setString(8, Long.toString(md_load_id));            
                pstmt.setString(9, sdfTimeshtamp.format(md_ins_ts));//Timestamp.from(epoch.plusNanos(Math.round(md_ins_ts.doubleValue()))).toString());
                pstmt.setString(10,  sdfTimeshtamp.format(md_upd_ts));//Timestamp.from(epoch.plusNanos(Math.round(md_upd_ts.doubleValue()))).toString());
                pstmt.setString(11, md_rec_cd);
                pstmt.setString(12, md_src_cd);
                pstmt.execute();
                pstmt.close();
                connection.close();
                countLoadFile++;
            } catch (Exception e) { 
                writeLogProfile("Ошибка загрузки файла: "  + file_path + ": " + e, "ERROR", "CRITICAL");
                }
            }





    public static void main(String[] args) {
        load_id = md_load_id;
        host_dwh_in = host_dwh;
        host_hdfs_in = host_hdfs;
        host_hive_in = host_hive;
        table_in = table;
        if (countRows == 0) {
                writeLogProfile("Начало загрузки файлов", "INFO", "LOW");
                }
        countRows++;
        if(file_path != null) {
            loadFile (id, file_path, date_time, md_load_id, md_ins_ts, md_upd_ts, md_rec_cd, md_src_cd, md_date);
        } else {
            synchronized(lock) {
                }
            }
        synchronized(lock) {
            writeLogProfile("Конец загрузки файлов. Из общего кол-ва строк: " + countRows + ", загружено файлов: " + countLoadFile , "INFO", "LOW");
        }
    }
}
