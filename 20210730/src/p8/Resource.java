package p8;


public class Resource  implements AutoCloseable {//автозакрытие
   
    public void open() {
        System.out.println("OPEN");

    }
    public void close() {
        System.out.println("CLOSE");

    }
}
