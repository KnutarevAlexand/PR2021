package p8;


public class Runner {

    public void m() throws MyException {
        
        throw new MyException("m() caused an exception: my");
        
        }
     
    public static void main(String[] args) {

        try (Resource r = new Resource()) {
            r.open();
            new Runner().m();//выбрасыввется исключение
        } catch (MyException e) {
            System.out.println(e.whatHappenes());
        } finally {
            System.out.println("FINAL");
        }
    }
}
