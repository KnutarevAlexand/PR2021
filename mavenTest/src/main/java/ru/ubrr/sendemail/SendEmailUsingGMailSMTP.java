package ru.ubrr.sendemail;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingGMailSMTP {

    public static void main(String[] args) {

    Logger logger = Logger.getLogger(SendEmailUsingGMailSMTP.class.getName());
    logger.info("Строка лога");

        // Recipient's email ID needs to be mentioned.
        String to = "to@mail.ru";

        // Sender's email ID needs to be mentioned
        String from = "from@mail.ru";//"from@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.mail.ru";//"smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        //properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");



        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("login@mail.ru", "password");//"login@gmail.com", "password");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}











/*
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingGMailSMTP {
   public static void main(String[] args) {
      
    Logger logger = Logger.getLogger(SendEmailUsingGMailSMTP.class.getName());
    logger.info("Строка лога");
 
      
      // Recipient's email ID needs to be mentioned.
      String to = "to@gmail.com";//change accordingly

      // Sender's email ID needs to be mentioned
      String from = "from@gmail.com";//change accordingly
      final String username = "login@gmail.com";//change accordingly
      final String password = "password";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      //props.put("mail.smtp.ssl.trust", host);
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");       
      props.put("mail.smtp.auth", "true");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         // Set Subject: header field
         message.setSubject("Testing Subject");

         // Now set the actual message
         message.setText("Hello, this is sample for to check send "
            + "email using JavaMailAPI ");

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
          
          
          

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
   
   
   
   
   }


}
*/