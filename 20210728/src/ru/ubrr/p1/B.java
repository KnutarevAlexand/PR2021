package ru.ubrr.p1;


public class B extends A {
    static {    // ����������� �������� - ����������� ���� ������������
        System.out.println("static B");
    }
    {          // ������������ ���� �������������
        System.out.println("object B");
    }
    public B() {    //������ �����������
        System.out.println("Constructor B");
    }
    
    public void f() {} //����� ����� �� ���������������, ��.� � ������������ ������ ����� ����������� ������ private
    
}
