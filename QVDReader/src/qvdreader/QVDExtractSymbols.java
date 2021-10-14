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
/*    */ public class QVDExtractSymbols
/*    */ {
/*    */   public static void main(String[] args) {
/* 29 */     String[] header = { "Field", "SymNo", "Symbol" };
/* 30 */     String[] record = { "", "", "" };
/* 31 */     QVDReader qvdReader = null;
/* 32 */     CSVWriter csvWriter = null;
/* 33 */     FileOutputStream fos = null;
/* 34 */     String paramQVDfile = args[0];
/* 35 */     String paramCSVfile = args[1];
/* 36 */     char paramDelimiter = args[2].substring(0, 1).toCharArray()[0];
/*    */     
/*    */     try {
/* 39 */       qvdReader = new QVDReader(paramQVDfile);
/*    */     
/*    */     }
/* 42 */     catch (FileNotFoundException ex) {
/* 43 */       ex.printStackTrace();
/* 44 */       System.exit(1);
/*    */     } 
/* 46 */     System.out.println("Input : " + paramQVDfile);
/* 47 */     System.out.println("Output: " + paramCSVfile);
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 52 */       fos = new FileOutputStream(paramCSVfile);
/* 53 */       byte[] bom = { -17, -69, -65 };
/* 54 */       fos.write(bom);
/*    */       
/* 56 */       csvWriter = new CSVWriter(new OutputStreamWriter(fos), paramDelimiter, false, false);
/* 57 */       csvWriter.writeNext(header);
/*    */     }
/* 59 */     catch (IOException ex) {
/* 60 */       ex.printStackTrace();
/* 61 */       System.exit(1);
/*    */     } 
/*    */     
/* 64 */     long recno = 0L;
/*    */     
/* 66 */     for (int col = 0; col < qvdReader.getNoOfFields(); col++) {
/* 67 */       record[0] = qvdReader.getFieldName(col);
/*    */       long sym;
/* 69 */       for (sym = 0L; sym < qvdReader.getFieldNoOfSymbols(col); sym++) {
/* 70 */         record[1] = Long.toString(sym);
/* 71 */         record[2] = qvdReader.getFieldSymbol(col, Long.valueOf(sym));
/* 72 */         csvWriter.writeNext(doQouting(record, paramDelimiter));
/* 73 */         recno++;
/* 74 */         if (recno % 2500L == 0L) {
/* 75 */           System.out.println("QVD symbol extraction: " + recno + " symbol records processed.");
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 80 */     System.out.println("QVD symbol extraction finished. " + recno + " symbol records written.");
/*    */     
/*    */     try {
/* 83 */       qvdReader.close();
/* 84 */       csvWriter.close();
/* 85 */     } catch (IOException ex) {}
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static String[] doQouting(String[] values, char delim) {
/* 91 */     for (int i = 0; i < values.length; i++) {
/* 92 */       if (values[i].indexOf(delim) >= 0) {
/* 93 */         values[i] = "\"" + values[i] + "\"";
/*    */       }
/*    */     } 
/* 96 */     return values;
/*    */   }
/*    */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\QVDExtractSymbols.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */