/*     */ package qvdreader.de.tiq.solutions.data.conversion.qvd;
/*     */ 
/*     */import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name = "", propOrder = {})
/*     */ @XmlRootElement(name = "QvdTableHeader")
/*     */ public class QvdTableHeader
/*     */ {
/*     */   @XmlElement(name = "QvBuildNo", required = true)
/*     */   protected BigInteger qvBuildNo;
/*     */   @XmlElement(name = "CreatorDoc", required = true)
/*     */   protected String creatorDoc;
/*     */   @XmlElement(name = "CreateUtcTime")
/*     */   @XmlSchemaType(name = "dateTime")
/*     */   protected XMLGregorianCalendar createUtcTime;
/*     */   @XmlElement(name = "SourceCreateUtcTime")
/*     */   @XmlSchemaType(name = "dateTime")
/*     */   protected XMLGregorianCalendar sourceCreateUtcTime;
/*     */   @XmlElement(name = "SourceFileUtcTime")
/*     */   @XmlSchemaType(name = "dateTime")
/*     */   protected XMLGregorianCalendar sourceFileUtcTime;
/*     */   @XmlElement(name = "StaleUtcTime")
/*     */   @XmlSchemaType(name = "dateTime")
/*     */   protected XMLGregorianCalendar staleUtcTime;
/*     */   @XmlElement(name = "TableName", required = true)
/*     */   protected String tableName;
/*     */   @XmlElement(name = "SourceFileSize")
/*     */   protected BigInteger sourceFileSize;
/*     */   @XmlElement(name = "Fields", required = true)
/*     */   protected Fields fields;
/*     */   @XmlElement(name = "Compression", required = true)
/*     */   protected String compression;
/*     */   @XmlElement(name = "RecordByteSize", required = true)
/*     */   protected BigInteger recordByteSize;
/*     */   @XmlElement(name = "NoOfRecords", required = true)
/*     */   protected BigInteger noOfRecords;
/*     */   @XmlElement(name = "Offset", required = true)
/*     */   protected BigInteger offset;
/*     */   @XmlElement(name = "Length", required = true)
/*     */   protected BigInteger length;
/*     */   @XmlElement(name = "Comment", required = true)
/*     */   protected String comment;
/*     */   
/*     */   public BigInteger getQvBuildNo() {
/* 146 */     return this.qvBuildNo;
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
/*     */   public void setQvBuildNo(BigInteger value) {
/* 158 */     this.qvBuildNo = value;
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
/*     */   public String getCreatorDoc() {
/* 170 */     return this.creatorDoc;
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
/*     */   public void setCreatorDoc(String value) {
/* 182 */     this.creatorDoc = value;
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
/*     */   public XMLGregorianCalendar getCreateUtcTime() {
/* 194 */     return this.createUtcTime;
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
/*     */   public void setCreateUtcTime(XMLGregorianCalendar value) {
/* 206 */     this.createUtcTime = value;
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
/*     */   public XMLGregorianCalendar getSourceCreateUtcTime() {
/* 218 */     return this.sourceCreateUtcTime;
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
/*     */   public void setSourceCreateUtcTime(XMLGregorianCalendar value) {
/* 230 */     this.sourceCreateUtcTime = value;
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
/*     */   public XMLGregorianCalendar getSourceFileUtcTime() {
/* 242 */     return this.sourceFileUtcTime;
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
/*     */   public void setSourceFileUtcTime(XMLGregorianCalendar value) {
/* 254 */     this.sourceFileUtcTime = value;
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
/*     */   public XMLGregorianCalendar getStaleUtcTime() {
/* 266 */     return this.staleUtcTime;
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
/*     */   public void setStaleUtcTime(XMLGregorianCalendar value) {
/* 278 */     this.staleUtcTime = value;
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
/*     */   public String getTableName() {
/* 290 */     return this.tableName;
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
/*     */   public void setTableName(String value) {
/* 302 */     this.tableName = value;
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
/*     */   public BigInteger getSourceFileSize() {
/* 314 */     return this.sourceFileSize;
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
/*     */   public void setSourceFileSize(BigInteger value) {
/* 326 */     this.sourceFileSize = value;
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
/*     */   public Fields getFields() {
/* 338 */     return this.fields;
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
/*     */   public void setFields(Fields value) {
/* 350 */     this.fields = value;
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
/*     */   public String getCompression() {
/* 362 */     return this.compression;
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
/*     */   public void setCompression(String value) {
/* 374 */     this.compression = value;
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
/*     */   public BigInteger getRecordByteSize() {
/* 386 */     return this.recordByteSize;
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
/*     */   public void setRecordByteSize(BigInteger value) {
/* 398 */     this.recordByteSize = value;
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
/*     */   public BigInteger getNoOfRecords() {
/* 410 */     return this.noOfRecords;
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
/*     */   public void setNoOfRecords(BigInteger value) {
/* 422 */     this.noOfRecords = value;
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
/*     */   public BigInteger getOffset() {
/* 434 */     return this.offset;
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
/*     */   public void setOffset(BigInteger value) {
/* 446 */     this.offset = value;
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
/*     */   public BigInteger getLength() {
/* 458 */     return this.length;
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
/*     */   public void setLength(BigInteger value) {
/* 470 */     this.length = value;
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
/*     */   public String getComment() {
/* 482 */     return this.comment;
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
/*     */   public void setComment(String value) {
/* 494 */     this.comment = value;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @XmlAccessorType(XmlAccessType.FIELD)
/*     */   @XmlType(name = "", propOrder = {"qvdFieldHeader"})
/*     */   public static class Fields
/*     */   {
/*     */     @XmlElement(name = "QvdFieldHeader", required = true)
/*     */     protected List<QvdFieldHeader> qvdFieldHeader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<QvdFieldHeader> getQvdFieldHeader() {
/* 578 */       if (this.qvdFieldHeader == null) {
/* 579 */         this.qvdFieldHeader = new ArrayList<QvdFieldHeader>();
/*     */       }
/* 581 */       return this.qvdFieldHeader;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @XmlAccessorType(XmlAccessType.FIELD)
/*     */     @XmlType(name = "", propOrder = {})
/*     */     public static class QvdFieldHeader
/*     */     {
/*     */       @XmlElement(name = "FieldName", required = true)
/*     */       protected String fieldName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "BitOffset", required = true)
/*     */       protected BigInteger bitOffset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "BitWidth", required = true)
/*     */       protected BigInteger bitWidth;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "Bias")
/*     */       protected short bias;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "NumberFormat", required = true)
/*     */       protected FieldAttributes numberFormat;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "NoOfSymbols", required = true)
/*     */       protected BigInteger noOfSymbols;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "Offset", required = true)
/*     */       protected BigInteger offset;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "Length", required = true)
/*     */       protected BigInteger length;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "Comment", required = true)
/*     */       protected String comment;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlElement(name = "Tags", required = true)
/*     */       protected Tags tags;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getFieldName() {
/* 659 */         return this.fieldName;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setFieldName(String value) {
/* 671 */         this.fieldName = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public BigInteger getBitOffset() {
/* 683 */         return this.bitOffset;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setBitOffset(BigInteger value) {
/* 695 */         this.bitOffset = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public BigInteger getBitWidth() {
/* 707 */         return this.bitWidth;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setBitWidth(BigInteger value) {
/* 719 */         this.bitWidth = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public short getBias() {
/* 727 */         return this.bias;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setBias(short value) {
/* 735 */         this.bias = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public FieldAttributes getNumberFormat() {
/* 747 */         return this.numberFormat;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setNumberFormat(FieldAttributes value) {
/* 759 */         this.numberFormat = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public BigInteger getNoOfSymbols() {
/* 771 */         return this.noOfSymbols;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setNoOfSymbols(BigInteger value) {
/* 783 */         this.noOfSymbols = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public BigInteger getOffset() {
/* 795 */         return this.offset;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setOffset(BigInteger value) {
/* 807 */         this.offset = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public BigInteger getLength() {
/* 819 */         return this.length;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setLength(BigInteger value) {
/* 831 */         this.length = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public String getComment() {
/* 843 */         return this.comment;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setComment(String value) {
/* 855 */         this.comment = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public Tags getTags() {
/* 867 */         return this.tags;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void setTags(Tags value) {
/* 879 */         this.tags = value;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       @XmlAccessorType(XmlAccessType.FIELD)
/*     */       @XmlType(name = "", propOrder = {"string"})
/*     */       public static class Tags
/*     */       {
/*     */         @XmlElement(name = "String", required = true)
/*     */         protected FieldTag string;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public FieldTag getString() {
/* 920 */           return this.string;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void setString(FieldTag value) {
/* 932 */           this.string = value;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\qvd\QvdTableHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */