import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        
        
        List l = new ArrayList(); // ������� ���������, ��� ������������ ���������� ���� Error > OutOfMemoryError: Java heap space �� 11 ������ ����
        int i = 0;
        while(true) {
            l.add("����");
            if(i++%1000 == 0) {
                System.out.println(i);
            }
        }
        
    }
}
