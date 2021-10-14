package p4;

import java.io.UnsupportedEncodingException;

import java.util.Base64;


public class StringTest {
    
    
    // Encode
    public static String encodeString(String text) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    // Decode
    public static String decodeString(String encodeText) throws UnsupportedEncodingException {
        return new String(Base64.getDecoder().decode(encodeText.getBytes()));
    }
    
    
   public static void main(String[] args) throws UnsupportedEncodingException  {
        String str1 = "1244test";
        String str2 = new String("1244test");
        System.out.println(str1.substring(1,3));
        System.out.println(str2.substring(1,3));
        
        
        System.out.println("Text before encode: "+ str1);
        
        String encodeText = encodeString(str1);
        System.out.println("Encode text: "+ encodeText);
        
        String decodeText =  decodeString(encodeText);
        System.out.println("Decode text: "+ decodeText); 
  
       

        String securityAnswer = (str1 == "00") ? "Все в порядке, проходите!" : "Этот фильм не подходит для вашего возраста!";

        System.out.println(securityAnswer);      
        
    }
}
