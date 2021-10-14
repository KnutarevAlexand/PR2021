package ru.ubrr.t1;


//����
public class Circle extends Ellipse implements CloneableShape<Circle> {

    private double r;//������

    public Circle (double r) {
        super(r, r);
        this.r = r;
    }
   
    
    @Override
    public Circle clone(double scale) {
       return new Circle(this.r * scale);
    }
}