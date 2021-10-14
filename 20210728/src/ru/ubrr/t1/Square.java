package ru.ubrr.t1;


// ласс  вадрат
public class Square extends Rectangle implements CloneableShape<Square> {
    

    
    public Square(double a) {
        super(a, a);       
    }


    @Override
    public Square clone(double scale) {
       return new Square(this.a * scale);
    }
}
