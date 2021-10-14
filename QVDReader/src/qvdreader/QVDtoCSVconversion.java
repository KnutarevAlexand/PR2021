package qvdreader;

/*     */ import au.com.bytecode.opencsv.CSVWriter;
/*     */ import qvdreader.de.tiq.solutions.data.conversion.QVDReader;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QVDtoCSVconversion
/*     */ {
/*     */   public static void main(String[] args) {
/*  30 */     QVDReader qvdReader = null;
/*  31 */     CSVWriter csvWriter = null;
/*  32 */     FileOutputStream fos = null;
/*     */     
/*  34 */     String paramQVDfile = "", paramCSVfile = "", paramNullTag = "";
/*  35 */     char paramDelimiter = '|';
/*     */     
/*  37 */     if (args.length >= 3 && !args[0].equals("")) {
/*  38 */       paramQVDfile = args[0];
/*  39 */       paramCSVfile = args[1];
/*  40 */       if (args[2].equals("\\t")) {
/*  41 */         paramDelimiter = '\t';
/*     */       } else {
/*  43 */         paramDelimiter = args[2].charAt(0);
/*     */       } 
/*  45 */       if (args.length >= 4) {
/*  46 */         paramNullTag = args[3];
/*     */       }
/*     */     } else {
/*  49 */       System.out.println("Program   : QVD to CSV file conversion");
/*  50 */       System.out.println("Copyright : TIQ Solutions 2012");
/*  51 */       System.out.println("License   : Demonstration");
/*  52 */       System.out.println("Author    : Ralf Becher");
/*  53 */       System.out.println("Contact   : info@tiq-solutions.de");
/*  54 */       System.out.println("Limitation: 10,000 rows");
/*  55 */       System.out.println("Parameters:");
/*  56 */       System.out.println("\t\t1. QVD file name");
/*  57 */       System.out.println("\t\t2. CSV file name");
/*  58 */       System.out.println("\t\t3. Delimiter char (e.g. \"|\" for pipe or \"\\t\" for tab)");
/*  59 */       System.out.println("\t\t4. Optional: tag for null values (e.g. \"<null>\")");
/*  60 */       System.out.println("Quoting   : none");
/*     */       
/*  62 */       System.exit(0);
/*     */     } 
/*     */     
/*     */     try {
/*  66 */       qvdReader = new QVDReader(paramQVDfile, paramNullTag);
/*     */     
/*     */     }
/*  69 */     catch (FileNotFoundException ex) {
/*  70 */       ex.printStackTrace();
/*  71 */       System.exit(1);
/*     */     } 
/*     */     
/*  74 */     System.out.println("Input : " + paramQVDfile);
/*  75 */     System.out.println("Output: " + paramCSVfile);
/*     */ 
/*     */     
/*     */     try {
/*  79 */       fos = new FileOutputStream(paramCSVfile);
/*  80 */       byte[] bom = { -17, -69, -65 };
/*  81 */       fos.write(bom);
/*     */       
/*  83 */       csvWriter = new CSVWriter(new OutputStreamWriter(fos), paramDelimiter, false, false);
/*  84 */       csvWriter.writeNext(doQouting(qvdReader.getFields(), paramDelimiter));
/*     */     }
/*  86 */     catch (IOException ex) {
/*  87 */       ex.printStackTrace();
/*  88 */       System.exit(1);
/*     */     } 
/*     */     
/*  91 */     long recno = 0L;
/*  92 */     while (qvdReader.hasRecord()) {
/*  93 */       csvWriter.writeNext(doQouting(qvdReader.getRecord(), paramDelimiter));
/*  94 */       recno++;
/*  95 */       if (recno % 2500L == 0L) System.out.println("QVD to CSV conversion: " + recno + " records written."); 
/*     */     } 
/*  97 */     if (recno == qvdReader.getNoOfRecords()) {
/*  98 */       System.out.println("QVD to CSV conversion finished. " + recno + " records written.");
/*     */     } else {
/* 100 */       System.out.println("QVD to CSV conversion finished. " + recno + " of " + qvdReader.getNoOfRecords() + " records written.");
/*     */     } 
/*     */     
/*     */     try {
/* 104 */       qvdReader.close();
/* 105 */       csvWriter.close();
/* 106 */     } catch (IOException ex) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] doQouting(String[] values, char delim) {
/* 112 */     for (int i = 0; i < values.length; i++) {
/* 113 */       if (values[i].indexOf(delim) >= 0) {
/* 114 */         values[i] = "\"" + values[i] + "\"";
/*     */       }
/*     */     } 
/* 117 */     return values;
/*     */   }
/*     */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\QVDtoCSVconversion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */