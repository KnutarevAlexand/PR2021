package p4;


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
        } catch (MyException my) {

            System.out.println( my.whatHappenes() );
        } catch (BadException bad) {

            System.out.println( bad.whatHappenes() );
        } finally {
            System.out.println("FINISH");
        }

        
        

    }
}
