package p4;


public class MyException extends Exception {
    
    private String descr;
    
    public MyException(String descr) {
        this.descr = descr;
    }
    
    public String whatHappenes() {
        return descr;
    }
    
}
