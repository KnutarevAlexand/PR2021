package p6;


public class Runner {


    public void m() throws MyException {
        
        throw new MyException("m() caused an exception: my");
        
        }
     
    public static void main(String[] args) {
     
        
        try {
        
        try {
            new Runner().m();
            System.out.println("THE END");
        } finally {
            System.out.println("FINISH");
        }

        } catch (MyException m) {
            System.out.println(((MyException)m.getSuppressed()[0]).whatHappenes());//получение подавленного/перекрытого исключения
    
        }
        

    }
}
