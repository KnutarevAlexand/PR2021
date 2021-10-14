package t3;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;


public class Hash_Set {

    public static void main(String[] args) {
 
        //���������� ���������
        long m = System.currentTimeMillis();
        Set<Integer> t = new HashSet<Integer>();
        for(int i = 0; i < 10; i++) {
            Random rand = new Random();
            int ix = rand.nextInt();
            t.add(ix);
        }
        System.out.println("������ ���������: " + t.size());
        System.out.println("����� ���������� ��������� ��: " + (System.currentTimeMillis() - m));

         //����� �����
        m = System.currentTimeMillis();
        System.out.println("����� ��������� ���������: " + t.stream().mapToInt(Integer::intValue).sum());
        System.out.println("����� ��������� ��������� ��: " + (System.currentTimeMillis() - m));

     
        int max = Collections.max(t, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        });

        
        System.out.println("���������� �� ��������� ��������� � ������� ���������:");
        Iterator<Integer> i = t.iterator();
        while (i.hasNext()) System.out.println(i.next());
        
        System.out.println("Max val: " + max);
        System.out.println("Max val: " + Collections.max(t,null));
        System.out.println("Max val: " + Collections.max(t)); 
        
 
        
        

    }
}
