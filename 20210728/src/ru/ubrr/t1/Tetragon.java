package ru.ubrr.t1;


//����� ���������������
public class Tetragon extends Shape {

    private double d1;//��������� 1
    private double d2;//��������� 2
    private double angle;//���� ����� �����������
    
    public Tetragon(double d1, double d2, double angle) {
        this.d1 = d1;
        this.d2 = d2;
        this.angle = angle;
    }
    
    public double getArea() {
       return (double)1/2*d1*d2*Math.sin(Math.toRadians(angle));
    }
}
