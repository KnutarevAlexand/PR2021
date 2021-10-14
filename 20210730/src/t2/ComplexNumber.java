package t2;


public interface ComplexNumber<ComplexNumber> {
 
    public ComplexNumber add(ComplexNumber c);
    public ComplexNumber divide(ComplexNumber c) throws ComplexOpException;
    public boolean equals(Object obj);
 
}
