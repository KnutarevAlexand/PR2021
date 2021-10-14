package p4;


public class CloneObject implements Cloneable{
    
    @Override    
    public CloneObject clone() throws CloneNotSupportedException {
     return (CloneObject) super.clone();
    }
    
    public static void main(String[] args) throws CloneNotSupportedException {
        Object obj = new Object();
        Object obj2 = obj;//создание новой ссылки
        CloneObject obj3 = new CloneObject();
        CloneObject obj4 = obj3.clone();//копирование объекта
        System.out.println(obj.equals(obj2));
        System.out.println(obj.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.equals(obj4));
        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());
    }


}
