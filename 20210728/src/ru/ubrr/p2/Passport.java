package ru.ubrr.p2;


public class Passport extends Document {

    private String fio;

    public Passport(String fio) {
        this.fio = fio;
    }
   
    public String getFio() {
        return fio;
    }

    public boolean isValid() {
        return this.getFio().isEmpty() ? false : true;
    }


}
