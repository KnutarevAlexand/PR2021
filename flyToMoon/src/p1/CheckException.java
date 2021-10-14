package p1;


public class CheckException  extends Exception {

    private String descr;

    
    public CheckException(String descr) {
        super(descr);
        this.descr = descr;
    }
    
    public String whatHappenes() {
        return descr;

    }
    
    }