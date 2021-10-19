package p8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class ReadWriteHDFSExample {

    public static void main(String[] args) throws IOException {
//        ReadWriteHDFSExample.checkExists();
//        ReadWriteHDFSExample.createDirectory();
//        ReadWriteHDFSExample.checkExists();
//        ReadWriteHDFSExample.writeFileToHDFS();
//        ReadWriteHDFSExample.appendToHDFSFile();
        ReadWriteHDFSExample.readFileFromHDFS();
    }

    public static void readFileFromHDFS() throws IOException {
        //BasicConfigurator.configure();
        System.setProperty("HADOOP_USER_NAME", "hive");
        Configuration configuration = new Configuration();
        //configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        configuration.set("fs.defaultFS", "hdfs://hdp-main1b.grip.ubrr.ru:8020");

        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav";
        Path hdfsReadPath = new Path("/audio_file_test/" + fileName);
        //Init input stream
        FSDataInputStream inputStream = fileSystem.open(hdfsReadPath);
        //Classical input stream usage
        String out= IOUtils.toString(inputStream, "UTF-8");
        System.out.println(out);

        /*BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        String line = null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }*/

        inputStream.close();
        fileSystem.close();
    }

    public static void writeFileToHDFS() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://hdp-main1b.grip.ubrr.ru:50070");
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "read_write_hdfs_example.txt";
        Path hdfsWritePath = new Path("/user/javadeveloperzone/javareadwriteexample/" + fileName);
        FSDataOutputStream fsDataOutputStream = fileSystem.create(hdfsWritePath,true);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream,StandardCharsets.UTF_8));
        bufferedWriter.write("Java API to write data in HDFS");
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileSystem.close();
    }

    public static void appendToHDFSFile() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        //Create a path
        String fileName = "read_write_hdfs_example.txt";
        Path hdfsWritePath = new Path("/user/javadeveloperzone/javareadwriteexample/" + fileName);
        FSDataOutputStream fsDataOutputStream = fileSystem.append(hdfsWritePath);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream,StandardCharsets.UTF_8));
        bufferedWriter.write("Java API to append data in HDFS file");
        bufferedWriter.newLine();
        bufferedWriter.close();
        fileSystem.close();
    }

    public static void createDirectory() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        String directoryName = "javadeveloperzone/javareadwriteexample";
        Path path = new Path(directoryName);
        fileSystem.mkdirs(path);
    }

    public static void checkExists() throws IOException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fileSystem = FileSystem.get(configuration);
        String directoryName = "javadeveloperzone/javareadwriteexample";
        Path path = new Path(directoryName);
        if(fileSystem.exists(path)){
            System.out.println("File/Folder Exists : "+path.getName());
        }else{
            System.out.println("File/Folder does not Exists : "+path.getName());
        }
    }
}