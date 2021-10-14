package ru.ubrr.p3;


public class Runner {
    public static void main(String[] args) {
        SympleSecurityFunction ssf = new SympleSecurityFunction();
        ssf.info();
        System.out.println(ssf.encrypt("1qwerty"));
        ssf.trace("trace message"); //���������� ������ ����� �� ���������� �.�. � ������ ��� ��������
 
        SecurityFunction sf = ssf;  //�������� ������ �� ������ �� ������
        ScreenPrinter sp = ssf; //�������� ������ �� ������ �� ������
        ComplexSecurityFunction csf = ssf; //�������� ������ �� ������ �� ������
        
        System.out.println(sf.decrypt("encryptedData"));    //������������� ������� ��. ����������
        sp.printOnScreen();                                 //������������� ������� ��. ����������
        
        SecurityFunction.display();  //����� ����������� ������� ����������

    }
}
