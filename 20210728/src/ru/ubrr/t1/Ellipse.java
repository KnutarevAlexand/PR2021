package ru.ubrr.t1;


// ласс Ёллипс
public class Ellipse extends Shape {

    private double r1;//больша€ полуось
    private double r2;//мала€ полуось

    public Ellipse(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }
    
    public double getArea() {
       return PI*r1*r2;
    }
}
