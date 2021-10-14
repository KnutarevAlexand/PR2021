package p11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        //List - ��������� ���������� ��������� ����� ������������� ������ ��������� ���������
        //Map, Set, SortedMap, SortedSet, Iterator - ������ ���������� ���������� ���������
        List t = new LinkedList();//�������� ��������� - ����������� ������� LinkedList ����� ������ ���������� List
        t.add("Earth");//���������� �������� ���������
        t.add("Mars");
        t.add("Pluto");
        
        System.out.println(t.size());// ����������� ������ ���������
        
        for(int i=0; i < t.size(); i++) {
            String element = (String)t.get(i);
            System.out.println(element);//����������� �������� ��������� � ����������� ����      
        }
        
        t.remove(1);
 
        System.out.println(t.size());// ����������� ������ ���������
        
        for(int i=0; i < t.size(); i++) {
            String element = (String)t.get(i);//����������� �������� ��������� � ����������� ����
            System.out.println(element);         
        }       

    }
}
