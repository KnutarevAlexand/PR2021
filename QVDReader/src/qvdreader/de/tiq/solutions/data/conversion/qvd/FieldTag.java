/*    */ package qvdreader.de.tiq.solutions.data.conversion.qvd;
/*    */ 
/*    */import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlType(name = "FieldTag")
/*    */ @XmlEnum
/*    */ public enum FieldTag
/*    */ {
/* 38 */   $_NUMERIC("$numeric"),
/*    */   
/* 40 */   $_INTEGER("$integer"),
/*    */   
/* 42 */   $_ASCII("$ascii"),
/*    */   
/* 44 */   $_TEXT("$text"),
/*    */   
/* 46 */   $_TIMESTAMP("$timestamp");
/*    */   
/*    */   private final String value;
/*    */   
/*    */   FieldTag(String v) {
/* 51 */     this.value = v;
/*    */   }
/*    */   
/*    */   public String value() {
/* 55 */     return this.value;
/*    */   }
/*    */   
/*    */   public static FieldTag fromValue(String v) {
/* 59 */     for (FieldTag c : values()) {
/* 60 */       if (c.value.equals(v)) {
/* 61 */         return c;
/*    */       }
/*    */     } 
/* 64 */     throw new IllegalArgumentException(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\qvd\FieldTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */