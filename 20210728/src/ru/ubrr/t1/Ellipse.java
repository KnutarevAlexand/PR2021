package ru.ubrr.t1;


//����� ������
public class Ellipse extends Shape {

    private double r1;//������� �������
    private double r2;//����� �������

    public Ellipse(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }
    
    public double getArea() {
       return PI*r1*r2;
    }
}
