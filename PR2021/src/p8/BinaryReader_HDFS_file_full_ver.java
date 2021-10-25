package p8;

import java.io.File;
import java.io.InputStream;

import java.math.BigInteger;

import java.security.MessageDigest;

import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.PropertyConfigurator;


public class BinaryReader_HDFS_file_full_ver {
    
    private static int countNullRows;
    private static Object lock = new Object();
    private static String id_in = "1";
    private static String file_path_in = "/audio_file_test/15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav";
    private static String date_time_in;

    private static File fileIn;
    private static long length;
    private static InputStream is;
    
    private static MessageDigest digest;    
    private static String id;
    private static String date_time;
    private static String file_name;
    private static String file_path;
    private static byte[] file_binary;    
    private static String file_MD5;

    

    
    public static void main(String[] args) {
            if(file_path_in != null) {
                try {
                    final Properties props = new Properties();
                    props.setProperty("log4j.rootLogger", "ERROR, stdout");
                    props.setProperty("log4j.appender.stdout","org.apache.log4j.ConsoleAppender");
                    props.setProperty("log4j.appender.stdout.Target","System.out");
                    props.setProperty("log4j.appender.stdout.layout","org.apache.log4j.PatternLayout");
                    props.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d{yy/MM/dd HH:mm:ss} %p %c{2}: %m%n"); 
                    PropertyConfigurator.configure(props);
                    //Path hdfsReadPath = new Path("/audio_file_test/15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav");
                    //Path hdfsReadPath = new Path("/audio_file_test/15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav.mp3");
                    //Path hdfsReadPath = new Path("/audio_file_test/100mb.001");
                    fileIn = new java.io.File(file_path_in);
                    Path hdfsReadPath = new Path(fileIn.toString());
                    System.setProperty("HADOOP_USER_NAME", "hive");
                    Configuration configuration = new Configuration();
                    //configuration.set("fs.defaultFS", "hdfs://hdp-main1b.grip.ubrr.ru:8020");//тестовый хайв
                    configuration.set("fs.defaultFS", "hdfs://hdp-main1a.grip.ubrr.ru:8020");//боевой хайв
                    FileSystem fileSystem = org.apache.hadoop.fs.FileSystem.get(configuration);
                    length = fileSystem.getContentSummary(hdfsReadPath).getLength();
                    is = fileSystem.open(hdfsReadPath);
                    digest = MessageDigest.getInstance("MD5");
                } catch (Exception e) {
                    logError("Unable to create open the file " + fileIn);
                    }
                if (length > Integer.MAX_VALUE) {
                    logError("File is too large " + fileIn);
                    }
                byte[] bytes = new byte[(int) length];
                int offset = 0;
                int numRead = 0;
                try {
                    while (offset < bytes.length && (numRead = is.read(bytes, offset, Math.min(bytes.length - offset, 512 * 1024))) >= 0) {
                        //digest.update(bytes, 0, numRead);
                        offset += numRead;
                        }
                } catch (Exception ex) {
                    logError("Error reading file " + fileIn);
                } finally {
                    try {
                        is.close();
                    } catch (Exception ex) {
                        logError("Error closing file " + fileIn);
                        }
                    }
            if (offset < bytes.length) {
                id = null;
                file_name = null;
                file_path =null;
                file_binary = null;
                file_MD5 = null;
                logError("Could not completely read file " + fileIn);
            } else {
                id = id_in; 
                date_time = date_time_in;
                file_name = fileIn.getName();
                file_path = file_path_in;
                file_binary = bytes;
                //byte[] md5sum = digest.digest();
                //BigInteger bigInt = new BigInteger(1, md5sum);
                //file_MD5 = bigInt.toString(16);
                digest.update(bytes,0,bytes.length);
                String signature = new BigInteger(1,digest.digest()).toString(16);
                file_MD5 = signature;         
                logInfo("Successfully read file " + file_path + ", ID: " + id + ", of size " + length + " bytes, with MD5 checksum: \"" + file_MD5 + "\"");
                }
            } else {
                synchronized(lock) {
                    countNullRows++;
                    }
                }
        }

    private static void logError(String string) {
        System.out.println(string);
    }

    private static void logInfo(String string) {
        System.out.println(string);
    }
}
