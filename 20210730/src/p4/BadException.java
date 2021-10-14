package p4;


public class BadException extends Exception {
    
    private String descr;
    
    public BadException(String descr) {
        this.descr = descr;
    }
    
    public String whatHappenes() {
        return descr;
    }
    
}
