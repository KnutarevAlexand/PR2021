package p7;


public class Runner {


    public void m() throws MyException {
        
        throw new MyException("m() caused an exception: my");
        
        }
     
    public static void main(String[] args) {
        
        Resource r = new Resource();// ресурсом в жизни например может быть соединение с базой данных, когда нужно разрывать соединения через операцию close
        r.open();// гарантированное открытие ресурса
        try {
            new Runner().m();
        } catch (MyException e) {
                
        } finally {
            r.close();// гарантированное закрытие ресурса (может быть соединение с базой данных, когда нужно разрывать соединения через операцию close)
        }
    }
}
