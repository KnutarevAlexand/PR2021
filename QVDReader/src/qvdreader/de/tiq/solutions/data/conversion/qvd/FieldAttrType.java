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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @XmlType(name = "FieldAttrType")
/*    */ @XmlEnum
/*    */ public enum FieldAttrType
/*    */ {
/* 38 */   UNKNOWN,
/* 39 */   ASCII,
/* 40 */   DATE,
/* 41 */   TIMESTAMP,
/* 42 */   INTEGER,
/* 43 */   REAL;
/*    */   
/*    */   public String value() {
/* 46 */     return name();
/*    */   }
/*    */   
/*    */   public static FieldAttrType fromValue(String v) {
/* 50 */     return valueOf(v);
/*    */   }
/*    */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\qvd\FieldAttrType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */