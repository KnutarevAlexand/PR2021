package ru.ubrr.p1;


public class A {
    static {    // ����������� �������� - ����������� ���� ������������
        System.out.println("static A");
    }
    {          // ������������ ���� �������������
        System.out.println("object A");
    }
    public A() {    //������ �����������
        System.out.println("Constructor A");
    }
     static {
        System.out.println("static A2");
    }
     private void f() {}
}
