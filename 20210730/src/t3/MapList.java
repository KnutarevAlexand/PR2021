package t3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapList {

    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<Integer,String>();
        m.put(1,"����");
        m.put(2,"������");
        m.put(5,"���");
        m.put(4,"������");
        
        System.out.println("������ ���������: " + m.size());
        
        Iterator<Integer> keys = m.keySet().iterator();
        while(keys.hasNext()) {
            Integer key = keys.next();
            String value = m.get(key);
            System.out.println(key + "->" + value);
        }
        
        
        
    }
}
