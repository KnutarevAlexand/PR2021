package p7;

import java.io.Serializable;


public class Person implements Serializable {   
    
    private String firstName, surName, patronymic;

    public Person(String firstName, String patronymic, String surName) { //��� �������� �� ������ �������
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surName = surName;
    }    


   
}
