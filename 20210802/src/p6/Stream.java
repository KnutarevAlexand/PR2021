package p6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Stream {   //внешний класс
    
    private String firstName, surName, patronymic;

    public Stream(String firstName, String patronymic, String surName) { 
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surName = surName;
    }

      
    public static void main(String[] args) throws FileNotFoundException, IOException {//обработка исключения при чтении файла
        
        //InputStream используется как интерфейс
        InputStream is = new FileInputStream("C:\\JDeveloper\\mywork\\javaprogramming\\KnutarevAlexandr\\20210802\\src\\p6\\test_1_000.qvd");//входной поток чтения файла
        OutputStream os = new FileOutputStream("C:\\JDeveloper\\mywork\\javaprogramming\\KnutarevAlexandr\\20210802\\src\\p6\\copy_test_1_000.qvd");
        byte[] buffer = new byte[1024];
        int hasread = 0;
        while(is.available() >0 ) {
            int read = is.read(buffer);
            os.write(buffer, 0, read);
            hasread += read;
        }
        is.close();//закрываем файловый хендлер
        os.close();
        System.out.println(hasread);//выводим размер файла в байтах

    }
    
}
