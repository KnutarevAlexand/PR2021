package ru.ubrr.t1;


//����� �������������� �����������
public class EquilaterialTriangle extends IssoscelesTriangle {


    static private double u;//���������
    static private double h;//������
    static private double a;//�������

    public EquilaterialTriangle (double a, double h) {
        super(u, h);
        EquilaterialTriangle.a = a;
        EquilaterialTriangle.h = h;
        s = (double)1/2*a*h;
    }
}
