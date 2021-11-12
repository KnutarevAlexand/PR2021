package p8;

import java.io.File;
import java.io.InputStream;

import java.math.BigInteger;

import java.security.MessageDigest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class JT_FILE_READER {
    
    static String file_path = "/audio_file_test/15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav";//"/audio_file_test/100mb.001_";
    static long md_load_id = 0;
    static String host_dwh = "jdbc:oracle:thin:@rdwh.dbs.ubrr.ru:1521:rdwh";
    static String host_hdfs = "hdfs://hdp-main1a.grip.ubrr.ru:8020";
    static String host_hive = "jdbc:hive2://hdp-main1b.grip.ubrr.ru:10000/default;UseNativeQuery=1";
    static long max_load_length = 1000000000;//размер который сможет выдержать кластер spark yarn

    static Object lock = new Object();
    static int countRows;
    static int countLoadFile;
    static long load_id;
    static String host_dwh_in;
    static String host_hdfs_in; 
    static String host_hive_in;
    static String table_in;
    static FileSystem fileSystem;
    static long maxlength  = 104857599;//Integer.MAX_VALUE (предельный размер для java) или 32767000 (предельный размер в jdbc) или 24575250 (предельный размер в кодированием в BASE64 в jdbc)
    
    static long length;
    static long loadLength;
    static int flagLoadLength;
    static File fileIn; 
    static InputStream is;
    static MessageDigest digest;
    
    static String file_name;
    static byte[] file_binary;
    static String file_md5;

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


    public static void main(String[] args) {
            load_id = md_load_id;
            host_dwh_in = host_dwh;
            host_hdfs_in = host_hdfs;
            if (countRows == 0) {
                //logError("Начало процедуры загрузки файлов");
                writeLogProfile("Начало загрузки файлов", "INFO", "LOW");
                }
            countRows++;
            if(file_path != null  && flagLoadLength == 0) {                
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
                        if (loadLength + length >= max_load_length) {
                            flagLoadLength = 1;
                            throw new Exception("Превышено ограничение на размер пачки файлов: " + (loadLength + length) + " превышает " + max_load_length);
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
                            file_name = fileIn.getName();
                            file_binary = bytes;
                            file_md5 = md5;
                            countLoadFile++;
                            loadLength = loadLength + length;
                            }
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
            } else {
                synchronized(lock) {
                    }
                }
        synchronized(lock) {
            writeLogProfile("Конец загрузки файлов. Из общего кол-ва строк: " + countRows + ", загружено файлов: " + countLoadFile , "INFO", "LOW");
            }
        }
    }
