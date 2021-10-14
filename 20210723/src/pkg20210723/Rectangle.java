package pkg20210723;

public class Rectangle {
    private int a, b;
    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int mult(int x, int y) {
        return x*y;
    }
    public int getSquare() {
        return mult(a, b);
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 4);
        System.out.println(r.getSquare());
        
        Square s = new Square(3);
        System.out.println(s.getSquare());        
    }
}
