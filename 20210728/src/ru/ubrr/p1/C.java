package ru.ubrr.p1;


public class C extends B {
    static {    // ����������� �������� - ����������� ���� ������������
        System.out.println("static C");
    }
    {          // ������������ ���� �������������
        System.out.println("object C");
    }
    public C() {    //������ �����������
        System.out.println("Constructor C");
    }
}
