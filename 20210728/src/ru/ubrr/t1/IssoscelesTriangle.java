package ru.ubrr.t1;


//����� �������������� �����������
public class IssoscelesTriangle extends Triangle {

    static private double a;//������� a
    static private double b;//������� b
    static private double c;//������� c    
    private double u;//���������
    private double h;//������

    public IssoscelesTriangle (double u, double h) {
        super(a, b, c);
        this.u = u;
        this.h = h;
        s = (double)1/2*u*h;
    }
}
