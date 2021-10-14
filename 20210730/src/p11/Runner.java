package p11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        //List - интерфейс реализации коллекуии через упорядоченный список элементов коллекции
        //Map, Set, SortedMap, SortedSet, Iterator - другие интерфейсы реализации коллекуии
        List t = new LinkedList();//Создание коллекции - реализуется классом LinkedList через призму интерфейса List
        t.add("Earth");//добавление элемента коллекции
        t.add("Mars");
        t.add("Pluto");
        
        System.out.println(t.size());// распечатаем размер коллекции
        
        for(int i=0; i < t.size(); i++) {
            String element = (String)t.get(i);
            System.out.println(element);//распечатаем элементы коллекции с приведением типа      
        }
        
        t.remove(1);
 
        System.out.println(t.size());// распечатаем размер коллекции
        
        for(int i=0; i < t.size(); i++) {
            String element = (String)t.get(i);//распечатаем элементы коллекции с приведением типа
            System.out.println(element);         
        }       

    }
}
