package p8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigInteger;

import java.security.MessageDigest;

public class BinaryReader_local_file {
    
    static int countNullRows;
    static Object lock = new Object();
    static java.io.File fileIn = null;
    static InputStream is = null;
    static MessageDigest digest = null;
    
    private static String FileName = "D:/100mb.001";//"C:\\JDeveloper\\mywork\\javaprogramming\\KnutarevAlexandr\\PR2021\\src\\p8\\15_05_11_SSR_50996_83E73535A56D1F4CBC8F47EB685C6808.wav";
    private static String MD5;
    private static String File_ID;
    
    
    static byte[] BinaryOut;
    private static Object b;

    public static void main(String[] args) throws IOException {
            if(FileName!= null){
             try {
             fileIn = new java.io.File(FileName);
             is = new FileInputStream(fileIn);
             
             digest = MessageDigest.getInstance("MD5");
             } catch (Exception e) {
             logError("Unable to create open the file " + FileName);
             }
             long length = fileIn.length();
             if (length > Integer.MAX_VALUE) {
             logError("File is too large");
             }
             byte[] bytes = new byte[(int) length];
             int offset = 0;
             int numRead = 0;
             try {
             while (offset < bytes.length && (numRead = is.read(bytes,offset, Math.min(bytes.length - offset, 512 * 1024))) >= 0) {
             //digest.update(bytes, 0, numRead);
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
             logError("Could not completely read file " +
            fileIn.getName());
             } else {
            BinaryOut = bytes;
             
             //byte[] md5sum = digest.digest();
             //BigInteger bigInt = new BigInteger(1, md5sum);
             //MD5 = bigInt.toString(16);
                 
             digest.update(bytes,0,bytes.length);
             String signature = new BigInteger(1,digest.digest()).toString(16);
             System.out.println("Signature: "+signature);
                 
            
               
 
             logInfo("Successfully read file " + fileIn.getName() + ", ID: " + File_ID + ", of size " + length + " bytes, with MD5 checksum: \"" + MD5 + "\"");
             }
            }else{
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
