package ru.ubrr.p1;


public class Passport extends Document {
   
    static private int idNum;
    private String fio;
    
    public Passport(String fio) {
        super( Integer.toString(idNum++));
        this.fio = fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }
    
    public boolean isValid() {  // ��������������� ������
        return false;
    }
    
}
