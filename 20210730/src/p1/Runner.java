import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        
        
        List l = new ArrayList(); // создали коллекцию, для демонстрации исключения типа Error > OutOfMemoryError: Java heap space на 11 строке кода
        int i = 0;
        while(true) {
            l.add("аааа");
            if(i++%1000 == 0) {
                System.out.println(i);
            }
        }
        
    }
}
