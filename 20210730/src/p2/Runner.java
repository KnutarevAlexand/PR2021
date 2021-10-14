package p2;


public class Runner {


    public void m() throws MyException {//объ€влено что во врем€ работы может произойти выброс исключени€
        
        if(Math.random() >0.5) {
            System.out.println("Success");
        } else {
            throw new MyException("m() caused an exception");//возбуждение исключени€
        }
        
    }
    
    public static void main(String[] args) throws Exception{//пробрасываем исключение выше
 /*       
        int a = 10;
        int b = 1;
        
        System.out.println(a/(b-1));// операци€ делени€ на ноль на 10 строке
        
        int[] arr = new int[3];
        arr[4] =1;// ошибка выхода за пределы массива
*/        
        new Runner().m();
        

    }
}
