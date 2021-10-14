package p5;


public class BadException extends Exception {
    
    private String descr;
    
    public BadException(String descr) {
        super(descr);
        this.descr = descr;
    }
    
    public String whatHappenes() {
        return descr;
    }
    
}
