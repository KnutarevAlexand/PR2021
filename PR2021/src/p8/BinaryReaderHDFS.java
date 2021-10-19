package p8;

import java.io.IOException;
import java.io.InputStream;

import java.math.BigInteger;

import java.security.MessageDigest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class BinaryReaderHDFS {
    
    static int countNullRows;
    static Object lock = new Object();
    static long length;
    static String name = null;

    static InputStream is = null;
    static MessageDigest digest = null;
    
    private static String FileName = "/audio_file_test/15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav";
    private static String MD5;
    private static String File_ID;
    
    public static void main(String[] args) throws IOException {
        if(FileName != null) {
            try {
                org.apache.log4j.BasicConfigurator.configure();
                //String log4jConfPath = "src/main/resources/log4j.properties";
                //PropertyConfigurator.configure(log4jConfPath);  
                
                System.setProperty("HADOOP_USER_NAME", "hive");
                Configuration configuration = new Configuration();
                configuration.set("fs.defaultFS", "hdfs://hdp-main1b.grip.ubrr.ru:8020");
                FileSystem fileSystem = FileSystem.get(configuration);
                Path hdfsReadPath = new Path(FileName);
                
                length = fileSystem.getContentSummary(hdfsReadPath).getLength();
                name = fileSystem.getFileStatus(hdfsReadPath).getPath().getName();
                is = fileSystem.open(hdfsReadPath);
                
                digest = MessageDigest.getInstance("MD5");
            } catch (Exception e) {
                logError("Unable to create open the file " + FileName);
                }
                        if (length > Integer.MAX_VALUE) {
                logError("File is too large");
                }
            byte[] bytes = new byte[(int) length];
            int offset = 0;
            int numRead = 0;
            try {
                while (offset < bytes.length && (numRead = is.read(bytes, offset, Math.min(bytes.length - offset, 512 * 1024))) >= 0) {
                    digest.update(bytes, 0, numRead);
                    offset += numRead;
                    }
            } catch (Exception ex) {
                logError("Error reading file");
            } finally {
                try {
                    is.close();

                } catch (Exception ex) {
                    logError("Error closing file");
                    }
                }
        if (offset < bytes.length) {
            bytes = null;
            MD5 = null;
            File_ID = null;
            logError("Could not completely read file " + name);
        } else {
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            byte[] BinaryOut = bytes;
            MD5 = bigInt.toString(16);
            logInfo("Successfully read file " + name + ",ID: " + File_ID + ", of size " + bytes.length + " bytes, with MD5 checksum: \"" + MD5 + "\"");
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
