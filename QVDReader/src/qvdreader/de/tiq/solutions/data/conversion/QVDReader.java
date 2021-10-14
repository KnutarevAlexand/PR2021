package qvdreader.de.tiq.solutions.data.conversion;

import qvdreader.de.tiq.solutions.data.conversion.qvd.QvdTableHeader;
import qvdreader.de.tiq.solutions.data.conversion.qvd.QvdTableHeaderUnmarshaller;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.UUID;
import org.apache.jdbm.DB;
import org.apache.jdbm.DBMaker;

public class QVDReader implements Iterator {
  private boolean c = false;
  
  private InputStream d = null;
  
  private InputStream e = null;
  
  private QvdTableHeader f = null;
  
  private long g = 0L;
  
  private long h = 0L;
  
  private int i = 0;
  
  private long j = 0L;
  
  private int k = 0;
  
  private int l = 0;
  
  private boolean m = false;
  
  private long n = 0L;
  
  private boolean o = false;
  
  private boolean p = false;
  
  private byte[] q;
  
  private String[] r;
  
  private String[] s;
  
  private int[] t;
  
  private DB[] u;
  
  private SortedMap[] v;
  
  private List[] w;
  
  private String x;
  
  private String y;
  
  private TimeZone z = null;
  
  private final char[] A = new char[] { '0', '0', '0', '0', '0', '0', '0', '0' };
  
  int a = 319968;
  
  int b = 5;
  
  private b B;
  
  public QVDReader(String fileName) {
    this(fileName, null, "", false);
  }
  
  public QVDReader(String fileName, String[] fieldList) {
    this(fileName, fieldList, "", false);
  }
  
  public QVDReader(String fileName, String nullTag) {
    this(fileName, null, nullTag, false);
  }
  
  public QVDReader(String fileName, String[] fieldList, String nullTag) {
    this(fileName, fieldList, nullTag, false);
  }
  
  public QVDReader(String fileName, boolean useCache) {
    this(fileName, null, "", useCache);
  }
  
  public QVDReader(String fileName, String[] fieldList, boolean useCache) {
    this(fileName, fieldList, "", useCache);
  }
  
  public QVDReader(String fileName, String[] fieldList, String nullTag, boolean useCache) {
    ArrayList<Byte> arrayList = new ArrayList();
    try {
      d();
      this.p = a();
    } catch (Exception exception) {}
    if (this.p) {
      System.out.println("Starting QVDReader Lic., (c) TIQ Solutions, 2012");
    } else {
      System.out.println("Starting QVDReader Demo, (c) TIQ Solutions, 2012");
    } 
    System.out.println("------------------------------------------------");
    System.out.println("QVDReader processing file: " + fileName);
    this.z = Calendar.getInstance().getTimeZone();
    this.s = fieldList;
    this.y = nullTag;
    this.c = useCache;
    this.d = new BufferedInputStream(new FileInputStream(fileName));
    int i = 0;
    this.g = 0L;
    try {
      while ((i = this.d.read()) > 1) {
        this.g++;
        arrayList.add(new Byte((byte)i));
      } 
      this.g++;
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    this.q = new byte[arrayList.size()];
    byte b1 = 0;
    Iterator<Byte> iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      byte b2 = ((Byte)iterator.next()).byteValue();
      this.q[b1++] = b2;
    } 
    b();
  }
  
  private boolean a() {
    return b.a(this.B);
  }
  
  private void b() {
    this.e = new ByteArrayInputStream(this.q);
    QvdTableHeader qvdTableHeader = QvdTableHeaderUnmarshaller.readQvdTableHeader(this.e);
    this.k = qvdTableHeader.getFields().getQvdFieldHeader().size();
    this.h = qvdTableHeader.getNoOfRecords().longValue();
    this.i = qvdTableHeader.getRecordByteSize().intValue();
    this.o = (this.h > 0L);
    if (this.s != null && this.s.length > 0) {
      this.m = true;
      this.l = this.s.length;
    } else {
      this.l = this.k;
    } 
    this.r = new String[this.k];
    this.t = new int[this.k];
    byte b1;
    for (b1 = 0; b1 < this.k; b1++) {
      QvdTableHeader.Fields.QvdFieldHeader qvdFieldHeader = qvdTableHeader.getFields().getQvdFieldHeader().get(b1);
      this.r[b1] = qvdFieldHeader.getFieldName();
      this.t[b1] = b1;
      if (this.m) {
        this.t[b1] = -1;
        for (byte b2 = 0; b2 < this.l; b2++) {
          if (this.s[b2].equalsIgnoreCase(this.r[b1])) {
            this.t[b1] = b2;
            break;
          } 
        } 
      } 
    } 
    this.f = qvdTableHeader;
    this.x = System.getProperty("java.io.tmpdir") + UUID.randomUUID().toString();
    this.u = new DB[this.r.length];
    this.v = new SortedMap[this.r.length];
    this.w = new List[this.r.length];
    for (b1 = 0; b1 < this.r.length; b1++) {
      if (this.t[b1] >= 0)
        if (this.c) {
          this.u[b1] = DBMaker.openFile(this.x + b1).deleteFilesAfterClose().enableEncryption("password", false).disableTransactions().disableCacheAutoClear().enableHardCache().make();
          this.v[b1] = this.u[b1].createTreeMap(this.x + b1);
        } else {
          this.w[b1] = new ArrayList();
        }  
    } 
    c();
  }
  
  public String[] getFields() {
    if (this.f == null)
      b(); 
    return this.r;
  }
  
  public String getFieldName(int fieldNo) {
    if (this.f == null)
      b(); 
    return this.r[fieldNo];
  }
  
  public int getFieldNumber(String fieldName) {
    if (this.f == null)
      b(); 
    byte b1 = -1;
    for (byte b2 = 0; b2 < this.k; b2++) {
      if (this.r[b2].toLowerCase().startsWith(fieldName.toLowerCase())) {
        b1 = b2;
        break;
      } 
    } 
    return b1;
  }
  
  public long getFieldNoOfSymbols(int fieldNo) {
    if (this.f == null)
      b(); 
    return ((QvdTableHeader.Fields.QvdFieldHeader)this.f.getFields().getQvdFieldHeader().get(fieldNo)).getNoOfSymbols().longValue();
  }
  
  public String getFieldSymbol(int fieldNo, Long symbolNo) {
    if (this.f == null)
      b(); 
    return a(fieldNo, symbolNo);
  }
  
  private void c() {
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[8];
    boolean bool1 = false;
    boolean bool2 = false;
    ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
    ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
    byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
    byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
    if (this.f != null && this.n == 0L) {
      long[] arrayOfLong1 = new long[this.k];
      long[] arrayOfLong2 = new long[this.k];
      long[] arrayOfLong3 = new long[this.k];
      String[] arrayOfString = new String[this.k];
      byte b1;
      for (b1 = 0; b1 < this.k; b1++) {
        QvdTableHeader.Fields.QvdFieldHeader qvdFieldHeader = this.f.getFields().getQvdFieldHeader().get(b1);
        arrayOfLong1[b1] = qvdFieldHeader.getNoOfSymbols().longValue();
        arrayOfLong2[b1] = qvdFieldHeader.getOffset().longValue();
        arrayOfLong3[b1] = qvdFieldHeader.getLength().longValue();
        if (qvdFieldHeader.getNumberFormat().getType() != null) {
          arrayOfString[b1] = qvdFieldHeader.getNumberFormat().getType().toString();
        } else {
          arrayOfString[b1] = "";
        } 
      } 
      for (b1 = 0; b1 < this.k; b1++) {
        if (this.t[b1] >= 0) {
          bool1 = arrayOfString[b1].equals("DATE");
          bool2 = arrayOfString[b1].equals("TIMESTAMP");
          long l;
          for (l = 0L; l < arrayOfLong1[b1]; l++) {
            ArrayList<Byte> arrayList = new ArrayList();
            String str = "";
            try {
              int i;
              if ((i = this.d.read()) >= 0) {
                int j;
                this.g++;
                switch (i) {
                  case 1:
                    this.d.read(arrayOfByte1);
                    byteBuffer1.put(arrayOfByte1);
                    byteBuffer1.rewind();
                    if (bool2) {
                      str = a(byteBuffer1.getInt());
                    } else {
                      str = String.valueOf(byteBuffer1.getInt());
                    } 
                    byteBuffer1.clear();
                    this.g += 4L;
                    break;
                  case 2:
                    this.d.read(arrayOfByte2);
                    byteBuffer2.put(arrayOfByte2);
                    byteBuffer2.rewind();
                    if (bool2) {
                      str = b(Double.longBitsToDouble(byteBuffer2.getLong()));
                    } else {
                      str = NumberFormat.getInstance().format(Double.longBitsToDouble(byteBuffer2.getLong()));
                    } 
                    byteBuffer2.clear();
                    this.g += 8L;
                    break;
                  case 4:
                    while ((i = this.d.read()) >= 0) {
                      this.g++;
                      if (i == 0)
                        break; 
                      arrayList.add(new Byte((byte)i));
                    } 
                    str = a(arrayList);
                    break;
                  case 5:
                    j = this.d.read(arrayOfByte1);
                    this.g += j;
                    while ((i = this.d.read()) >= 0) {
                      this.g++;
                      if (i == 0)
                        break; 
                      arrayList.add(new Byte((byte)i));
                    } 
                    str = a(arrayList);
                    break;
                  case 6:
                    j = this.d.read(arrayOfByte2);
                    this.g += j;
                    while ((i = this.d.read()) >= 0) {
                      this.g++;
                      if (i == 0)
                        break; 
                      arrayList.add(new Byte((byte)i));
                    } 
                    str = a(arrayList);
                    break;
                } 
                a(b1, Long.valueOf(l), str);
                this.n++;
              } else {
                break;
              } 
            } catch (IOException iOException) {
              iOException.printStackTrace();
            } 
          } 
          if (this.c)
            this.u[b1].commit(); 
        } else {
          try {
            byte[] arrayOfByte = new byte[(int)arrayOfLong3[b1]];
            this.d.read(arrayOfByte);
          } catch (IOException iOException) {}
        } 
      } 
      System.out.println("Symbol cache has " + this.n + " entries.");
    } 
  }
  
  private String a(ArrayList paramArrayList) {
    byte[] arrayOfByte = new byte[paramArrayList.size()];
    null = "";
    byte b1 = 0;
    Iterator<Byte> iterator = paramArrayList.iterator();
    while (iterator.hasNext()) {
      byte b2 = ((Byte)iterator.next()).byteValue();
      arrayOfByte[b1++] = b2;
    } 
    return new String(arrayOfByte);
  }
  
  public String[] getRecord() {
    String[] arrayOfString1 = new String[1];
    String[] arrayOfString2 = new String[this.l];
    String[] arrayOfString3 = new String[this.k];
    long[] arrayOfLong = new long[this.k];
    byte b1;
    for (b1 = 0; b1 < this.k; b1++)
      arrayOfLong[b1] = -1L; 
    if (this.f == null)
      b(); 
    if (this.o) {
      this.j++;
      arrayOfString2 = new String[this.l];
      try {
        arrayOfString1[0] = "";
        int i = a(arrayOfString1, this.i);
        if (i == this.i) {
          for (b1 = 0; b1 < this.k; b1++) {
            if (this.t[b1] >= 0) {
              long l;
              int j = ((QvdTableHeader.Fields.QvdFieldHeader)this.f.getFields().getQvdFieldHeader().get(b1)).getBitOffset().intValue();
              int k = ((QvdTableHeader.Fields.QvdFieldHeader)this.f.getFields().getQvdFieldHeader().get(b1)).getBitWidth().intValue();
              short s = ((QvdTableHeader.Fields.QvdFieldHeader)this.f.getFields().getQvdFieldHeader().get(b1)).getBias();
              if (k == 0) {
                l = 0L;
              } else {
                l = Long.parseLong(a(arrayOfString1[0].substring(j, j + k)), 2);
                l += s;
              } 
              if (l < 0L) {
                arrayOfString2[this.t[b1]] = this.y;
              } else if (l == arrayOfLong[b1]) {
                arrayOfString2[this.t[b1]] = arrayOfString3[b1];
              } else {
                arrayOfString2[this.t[b1]] = a(b1, Long.valueOf(l));
                arrayOfString3[b1] = arrayOfString2[this.t[b1]];
                arrayOfLong[b1] = l;
              } 
            } 
          } 
          if (this.j == this.h || (!this.p && this.j > (this.a >> this.b)))
            this.o = false; 
        } else {
          this.o = false;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } 
    return arrayOfString2;
  }
  
  private int a(String[] paramArrayOfString, int paramInt) {
    byte b1 = 0;
    byte[] arrayOfByte = new byte[paramInt];
    StringBuilder stringBuilder = new StringBuilder(paramInt * 8);
    if (this.d.read(arrayOfByte) == paramInt) {
      for (byte b2 = 0; b2 < paramInt; b2++) {
        int i = arrayOfByte[b2] & 0xFF;
        b1++;
        stringBuilder.append(b(Long.toBinaryString(i)));
      } 
      paramArrayOfString[0] = stringBuilder.toString();
    } else {
      this.o = false;
    } 
    return b1;
  }
  
  private String a(String paramString) {
    return (new StringBuilder(paramString)).reverse().toString();
  }
  
  private String b(String paramString) {
    return (new StringBuilder(paramString)).reverse().append(this.A, paramString.length(), 8 - paramString.length()).toString();
  }
  
  private String a(int paramInt, Long paramLong) {
    return this.c ? this.v[paramInt].get(paramLong) : this.w[paramInt].get(paramLong.intValue());
  }
  
  private void a(int paramInt, Long paramLong, String paramString) {
    if (this.c) {
      this.v[paramInt].put(paramLong, paramString);
    } else {
      this.w[paramInt].add(paramString);
    } 
  }
  
  private String a(double paramDouble) {
    return SimpleDateFormat.getDateInstance().format(c(paramDouble));
  }
  
  private String b(double paramDouble) {
    return SimpleDateFormat.getDateTimeInstance().format(c(paramDouble));
  }
  
  private Date c(double paramDouble) {
    Date date = new Date((long)Math.floor((paramDouble - 25569.0D) * 8.64E7D - this.z.getRawOffset()));
    if (this.z.inDaylightTime(date))
      date = new Date(date.getTime() - 3600000L); 
    return date;
  }
  
  public void close() {
    this.d.close();
    this.e.close();
    if (this.c)
      for (byte b1 = 0; b1 < this.r.length; b1++) {
        if (this.t[b1] >= 0)
          this.u[b1].close(); 
      }  
  }
  
  public boolean hasRecord() {
    return this.o;
  }
  
  public long getRecordNumber() {
    return this.j;
  }
  
  public long getNoOfRecords() {
    return this.h;
  }
  
  public long getNoOfFields() {
    return this.k;
  }
  
  private void d() {
    this.B = new b(getClass().getResourceAsStream("/lic/license"), getClass().getResourceAsStream("/lic/signature"), getClass().getResourceAsStream("/lic/public.key"), null);
  }
  
  public boolean hasNext() {
    return hasRecord();
  }
  
  public String[] next() {
    return getRecord();
  }
  
  public void remove() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}


/* Location:              C:\Users\operator\Desktop\QVDReader.jar!\de\tiq\solutions\data\conversion\QVDReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */