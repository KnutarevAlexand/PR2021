package t2;


public interface MyResource extends AutoCloseable  {
    public void open() throws ComplexOpException;
    public void close() throws ComplexOpException;
    public void write(byte[] b) throws ComplexOpException;
}
