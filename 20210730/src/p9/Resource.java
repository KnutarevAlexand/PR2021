package p9;


public class Resource  implements AutoCloseable {//������������
   
    public void open() {
        System.out.println("OPEN");

    }
    public void close() {
        System.out.println("CLOSE");

    }
}
