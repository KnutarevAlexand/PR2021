package ru.ubrr.t1;


//����� ��������������
public class Parallelogramm extends Shape {


    protected double a;//�������
    protected double h;//������

    public Parallelogramm(double a, double h) {
        this.a = a;
        this.h = h;
    }
    public double getArea() {
       return a*h;
    }
}
