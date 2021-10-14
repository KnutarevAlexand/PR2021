package p7;

import java.io.Serializable;


public class CreditCard implements Serializable{//имплементация класса 
    
    private Person p = new Person("Александр","Сергеевич","Пушкин");
    private String cardNumber;
    private transient int csn; //transient указываем, где эту переменную не нужно серриализовать, нужно для регуляции
    
    public CreditCard(String cardNumber, int csn) {
        this.cardNumber = cardNumber;
        this.csn = csn;
    }
    
    public String toString() {
        return this.cardNumber + "(" + this.csn + ")";
    }
}
