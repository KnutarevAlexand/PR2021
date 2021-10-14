/*    */ package qvdreader.de.tiq.solutions.data.conversion.qvd;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.InputStream;
/*    */ import javax.xml.bind.JAXBContext;
/*    */ import javax.xml.bind.JAXBException;
/*    */ import javax.xml.bind.Unmarshaller;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QvdTableHeaderUnmarshaller
/*    */ {
/*    */   public static QvdTableHeader readQvdTableHeader(String xmlFile) {
/*    */     try {
/* 30 */       return unmarshal(xmlFile);
/*    */     }
/* 32 */     catch (JAXBException ex) {
/* 33 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static QvdTableHeader readQvdTableHeader(InputStream is) {
/*    */     try {
/* 40 */       return unmarshal(is);
/*    */     }
/* 42 */     catch (JAXBException ex) {
/* 43 */       ex.printStackTrace();
/* 44 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static QvdTableHeader unmarshal(String xmlFile) throws JAXBException {
/* 52 */     JAXBContext jaxbContext = JAXBContext.newInstance(getQvdHeaderInstance().getClass().getPackage().getName());
/* 53 */     Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
/*    */ 
/*    */     
/* 56 */     return (QvdTableHeader)unmarshaller.unmarshal(new File(xmlFile));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static QvdTableHeader unmarshal(InputStream is) throws JAXBException {
/* 62 */     JAXBContext jaxbContext = JAXBContext.newInstance(getQvdHeaderInstance().getClass().getPackage().getName());
/* 63 */     Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
/*    */ 
/*    */     
/* 66 */     return (QvdTableHeader)unmarshaller.unmarshal(is);
/*    */   }
/*    */ 
/*    */   
/*    */   private static QvdTableHeader getQvdHeaderInstance() {
/* 71 */     ObjectFactory of = new ObjectFactory();
/* 72 */     return of.createQvdTableHeader();
/*    */   }
/*    */ }


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\qvd\QvdTableHeaderUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */