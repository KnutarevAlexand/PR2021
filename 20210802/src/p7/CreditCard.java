package p7;

import java.io.Serializable;


public class CreditCard implements Serializable{//������������� ������ 
    
    private Person p = new Person("���������","���������","������");
    private String cardNumber;
    private transient int csn; //transient ���������, ��� ��� ���������� �� ����� ��������������, ����� ��� ���������
    
    public CreditCard(String cardNumber, int csn) {
        this.cardNumber = cardNumber;
        this.csn = csn;
    }
    
    public String toString() {
        return this.cardNumber + "(" + this.csn + ")";
    }
}
