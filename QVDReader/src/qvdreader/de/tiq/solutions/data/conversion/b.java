package qvdreader.de.tiq.solutions.data.conversion;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.math.BigInteger;

import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.io.IOUtils;

class b {
  static final String a = "f97083b7752e28df67d507c3fb70e06d";
  
  private static final String b = "DSA";
  
  private static final String c = "SUN";
  
  private InputStream d;
  
  private InputStream e;
  
  private PublicKey f;
  
  private b(File paramFile1, File paramFile2, byte[] paramArrayOfbyte) {
    this.d = new FileInputStream(paramFile1);
    this.e = new FileInputStream(paramFile2);
    this.f = a(paramArrayOfbyte);
  }
  
  private b(File paramFile1, File paramFile2, FileInputStream paramFileInputStream) {
    this(paramFile1, paramFile2, IOUtils.toByteArray(paramFileInputStream));
  }
  
  private b(InputStream paramInputStream1, InputStream paramInputStream2, InputStream paramInputStream3) {
    this.d = paramInputStream1;
    this.e = paramInputStream2;
    byte[] arrayOfByte = new byte[paramInputStream3.available()];
    paramInputStream3.read(arrayOfByte);
    this.f = a(arrayOfByte);
  }
  
  private boolean a() {
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
      return "f97083b7752e28df67d507c3fb70e06d".equals((new BigInteger(1, messageDigest.digest(this.f.getEncoded()))).toString(16));
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      System.err.println("Did not found the D5 algorithm!");
      return false;
    } 
  }
  
  private boolean b() {
    boolean bool = false;
    if (a()) {
      Signature signature = Signature.getInstance("DSA", "SUN");
      signature.initVerify(this.f);
      byte[] arrayOfByte1 = null;
      arrayOfByte1 = new byte[this.e.available()];
      this.e.read(arrayOfByte1);
      byte[] arrayOfByte2 = new byte[1024];
      while (this.d.available() != 0) {
        int i = this.d.read(arrayOfByte2);
        signature.update(arrayOfByte2, 0, i);
      } 
      bool = signature.verify(arrayOfByte1);
    } 
    if (!bool)
      System.out.println("License and signature files are not valid!"); 
    return bool;
  }
  
  private PublicKey a(byte[] paramArrayOfbyte) {
    KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
    return keyFactory.generatePublic(new X509EncodedKeySpec(paramArrayOfbyte));
  }
}


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */