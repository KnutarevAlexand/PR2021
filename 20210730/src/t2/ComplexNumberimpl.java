package t2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ComplexNumberimpl implements ComplexNumber<ComplexNumber> {

    double real,img;
         
    ComplexNumberimpl(double r, double i){
         this.real = r;
         this.img = i;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComplexNumberimpl) {
            ComplexNumberimpl other = (ComplexNumberimpl)obj;
            return (
                this.real == other.real &&
                this.img == other.img
            );
        }
        return false;
    }    
    
    public ComplexNumber add(ComplexNumber c) {
        ComplexNumberimpl cc = (ComplexNumberimpl) c;
        this.real += cc.real;
        this.img += cc.img;
        return this;
    }
    
    public ComplexNumber divide(ComplexNumber c) throws ComplexOpException {
        
        ComplexNumberimpl cc = (ComplexNumberimpl) c;
        if(cc.real == 0 | cc.img == 0) throw new ComplexOpException("Ќа ноль делить нельз€!");
        this.real /= cc.real;
        this.img /= cc.img;
        return this;
    }
    
    static String readFirstLineFromFileWithFinallyBlock(String path)
                                                         throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }
    
    public static void main(String[] args) {
    
    ComplexNumberimpl comp1 = new ComplexNumberimpl(0.12, 0.6);
    ComplexNumberimpl comp2 = new ComplexNumberimpl(0.12, 0.6);
    System.out.println("comp1: " + comp1.real + " " + comp1.img);
    System.out.println("comp2: " + comp2.real + " " + comp2.img);
    System.out.println(comp1.equals(comp2));
//сложение
    comp1.add(comp2);
    System.out.println("comp1: " + comp1.real + " " + comp1.img);
    System.out.println("comp2: " + comp2.real + " " + comp2.img);
    System.out.println(comp1.equals(comp2));
//деление        
    try (MyResource r = new MyResourceImpl()) {
        r.open();
        comp1.divide(comp2);
    } catch (ComplexOpException my) {
        System.out.println(my.whatHappenes());
    } finally {
        System.out.println("FINAL");
        }

    System.out.println("comp1: " + comp1.real + " " + comp1.img);
    System.out.println("comp2: " + comp2.real + " " + comp2.img);
    System.out.println(comp1.equals(comp2));
   
    }
}
