package ru.ubrr.t1;


//������
public abstract class Shape {

    public final double PI = 3.14;//����� pi  ��������
    protected int id = Random.getRandom(1,1000);// �� ������
    protected double s;//�������
    protected String color = Colors.getColor().toString();//����
    
    protected abstract double getArea();
}
