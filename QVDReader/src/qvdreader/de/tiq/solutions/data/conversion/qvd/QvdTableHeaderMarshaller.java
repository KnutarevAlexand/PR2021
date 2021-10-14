/*     */ package qvdreader.de.tiq.solutions.data.conversion.qvd;
/*     */ 
/*     */import java.io.File;
import java.io.OutputStream;

import java.math.BigInteger;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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
/*     */ public class QvdTableHeaderMarshaller
/*     */ {
/*     */   static QvdTableHeader createQvdTableHeader(String table, String[] columns, boolean[] nullOccured, int[] bitOffset, int[] bitWidth, int[] noOfSymbols, int[] symbolsOffset, int[] symbolsLength, int recordByteSize, long noOfRecords, int recordOffset) {
/*  31 */     ObjectFactory of = new ObjectFactory();
/*     */     
/*  33 */     QvdTableHeader qvdHeader = of.createQvdTableHeader();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  42 */     qvdHeader.setQvBuildNo(new BigInteger("11282"));
/*  43 */     qvdHeader.setCreatorDoc("D:\\TIQSolutions\\Projects\\QVDConverter\\Demo.qvw");
/*     */ 
/*     */     
/*  46 */     GregorianCalendar gc = (GregorianCalendar)GregorianCalendar.getInstance();
/*  47 */     gc.setTimeZone(TimeZone.getTimeZone("UTC"));
/*  48 */     gc.setTime(new Date());
/*     */     
/*  50 */     DatatypeFactory dtf = null;
/*     */     try {
/*  52 */       dtf = DatatypeFactory.newInstance();
/*  53 */     } catch (DatatypeConfigurationException ex) {}
/*     */ 
/*     */     
/*  56 */     XMLGregorianCalendar xmlGregor = dtf.newXMLGregorianCalendar(gc);
/*     */     
/*  58 */     qvdHeader.setCreateUtcTime(xmlGregor);
/*  59 */     qvdHeader.setSourceCreateUtcTime(xmlGregor);
/*  60 */     qvdHeader.setSourceFileUtcTime(xmlGregor);
/*  61 */     qvdHeader.setSourceFileSize(new BigInteger("-1"));
/*  62 */     qvdHeader.setStaleUtcTime(xmlGregor);
/*  63 */     qvdHeader.setTableName(table);
/*     */     
/*  65 */     qvdHeader.setFields(of.createQvdTableHeaderFields());
/*     */     
/*  67 */     for (int i = 0; i < columns.length; i++) {
/*  68 */       QvdTableHeader.Fields.QvdFieldHeader field = of.createQvdTableHeaderFieldsQvdFieldHeader();
/*     */       
/*  70 */       field.setFieldName(columns[i]);
/*  71 */       field.setBitOffset(new BigInteger(bitOffset[i] + ""));
/*  72 */       field.setBitWidth(new BigInteger(bitWidth[i] + ""));
/*  73 */       if (nullOccured[i]) {
/*  74 */         field.setBias((short)-2);
/*     */       } else {
/*  76 */         field.setBias((short)0);
/*     */       } 
/*     */       
/*  79 */       FieldAttributes fa = of.createFieldAttributes();
/*  80 */       fa.setType(FieldAttrType.UNKNOWN);
/*  81 */       fa.setNDec(BigInteger.ZERO);
/*  82 */       fa.setUseThou(BigInteger.ZERO);
/*  83 */       fa.setFmt("");
/*  84 */       fa.setDec("");
/*  85 */       fa.setThou("");
/*  86 */       field.setNumberFormat(fa);
/*     */       
/*  88 */       field.setNoOfSymbols(new BigInteger(noOfSymbols[i] + ""));
/*  89 */       field.setOffset(new BigInteger(symbolsOffset[i] + ""));
/*  90 */       field.setLength(new BigInteger(symbolsLength[i] + ""));
/*  91 */       field.setComment("");
/*     */       
/*  93 */       qvdHeader.getFields().getQvdFieldHeader().add(field);
/*     */     } 
/*     */     
/*  96 */     qvdHeader.setCompression("");
/*  97 */     qvdHeader.setRecordByteSize(new BigInteger(recordByteSize + ""));
/*  98 */     qvdHeader.setNoOfRecords(new BigInteger(noOfRecords + ""));
/*  99 */     qvdHeader.setOffset(new BigInteger(recordOffset + ""));
/* 100 */     qvdHeader.setLength(new BigInteger((recordByteSize * noOfRecords) + ""));
/* 101 */     qvdHeader.setComment("");
/*     */     
/* 103 */     return qvdHeader;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeQvdTableHeader(OutputStream os, String table, String[] columns, boolean[] nullOccured, int[] bitOffset, int[] bitWidth, int[] noOfSymbols, int[] symbolsOffset, int[] symbolsLength, int recordByteSize, long noOfRecords, int recordOffset) {
/*     */     try {
/* 110 */       marshal(os, createQvdTableHeader(table, columns, nullOccured, bitOffset, bitWidth, noOfSymbols, symbolsOffset, symbolsLength, recordByteSize, noOfRecords, recordOffset), "UTF-8");
/*     */ 
/*     */     
/*     */     }
/* 114 */     catch (JAXBException ex) {}
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
/*     */   public static void marshal(String xmlFile, Object jaxbElement, String outputCharset) throws JAXBException {
/* 127 */     JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getClass().getPackage().getName());
/* 128 */     Marshaller marshaller = jaxbContext.createMarshaller();
/*     */     
/* 130 */     marshaller.setProperty("jaxb.encoding", outputCharset);
/* 131 */     marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
/* 132 */     marshaller.marshal(jaxbElement, new File(xmlFile));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void marshal(OutputStream os, Object jaxbElement, String outputCharset) throws JAXBException {
/* 139 */     JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getClass().getPackage().getName());
/* 140 */     Marshaller marshaller = jaxbContext.createMarshaller();
/*     */     
/* 142 */     marshaller.setProperty("jaxb.encoding", outputCharset);
/* 143 */     marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
/* 144 */     marshaller.marshal(jaxbElement, os);
/*     */   }
/*     */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\qvd\QvdTableHeaderMarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */