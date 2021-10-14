package p12;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        //Map - интерфейс реализации коллекуии через список элементов ключ-значение
        Map m = new HashMap();//Создание коллекции - реализуется классом HashMap через призму интерфейса Map
        m.put("1","Earth");//добавление элемента коллекции
        m.put("2","Mars");
        m.put("3","Pluto");
        m.put("4","Pluto");
        
        System.out.println(m.size());// распечатаем размер коллекции
        
        Iterator keys = m.keySet().iterator();
        while(keys.hasNext()) {
            String key = (String)keys.next();
            String planet = (String)m.get(key);
            System.out.println(key + "->" + planet);//распечатаем элементы коллекции с приведением типа
        }
        

 
      

    }
}
