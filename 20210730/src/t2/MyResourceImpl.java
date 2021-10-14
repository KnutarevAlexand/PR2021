package t2;


public class MyResourceImpl implements MyResource   {
    public void open() throws ComplexOpException {
        System.out.println("OPEN resource");
    };
    public void close() throws ComplexOpException {
        System.out.println("CLOSE resource");
    };
    public void write(byte[] b) throws ComplexOpException {
        System.out.println("WRITE resource");
    };
}
