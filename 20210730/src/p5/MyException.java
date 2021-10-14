package p5;


public class MyException extends Exception {
    
    private String descr;
    
    public MyException(String descr) {
        super(descr);
        this.descr = descr;
    }
    
    public String whatHappenes() {
        return descr;
    }
    
}
