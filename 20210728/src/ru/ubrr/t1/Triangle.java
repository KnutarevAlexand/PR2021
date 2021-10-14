package ru.ubrr.t1;


//����� �����������
public class Triangle extends Shape {
    
    private double a;//������� a
    private double b;//������� b
    private double c;//������� c
       
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        s = (double) Math.sqrt(((a+b+c)/2)*(((a+b+c)/2)-a)*(((a+b+c)/2)-b)*(((a+b+c)/2)-c));
    }      
       
    public double getArea() {
       return s;
    }
}
