package p8;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.SimpleDateFormat;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import java.util.Arrays;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

public class UploadFileToHive {
    
        static Instant epoch = OffsetDateTime.of(1970,1,1,0,0,0,0,ZoneOffset.UTC).toInstant();
        static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");        
        static SimpleDateFormat sdfTimeshtamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    
    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:\\24575250b.7z.001");
            //bytes
            byte[] bytes = Files.readAllBytes(path);
            //bytesToString
            String str = new String(bytes).replaceAll("\n", " ").replaceAll("\r", " ");
            //byteToArray
            String arrStr = Arrays.toString(bytes);      
            //bytesToBase64
            String encodedStr = Base64.getEncoder().encodeToString(bytes);
            //bytesToHex
            BigInteger bigInteger = new BigInteger(1,bytes);
            String hexStr = DatatypeConverter.printHexBinary(bytes);
            //FileInputStream
            File file = new File("D:\\24575250b.7z.001");    
            FileInputStream fin = new FileInputStream(file);
            //InputStream
            InputStream is = new ByteArrayInputStream(str.getBytes());
            
            //BasicConfigurator.configure();        
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            //Class.forName("com.cloudera.hive.jdbc.HS2Driver");
            Connection connection = DriverManager.getConnection("jdbc:hive2://hdp-main1b.grip.ubrr.ru:10000/default;UseNativeQuery=1;", "hive", "");
            //Connection connection = DriverManager.getConnection("jdbc:hive2://hdp-main1b.grip.ubrr.ru:10000/default;AuthMech=2;transportMode=bynary;UseNativeQuery=0;", "hive", "");
            
            BigDecimal md_date = new BigDecimal("1636551505361.000000");    
            
            PreparedStatement pstmt = connection.prepareStatement("insert into ods_crm.calls partition(md_date = ?) (id, file_binary) values(?, ?)");
            pstmt.setString(1, sdfDate.format(md_date));
            pstmt.setString(2, "1");
            pstmt.setString(3, encodedStr);
            pstmt.execute();
            fin.close();
            pstmt.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            }
        }
    }

