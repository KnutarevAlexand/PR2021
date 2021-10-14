package qvdreader;

/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WildCardFileFilter
/*     */   implements FileFilter
/*     */ {
/*     */   private String _pattern;
/*     */   
/*     */   public WildCardFileFilter(String pattern) {
/* 149 */     this._pattern = QVDSearchSymbols.access$000(pattern);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean accept(File file) {
/* 155 */     return Pattern.compile(this._pattern).matcher(file.getName()).find();
/*     */   }
/*     */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\QVDSearchSymbols$WildCardFileFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */