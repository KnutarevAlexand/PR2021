package t3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapList {

    public static void main(String[] args) {
        Map<Integer,String> m = new HashMap<Integer,String>();
        m.put(1,"Один");
        m.put(2,"Девять");
        m.put(5,"Три");
        m.put(4,"Четыре");
        
        System.out.println("Размер коллекции: " + m.size());
        
        Iterator<Integer> keys = m.keySet().iterator();
        while(keys.hasNext()) {
            Integer key = keys.next();
            String value = m.get(key);
            System.out.println(key + "->" + value);
        }
        
        
        
    }
}
