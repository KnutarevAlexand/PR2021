/*     */ package qvdreader.de.tiq.solutions.data.conversion.qvd;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlElement;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 

/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "FieldAttributes", propOrder = {})
/*     */ public class FieldAttributes
/*     */ {
/*     */   @XmlElement(name = "Type", required = true)
/*     */   protected FieldAttrType type;
/*     */   protected BigInteger nDec;
/*     */   @XmlElement(name = "UseThou")
/*     */   protected BigInteger useThou;
/*     */   @XmlElement(name = "Fmt")
/*     */   protected String fmt;
/*     */   @XmlElement(name = "Dec")
/*     */   protected String dec;
/*     */   @XmlElement(name = "Thou")
/*     */   protected String thou;
/*     */   
/*     */   public FieldAttrType getType() {
/*  69 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setType(FieldAttrType value) {
/*  81 */     this.type = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger getNDec() {
/*  93 */     return this.nDec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNDec(BigInteger value) {
/* 105 */     this.nDec = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger getUseThou() {
/* 117 */     return this.useThou;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUseThou(BigInteger value) {
/* 129 */     this.useThou = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFmt() {
/* 141 */     return this.fmt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFmt(String value) {
/* 153 */     this.fmt = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDec() {
/* 165 */     return this.dec;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDec(String value) {
/* 177 */     this.dec = value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getThou() {
/* 189 */     return this.thou;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThou(String value) {
/* 201 */     this.thou = value;
/*     */   }
/*     */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\qvd\FieldAttributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */