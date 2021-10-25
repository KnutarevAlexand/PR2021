package p8;

import java.io.FileOutputStream;
import java.io.InputStream;

import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class HiveJDBCConnect {
	public static void main(String[] args) {
		
	    final Properties props = new Properties();
	    props.setProperty("log4j.rootLogger", "ERROR, stdout");
	    props.setProperty("log4j.appender.stdout","org.apache.log4j.ConsoleAppender");
	    props.setProperty("log4j.appender.stdout.Target","System.out");
	    props.setProperty("log4j.appender.stdout.layout","org.apache.log4j.PatternLayout");
	    props.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d{yy/MM/dd HH:mm:ss} %p %c{2}: %m%n"); 
	    PropertyConfigurator.configure(props);                
                
                Connection con = null;
		try {
			String conStr = "jdbc:hive2://hdp-main1b.grip.ubrr.ru:10000/";
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			con = DriverManager.getConnection(conStr, "hive", "");
			Statement stmt = con.createStatement();
		    ResultSet res = stmt.executeQuery("select file_binary from ods_crm.calls where id = '1'");
		    res.next();
		    InputStream fileBolb = res.getBinaryStream("file_binary");
		    ReadableByteChannel rbc = Channels.newChannel(fileBolb );
		    FileOutputStream fos = new FileOutputStream("D:/15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav");
		    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		    fos.close();
		    rbc.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
	}
}
