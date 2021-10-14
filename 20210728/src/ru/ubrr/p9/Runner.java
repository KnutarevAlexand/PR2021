package ru.ubrr.p9;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public void f() {
        System.out.println("f()");
    }
    
    public static void main(String[] args) {
        Box<Runner> b = new Box<>(new Runner());
        b.getThing().f(); // вызов метода внутри бокса без приведения ссылки
        
        List<String> L = new ArrayList<>(); //Generic нашело применение в Коллекциях
        L.add("aaaa"); //Создание элоемента коллекции
        //L.add(1); //Создание элемента коллекции, ошибка обнаружено на этапе компиляции т.к. срабол контроль на тип String
        
        System.out.println(L.size());// Колличество элементов коллекции
        String i = L.get(0); //Элемент коллекции
        //String i2 = L.get(1); //Элемент коллекции, ошибка обнаружено на этапе компиляции
        
    }
}
