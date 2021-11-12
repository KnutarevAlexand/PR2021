package p8;


import java.io.FileOutputStream;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.io.IOUtils;

public class LoadFileFromHive {
    
    
    public static void main(String[] args) {
        try {
            //BasicConfigurator.configure();        
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            //Class.forName("com.cloudera.hive.jdbc.HS2Driver");
            Connection connection = DriverManager.getConnection("jdbc:hive2://hdp-main1b.grip.ubrr.ru:10000/default;UseNativeQuery=1;", "hive", "");
            //Connection connection = DriverManager.getConnection("jdbc:hive2://hdp-main1b.grip.ubrr.ru:10000/default;AuthMech=2;transportMode=bynary;UseNativeQuery=0;", "hive", "");
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("select file_name, file_binary from ods_crm.calls where id = '111'");
            res.next();
            String file_name = res.getString("file_name");  
            InputStream is = res.getBinaryStream("file_binary");            
            byte[] bytes = IOUtils.toByteArray(is);            
            //bytes = Base64.getDecoder().decode(bytes);//decode base64
            FileOutputStream fos = new FileOutputStream("D:/Проекты/Информатика 8 - DWH-888 Незабудка/тестовые файлы на выгрузку из bin/" + file_name);
            fos.write(bytes);
            fos.flush();
            fos.close();
            is.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            }
        }
    }
