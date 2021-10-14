package t3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Linked_List {

    public static void main(String[] args) {
 
        //Наполнение коллекции
        long m = System.currentTimeMillis();
        List<Integer> t = new LinkedList<Integer>();
        for(int i = 0; i < 10; i++) {
            Random rand = new Random();
            int ix = rand.nextInt();
            t.add(ix);
        }
        System.out.println("Размер коллекции: " + t.size());
        System.out.println("Время наполнения коллекции мс: " + (System.currentTimeMillis() - m));

        //Изменение коллекции
        m = System.currentTimeMillis();
        for(int i = 0; i < 10; i++) {
            Random rand = new Random();
            int ix = rand.nextInt();
            t.set(i,ix);
        }
        System.out.println("Время изменения коллекции мс: " + (System.currentTimeMillis() - m));

        //Сумма чисел
        m = System.currentTimeMillis();
        System.out.println("Сумма элементов коллекции: " + t.stream().mapToInt(Integer::intValue).sum());
        System.out.println("Время изменения коллекции мс: " + (System.currentTimeMillis() - m));
        
        
        int max = Collections.max(t, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        });

        
        System.out.println("Проходимся по элементам коллекции с помощью итератора:");
        Iterator<Integer> i = t.iterator();
        while (i.hasNext()) System.out.println(i.next());
        
        System.out.println("Max val: " + max);
        System.out.println("Max val: " + Collections.max(t,null));
        System.out.println("Max val: " + Collections.max(t)); 

    }
}
