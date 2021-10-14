package ru.ubrr.p1;


public class C extends B {
    static {    // статический контекст - статический блок иницализации
        System.out.println("static C");
    }
    {          // динамический блок инициализации
        System.out.println("object C");
    }
    public C() {    //пустой конструктор
        System.out.println("Constructor C");
    }
}
