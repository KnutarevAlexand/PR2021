package p7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.time.LocalDate;
import java.time.LocalDateTime;

//серриализации и десерриализация

public class Tester {
    
    public static void serialize(String path, CreditCard c) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(c);
        oos.close();
    }
    
    public static CreditCard deserialize(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))  ;
        CreditCard cc = (CreditCard)(ois.readObject());
        ois.close();
        return cc;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        long ctime = System.currentTimeMillis();//время в миллисекундах от 1970 года

        LocalDateTime ldt = LocalDateTime.now();//текущее время и дата
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
        
        serialize("C:\\JDeveloper\\mywork\\javaprogramming\\KnutarevAlexandr\\20210802\\src\\p7\\new_bin_file", new CreditCard("1234-5678-1234-4321", 123));//создаем бинарный файл
        System.out.println(deserialize("C:\\JDeveloper\\mywork\\javaprogramming\\KnutarevAlexandr\\20210802\\src\\p7\\new_bin_file"));//восстанавливаем строку из бинарного файл
        
        System.out.println(System.currentTimeMillis() - ctime);// время исполнения скрипта
    }
}
