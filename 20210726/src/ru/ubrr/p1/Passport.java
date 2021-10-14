package ru.ubrr.p1;

import java.time.LocalDate;


public class Passport {
 
    private static int currentNumber = 0;//������ ������������ ��������� ���������� ���������� - ����������� ���������� ��������� ������
    
    private String id;// ������ ����������� ���������� �������
    private String firstName = "����";
    private String lastName = "������";
    private String issuer;
    private LocalDate issueDate;
    private String fullName;
    //private String fullName; {                  //������ ����� ��� ������������� �������� �������
    //    fullName = firstName + ' ' + lastName;
    //}                                           //������ ����� ��� ������������� �������� �������

    public Passport(String firstName, String lastName) {         //����������� ������� ��� ������������� �������� �������, ����������� ��������
        int currentNumber = 1;
        
        this.id = Integer.toString(Passport.currentNumber++);
        this.firstName = firstName; //�������������� ����������
        this.lastName = lastName;   //�������������� ����������
        fullName = firstName + ' ' + lastName;
    }                                                           //����������� ������� ��� ������������� �������� �������, ����������� ��������
    //public Passport() {         //����������� ������� �� ���������
    //}
    public Passport getCopy() {                                     //������ ������
        Passport p = new Passport(this.firstName+" 2", this.lastName+" 2");
        return p;
        //return this;//������� ������ �� ������������ ������, ���� ����� ��� � ���� 2 ������
    }                                                               //������ ������
    public static void getCurrentNumber() { //������ ������������ ��������� ���������� ������ - ����� ��������� ������. ���� ����� ������ �� ����������, �� ����� ���������� void
        System.out.println("The current number is: " + currentNumber); 
    }

    public static void main(String[] args) {
        Passport.getCurrentNumber();    //������ ������ ������������ ������
        getCurrentNumber(); //������ ������ ������������ ������ (���������� ������ ����)

        //Passport p = new Passport();  //����� ������������ ���������� �� ���������
        Passport p = new Passport("�������","���������");
        Passport p2 = new Passport("������","�������");
        System.out.println(p.firstName);
        System.out.println(p.fullName);
        System.out.println(p.getCopy().fullName);
        System.out.println(p.fullName);
        System.out.println(p.getId() + ": " + p.getFullName());
        System.out.println(p2.getId() + ": " + p2.getFullName());
        p.getCurrentNumber();
        p2.getCurrentNumber();
        Passport.getCurrentNumber();    //������ ������ ������������ ������
        getCurrentNumber(); //������ ������ ������������ ������ (���������� ������ ����)
    }

// ����� ������� ��� ��������� ����������

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }
}
