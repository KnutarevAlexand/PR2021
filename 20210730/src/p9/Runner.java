package p9;


public class Runner {

    public void m() throws MyException {
        
        throw new MyException("m() caused an exception: my");
        
        }
     
    public static void main(String[] args) {

        try (Resource r = new Resource(); Resource r2 = new Resource()) {
            r.open();
            r2.open();
            new Runner().m();//выбрасыввется исключение
        } catch (MyException e) {
            System.out.println(e.whatHappenes());
        } finally {
            System.out.println("FINAL");
        }
    }
}
