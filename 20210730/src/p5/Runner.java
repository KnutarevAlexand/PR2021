package p5;


public class Runner {


    public void m() throws MyException, BadException {
        
        if(Math.random() >0.5) {
            throw new BadException("m() caused an exception: bad");
        } else {
            throw new MyException("m() caused an exception: my");
        }
        
    }
    
    public static void main(String[] args) {
        
        try {
            new Runner().m();
            System.out.println("THE END");
        } catch (Exception my) {
            System.out.println(my.getMessage());// метод из суперкласса Exception согласно иерархии классов
        } finally {
            System.out.println("FINISH");
        }

        
        

    }
}
