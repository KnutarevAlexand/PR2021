package qvdreader;

/*     */ import au.com.bytecode.opencsv.CSVWriter;
/*     */ import qvdreader.de.tiq.solutions.data.conversion.QVDReader;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QVDSearchSymbols
/*     */ {
/*     */   public static void main(String[] args) {
/*  36 */     String[] header = { "File", "Field", "SymNo", "Symbol" };
/*  37 */     String[] record = { "", "", "", "" };
/*  38 */     QVDReader qvdReader = null;
/*  39 */     CSVWriter csvWriter = null;
/*  40 */     FileOutputStream fos = null;
/*  41 */     String paramQVDpath = args[0];
/*  42 */     if (!paramQVDpath.endsWith("\\")) {
/*  43 */       paramQVDpath = paramQVDpath + "\\";
/*     */     }
/*  45 */     String paramQVDfile = args[1];
/*  46 */     String paramCSVfile = args[2];
/*  47 */     char paramDelimiter = args[3].substring(0, 1).toCharArray()[0];
/*  48 */     String paramSearch = args[4];
/*  49 */     String paramMode = "-all";
/*  50 */     if (args.length > 5) {
/*  51 */       paramMode = args[5].toLowerCase();
/*     */     }
/*     */     
/*  54 */     String paramRegex = wildcardToRegex(paramSearch);
/*  55 */     Pattern pattern = Pattern.compile(paramRegex);
/*     */     
/*  57 */     String path = paramQVDpath;
/*  58 */     String filepattern = paramQVDfile;
/*  59 */     File dir = new File(path);
/*  60 */     File[] files = dir.listFiles(new WildCardFileFilter(filepattern));
/*  61 */     String filename = "";
/*     */     
/*  63 */     System.out.println("Input : " + paramQVDpath + paramQVDfile);
/*  64 */     System.out.println("Output: " + paramCSVfile);
/*  65 */     System.out.println("Search: " + paramSearch);
/*  66 */     System.out.println("RegEx : " + paramRegex);
/*  67 */     System.out.println("Mode  : " + paramMode);
/*     */ 
/*     */     
/*     */     try {
/*  71 */       fos = new FileOutputStream(paramCSVfile);
/*  72 */       byte[] bom = { -17, -69, -65 };
/*  73 */       fos.write(bom);
/*     */       
/*  75 */       csvWriter = new CSVWriter(new OutputStreamWriter(fos), paramDelimiter, false, false);
/*  76 */       csvWriter.writeNext(header);
/*     */     }
/*  78 */     catch (IOException ex) {
/*  79 */       ex.printStackTrace();
/*  80 */       System.exit(1);
/*     */     } 
/*     */     
/*  83 */     long recno = 0L;
/*     */ 
/*     */     
/*  86 */     for (File file : files) {
/*  87 */       long found = 0L;
/*  88 */       filename = file.getName();
/*     */ 
/*     */       
/*     */       try {
/*  92 */         qvdReader = new QVDReader(path + filename);
/*     */       }
/*  94 */       catch (FileNotFoundException ex) {
/*  95 */         ex.printStackTrace();
/*  96 */         System.exit(1);
/*     */       } 
/*     */       
/*  99 */       record[0] = path + filename;
/*     */ 
/*     */       
/* 102 */       for (int col = 0; col < qvdReader.getNoOfFields(); col++) {
/* 103 */         record[1] = qvdReader.getFieldName(col);
/*     */         long sym;
/* 105 */         for (sym = 0L; sym < qvdReader.getFieldNoOfSymbols(col); sym++) {
/* 106 */           record[2] = Long.toString(sym);
/* 107 */           record[3] = qvdReader.getFieldSymbol(col, Long.valueOf(sym));
/* 108 */           if (pattern.matcher(record[3]).matches()) {
/* 109 */             csvWriter.writeNext(doQouting(record, paramDelimiter));
/* 110 */             found++;
/* 111 */             recno++;
/* 112 */             if (paramMode.equals("-first")) {
/*     */               break;
/*     */             }
/*     */           } 
/* 116 */           if (recno > 0L && recno % 2500L == 0L) {
/* 117 */             System.out.println("QVD symbol search: " + recno + " symbols processed.");
/*     */           }
/*     */         } 
/*     */       } 
/* 121 */       if (found > 0L) {
/* 122 */         System.out.println("QVD symbol search: found " + found + " occurances.");
/*     */       }
/*     */       try {
/* 125 */         qvdReader.close();
/* 126 */         qvdReader = null;
/* 127 */       } catch (IOException ex) {}
/*     */ 
/*     */       
/* 130 */       System.out.println("");
/*     */     } 
/*     */ 
/*     */     
/* 134 */     System.out.println("QVD symbol search finished. " + recno + " symbol records written.");
/*     */     
/*     */     try {
/* 137 */       csvWriter.close();
/* 138 */     } catch (IOException ex) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static class WildCardFileFilter
/*     */     implements FileFilter
/*     */   {
/*     */     private String _pattern;
/*     */ 
/*     */     
/*     */     public WildCardFileFilter(String pattern) {
/* 149 */       this._pattern = QVDSearchSymbols.wildcardToRegex(pattern);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean accept(File file) {
/* 155 */       return Pattern.compile(this._pattern).matcher(file.getName()).find();
/*     */     }
/*     */   }
/*     */   
/*     */   private static String wildcardToRegex(String wildcard) {
/* 160 */     StringBuilder s = new StringBuilder(wildcard.length());
/* 161 */     s.append('^');
/* 162 */     for (int i = 0, is = wildcard.length(); i < is; i++) {
/* 163 */       char c = wildcard.charAt(i);
/* 164 */       switch (c) {
/*     */         case '*':
/* 166 */           s.append(".*");
/*     */           break;
/*     */         case '?':
/* 169 */           s.append("."); break;
/*     */         case '$': case '(': case ')': case '.': case '[': case '\\': case ']':
/*     */         case '^':
/*     */         case '{':
/*     */         case '|':
/*     */         case '}':
/* 175 */           s.append("\\");
/* 176 */           s.append(c);
/*     */           break;
/*     */         default:
/* 179 */           s.append(c);
/*     */           break;
/*     */       } 
/*     */     } 
/* 183 */     s.append('$');
/* 184 */     return s.toString();
/*     */   }
/*     */   
/*     */   private static String[] doQouting(String[] values, char delim) {
/* 188 */     for (int i = 0; i < values.length; i++) {
/* 189 */       if (values[i].indexOf(delim) >= 0) {
/* 190 */         values[i] = "\"" + values[i] + "\"";
/*     */       }
/*     */     } 
/* 193 */     return values;
/*     */   }
/*     */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\QVDSearchSymbols.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */