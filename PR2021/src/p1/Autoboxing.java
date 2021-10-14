package p1;


public class Autoboxing {
    public Autoboxing() {
        super();
    }

    public static void main(String[] args) {
        Integer iOb1 = 100;
        Integer iOb2 = 100;
        System.out.println(iOb1 == iOb2);

        Integer iOb5 = 200;
        Integer iOb6 = 200;
        System.out.println(iOb5 == iOb6);// выход за кешевый размер ссылки на объект Integer -127 128
        System.out.println(iOb5 >= iOb6);
        System.out.println(Integer.valueOf(iOb5) >= Integer.valueOf(iOb6));
    }

}
