package qvdreader;
/*    */
import java.io.FileNotFoundException;
import java.io.IOException;

import qvdreader.de.tiq.solutions.data.conversion.QVDReader;
/*    */
/*    */
/*    */ 
/*    */ public class ExampleQVDReaderSelect
/*    */ {
/*    */   public static void main(String[] args) {
/* 29 */     QVDReader qvdReader = null;
/* 30 */     String paramQVDfile = ".\\examples\\test_ocean.qvd";
/*    */     
/*    */     try {
/* 33 */       qvdReader = new QVDReader(paramQVDfile, new String[] { "datum", "onkz", "rufnummer" }, true);
/*    */     
/*    */     }
/* 36 */     catch (FileNotFoundException ex) {
/* 37 */       ex.printStackTrace();
/* 38 */       System.exit(1);
/*    */     } 
/* 40 */     System.out.println("Input : " + paramQVDfile);
/*    */     
/* 42 */     long recno = 0L;
/*    */     
/* 44 */     while (qvdReader.hasRecord()) {
/* 45 */       String[] rec = qvdReader.getRecord();
/*    */       
/* 47 */       recno++;
/* 48 */       if (recno % 250000L == 0L) System.out.println("QVD to CSV conversion: " + recno + " records processed."); 
/*    */     } 
/* 50 */     if (recno == qvdReader.getNoOfRecords()) {
/* 51 */       System.out.println("QVD to CSV conversion finished. " + recno + " records written.");
/*    */     } else {
/* 53 */       System.out.println("QVD to CSV conversion finished. " + recno + " of " + qvdReader.getNoOfRecords() + " records processed.");
/*    */     } 
/*    */     
/*    */     try {
/* 57 */       qvdReader.close();
/* 58 */     } catch (IOException ex) {}
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static String[] doQouting(String[] values, char delim) {
/* 64 */     for (int i = 0; i < values.length; i++) {
/* 65 */       if (values[i].indexOf(delim) >= 0) {
/* 66 */         values[i] = "\"" + values[i] + "\"";
/*    */       }
/*    */     } 
/* 69 */     return values;
/*    */   }
/*    */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\ExampleQVDReaderSelect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */