package qvdreader;
/*    */ import au.com.bytecode.opencsv.CSVWriter;
/*    */ import qvdreader.de.tiq.solutions.data.conversion.QVDReader;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStreamWriter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExampleQVDReader
/*    */ {
/*    */   public static void main(String[] args) {
/* 29 */     QVDReader qvdReader = null;
/* 30 */     CSVWriter csvWriter = null;
/* 31 */     FileOutputStream fos = null;
/* 32 */     String paramQVDfile = args[0];
/* 33 */     String paramCSVfile = args[1];
/* 34 */     char paramDelimiter = args[2].substring(0, 1).toCharArray()[0];
/*    */     
/*    */     try {
/* 37 */       qvdReader = new QVDReader(paramQVDfile);
/*    */     
/*    */     }
/* 40 */     catch (FileNotFoundException ex) {
/* 41 */       ex.printStackTrace();
/* 42 */       System.exit(1);
/*    */     } 
/* 44 */     System.out.println("Input : " + paramQVDfile);
/* 45 */     System.out.println("Output: " + paramCSVfile);
/*    */ 
/*    */     
/*    */     try {
/* 49 */       fos = new FileOutputStream(paramCSVfile);
/* 50 */       byte[] bom = { -17, -69, -65 };
/* 51 */       fos.write(bom);
/*    */       
/* 53 */       csvWriter = new CSVWriter(new OutputStreamWriter(fos), paramDelimiter, false, false);
/* 54 */       csvWriter.writeNext(doQouting(qvdReader.getFields(), paramDelimiter));
/*    */     }
/* 56 */     catch (IOException ex) {
/* 57 */       ex.printStackTrace();
/* 58 */       System.exit(1);
/*    */     } 
/*    */     
/* 61 */     long recno = 0L;
/* 62 */     while (qvdReader.hasRecord()) {
/* 63 */       csvWriter.writeNext(doQouting(qvdReader.getRecord(), paramDelimiter));
/* 64 */       recno++;
/* 65 */       if (recno % 2500L == 0L) System.out.println("QVD to CSV conversion: " + recno + " records processed."); 
/*    */     } 
/* 67 */     if (recno == qvdReader.getNoOfRecords()) {
/* 68 */       System.out.println("QVD to CSV conversion finished. " + recno + " records written.");
/*    */     } else {
/* 70 */       System.out.println("QVD to CSV conversion finished. " + recno + " of " + qvdReader.getNoOfRecords() + " records processed.");
/*    */     } 
/*    */     
/*    */     try {
/* 74 */       qvdReader.close();
/* 75 */       csvWriter.close();
/* 76 */     } catch (IOException ex) {}
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static String[] doQouting(String[] values, char delim) {
/* 82 */     for (int i = 0; i < values.length; i++) {
/* 83 */       if (values[i].indexOf(delim) >= 0) {
/* 84 */         values[i] = "\"" + values[i] + "\"";
/*    */       }
/*    */     } 
/* 87 */     return values;
/*    */   }
/*    */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\ExampleQVDReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */