package ru.ubrr.t1;


//����� ������������� �����������
public class RightTriangle extends Triangle {
    
    private double a;//�������
    private double b;//�������
    
    public RightTriangle (double a, double b, double c) {
        super(a, b, c);
        this.a = a;
        this.b = b;
        s = (double)1/2*a*b;
    }
}
