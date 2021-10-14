package ru.ubrr.p8;


public class Runner {
    public void f() {
        System.out.println("f()");
    }
    
    public static void main(String[] args) {
        Runner r = new Runner();
        Box b = new Box(r);
        ((Runner)b.getThing()).f();// приведение ссылки для обращения к методу класса внутри бокса
    }
}
