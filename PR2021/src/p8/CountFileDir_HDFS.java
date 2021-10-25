package p8;


import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.PropertyConfigurator;


public class CountFileDir_HDFS {

    static int countNullRows;            // counts the number of output rows across all partitions containing null values
    static Object lock = new Object();   // lock to synchronize countNullRows
    static FileSystem fileSystem;
    static FileStatus[] fileStatuses;
    
    public static void main(String[] args) {
        
        int partCountNullRows = 0;               // counts the number of output rows in this partition containing null values
        String input1 = "test";
        int output1 = 0;

         if(input1 != null)
          {
             final Properties props = new Properties();
             props.setProperty("log4j.rootLogger", "ERROR, stdout");
             props.setProperty("log4j.appender.stdout","org.apache.log4j.ConsoleAppender");
             props.setProperty("log4j.appender.stdout.Target","System.out");
             props.setProperty("log4j.appender.stdout.layout","org.apache.log4j.PatternLayout");
             props.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d{yy/MM/dd HH:mm:ss} %p %c{2}: %m%n");
             PropertyConfigurator.configure(props);
                     
             System.setProperty("HADOOP_USER_NAME", "hive");
             
             Configuration configuration = new Configuration(); 
             
             //configuration.set("fs.defaultFS", "hdfs://hdp-main1b.grip.ubrr.ru:8020");
             configuration.set("fs.defaultFS", "hdfs://hdp-main1a.grip.ubrr.ru:8020");
             ArrayList filePaths = new ArrayList();
             Path path = new Path("/audio_file_test");
             try {
                 fileSystem = path.getFileSystem(configuration);
             } catch (IOException e) {
                 System.err.println("Exception connect file system: " + e.getMessage());
             }
             try {
                 fileStatuses = fileSystem.listStatus(path);
             } catch (FileNotFoundException e) {
                 System.err.println("Exception get file list: " + e.getMessage());
             } catch (IOException e) {
                 System.err.println("Exception get file list: " + e.getMessage());
             }
              try {
                  fileSystem.close();
              } catch (IOException e) {
                  System.err.println("Exception close connect file systemt: " + e.getMessage());
              }
             for(FileStatus fileStatus : fileStatuses) {
                 if(fileStatus.isFile()) filePaths.add(fileStatus.getPath().toString());
                         }
             output1 = filePaths.size();
             System.out.println(output1);
         }
        else
        {
            output1 = 0;
            partCountNullRows++;
            synchronized(lock) {
                countNullRows++;
                }
        }
     }
}