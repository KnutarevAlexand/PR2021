package p13;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        Map<String,String> m = new HashMap();//���������� generic ��� ���������������� �������� ��� ����������
        m.put("1","Earth");
        m.put("2","Mars");
        m.put("3","Pluto");
        m.put("4","Pluto");
        //������ ����������� ��������� ������� ������ �� ���������� ��������� ���� �������� ��������� ���� ����� �������� ���������
        //m.put("333",new Integer(1)); 
        
        System.out.println(m.size());
        
        Iterator<String> keys = m.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            String planet = m.get(key);//��� ������������� ��������� ���������� ����
            System.out.println(key + "->" + planet);
        }
    }
}
