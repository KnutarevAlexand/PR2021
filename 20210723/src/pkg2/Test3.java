package pkg2;

public class Test3 {
    private String name;
    private String address;

    public void setName(String name) {
        if ((name == null) || (name.equals(""))) {
  
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name.toLowerCase();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
