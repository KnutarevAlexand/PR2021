package t2;


public class ComplexOpException  extends Exception {

    private String descr;
    
    public ComplexOpException(String descr) {
        super(descr);
        this.descr = descr;
    }
    
    public String whatHappenes() {
        return descr;
    }
    
}
