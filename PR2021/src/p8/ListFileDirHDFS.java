package p8;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.PropertyConfigurator;


public class ListFileDirHDFS {

   public static void main(String[] args) throws IOException {
        
        //BasicConfigurator.configure();
        String log4jConfPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);      
       
        System.setProperty("HADOOP_USER_NAME", "hive");
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://hdp-main1b.grip.ubrr.ru:8020");
        
        List<String> filePaths = new ArrayList<String>();
        Path path = new Path("/audio_file_test");
        FileSystem fileSystem = path.getFileSystem(configuration);
        if(fileSystem.isDirectory(path)) {
            FileStatus[] fileStatuses = fileSystem.listStatus(path);
            for(FileStatus fileStatus : fileStatuses) {
                if(fileStatus.isFile()) filePaths.add(fileStatus.getPath().toString());
                }
            }
        else {
            filePaths.add(path.toString());
            }
        fileSystem.close();
        for (String str : filePaths) {                       
             System.out.println(str);
            }
}


}