package test07.lab.frontend;

import test07.lab.A;
import test07.lab.backend.B;
import test07.lab.backend.C;

public class D {

     A a = new A();
     test07.lab.frontend.A a1 = new  test07.lab.frontend.A();
     B b = new B();
     C c = new C();
     D d = new D();
     //дубликаты *_d
     A a_d = a;
     test07.lab.frontend.A a1_d = a1;
     B b_d = b;
     C c_d = c;
     D d_d = d; 

    public static int D (int n1, int n2) {
        int min;
        if (n1 > n2) min = n2;
        else min = n1;
        System.out.println("I'm here");
        return min;       
    }

    public static void main(String[] args) {
        Object w = D(1,2);
        System.out.println(w.toString());

    }
}
