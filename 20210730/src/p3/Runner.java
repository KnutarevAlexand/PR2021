package p3;

import p2.MyException;

public class Runner {


    public void m() throws MyException {//объ€влено что во врем€ работы может произойти выброс исключени€
        
        if(Math.random() >0.5) {
            System.out.println("Success");
        } else {
            throw new MyException("m() caused an exception");//возбуждение исключени€
        }
        
    }
    
    public static void main(String[] args) throws Exception {//сами обрабатываем исключение
        
        try { // самый простой обработчик исключений try catch
            new Runner().m();
            System.out.println("FINISH");
        } catch (MyException e) {
            System.out.println("The random number was bad");
            System.out.println( e.whatHappenes() );//выбрасываем исключение
            throw e; 
        } finally { // блок filally добавл€ют когда он нужен выполнить при завершающей активности
            System.out.println("FINISH");
        }

        
        

    }
}
