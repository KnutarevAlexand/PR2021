package ru.ubrr.p1;

import java.time.LocalDate;


public class Passport {
 
    private static int currentNumber = 0;//пример статического контекста объявления переменных - примитивная переменная контекста класса
    
    private String id;// пример примитивных переменных объекта
    private String firstName = "Иван";
    private String lastName = "Иванов";
    private String issuer;
    private LocalDate issueDate;
    private String fullName;
    //private String fullName; {                  //пример блока для инициализации значений объекта
    //    fullName = firstName + ' ' + lastName;
    //}                                           //пример блока для инициализации значений объекта

    public Passport(String firstName, String lastName) {         //конструктор объекта для инициализации значений объекта, принимающий значения
        int currentNumber = 1;
        
        this.id = Integer.toString(Passport.currentNumber++);
        this.firstName = firstName; //инициализируем переменные
        this.lastName = lastName;   //инициализируем переменные
        fullName = firstName + ' ' + lastName;
    }                                                           //конструктор объекта для инициализации значений объекта, принимающий значения
    //public Passport() {         //конструктор объекта по умолчанию
    //}
    public Passport getCopy() {                                     //пример метода
        Passport p = new Passport(this.firstName+" 2", this.lastName+" 2");
        return p;
        //return this;//возврат ссылки на существующий объект, тоже самое что и выше 2 строки
    }                                                               //пример метода
    public static void getCurrentNumber() { //пример статического контекста объявления метода - метод контекста класса. Если метод ничего не возвращает, то нужна деклорация void
        System.out.println("The current number is: " + currentNumber); 
    }

    public static void main(String[] args) {
        Passport.getCurrentNumber();    //пример вызова статичсекого метода
        getCurrentNumber(); //пример вызова статичсекого метода (аналогично строки выше)

        //Passport p = new Passport();  //вызов конструктора созданного по умолчанию
        Passport p = new Passport("Алексей","Золотарев");
        Passport p2 = new Passport("Леонид","Андреев");
        System.out.println(p.firstName);
        System.out.println(p.fullName);
        System.out.println(p.getCopy().fullName);
        System.out.println(p.fullName);
        System.out.println(p.getId() + ": " + p.getFullName());
        System.out.println(p2.getId() + ": " + p2.getFullName());
        p.getCurrentNumber();
        p2.getCurrentNumber();
        Passport.getCurrentNumber();    //пример вызова статичсекого метода
        getCurrentNumber(); //пример вызова статичсекого метода (аналогично строки выше)
    }

// набор методов для получения переменных

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }
}
