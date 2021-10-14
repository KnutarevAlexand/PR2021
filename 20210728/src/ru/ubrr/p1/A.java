package ru.ubrr.p1;


public class A {
    static {    // статический контекст - статический блок иницализации
        System.out.println("static A");
    }
    {          // динамический блок инициализации
        System.out.println("object A");
    }
    public A() {    //пустой конструктор
        System.out.println("Constructor A");
    }
     static {
        System.out.println("static A2");
    }
     private void f() {}
}
