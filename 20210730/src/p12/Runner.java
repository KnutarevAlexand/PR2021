package p12;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        //Map - ��������� ���������� ��������� ����� ������ ��������� ����-��������
        Map m = new HashMap();//�������� ��������� - ����������� ������� HashMap ����� ������ ���������� Map
        m.put("1","Earth");//���������� �������� ���������
        m.put("2","Mars");
        m.put("3","Pluto");
        m.put("4","Pluto");
        
        System.out.println(m.size());// ����������� ������ ���������
        
        Iterator keys = m.keySet().iterator();
        while(keys.hasNext()) {
            String key = (String)keys.next();
            String planet = (String)m.get(key);
            System.out.println(key + "->" + planet);//����������� �������� ��������� � ����������� ����
        }
        

 
      

    }
}
