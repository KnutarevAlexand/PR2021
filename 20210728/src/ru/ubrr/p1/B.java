package ru.ubrr.p1;


public class B extends A {
    static {    // статический контекст - статический блок иницализации
        System.out.println("static B");
    }
    {          // динамический блок инициализации
        System.out.println("object B");
    }
    public B() {    //пустой конструктор
        System.out.println("Constructor B");
    }
    
    public void f() {} //новый метод не переопределение, тк.к в родительском классе стоит модификатор достпа private
    
}
