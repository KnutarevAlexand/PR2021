package p8;

import java.time.LocalDate;
import java.time.LocalDateTime;

//Утверждения
public class Runner {
    

    public static void main(String[] args)  {
             
        
        long ctime = System.currentTimeMillis();

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.plusDays(35).plusHours(23));
        System.out.println(ldt);
        
        System.out.println("");
        
        LocalDate ld = LocalDate.now();
        System.out.println(ld);
        System.out.println(ld.getDayOfWeek());
        System.out.println(ld.plusDays(35));
        System.out.println(ld);
        
        //if() {
        assert false: "Выполнилось условие if";// выбрасываем ассерты если исполнилось условие (не забудь вставить аттрибут при запуске приложения launch settings>Java settings: -ea для отладки приложения
        //}
        

    }
}
