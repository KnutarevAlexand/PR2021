package pkg20210723;

public class Customer extends Object {
    public String name = "Skott Tiger";
    public String address;
    public int age;
    public void display() {
        System.out.println("Customer" + name + " from " + address);
    }
    public static void main(String[] args) {
        Customer c = new Customer();
        c.address = "Moscow";
        c.display();
        System.out.println(new Customer().toString());
        
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

    }

}
