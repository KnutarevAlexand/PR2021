package ru.ubrr.p9;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public void f() {
        System.out.println("f()");
    }
    
    public static void main(String[] args) {
        Box<Runner> b = new Box<>(new Runner());
        b.getThing().f(); // ����� ������ ������ ����� ��� ���������� ������
        
        List<String> L = new ArrayList<>(); //Generic ������ ���������� � ����������
        L.add("aaaa"); //�������� ��������� ���������
        //L.add(1); //�������� �������� ���������, ������ ���������� �� ����� ���������� �.�. ������ �������� �� ��� String
        
        System.out.println(L.size());// ����������� ��������� ���������
        String i = L.get(0); //������� ���������
        //String i2 = L.get(1); //������� ���������, ������ ���������� �� ����� ����������
        
    }
}
