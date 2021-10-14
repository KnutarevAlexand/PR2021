package ru.ubrr.p2;


public class Passport { //пример функциональности через статические функции - фабрика генерирующая экземпляры
    
    private static int currentNumber = (int)Math.sqrt(9);//пример инициализации статической переменной
    
    static { //пример инициализации статической переменной используя статический блок
        int temp = (int)Math.sqrt(20);
        int temp2 = temp * 4;
        currentNumber = temp2;
    }
    
    private String id;
    private String firstName = "Иван";
    private String lastName = "Иванов";

    private String fullName;
    
    public static void getCurrentNumber() {
        System.out.println("The current number is: " + currentNumber); 
    }
    public static Passport getNewPassport(String firstName, String lastName) {//используем статический метод для инициализации объекта, , позволяет верифицировать значения перед созданием объекта
        
        // !!!! Сюда вставляем логику перед создание объекта. Например прямое обращение к констукторам не допустима, принятая политика приложения
        
        return new Passport(firstName, lastName);
    }
     private Passport(String firstName, String lastName) {
        this.id = Integer.toString(Passport.currentNumber++);
        this.firstName = firstName;
        this.lastName = lastName;
        fullName = firstName + ' ' + lastName;
    }
    public Passport getCopy() {
        Passport p = new Passport(this.firstName+" 2", this.lastName+" 2");
        return p;
    }
    
    public Passport() {
       this("Иван","Иванов");
    }
    
    
    public static void doSomething(int i) {
        System.out.println(" -> " + i);
        i++;
        System.out.println(" -> " + i);
    }
    public static void display(int i) {
        System.out.println("Integer " + i);
    }
    public static void display(double i) {
        System.out.println("Double " + i);
    }
    public static void display(Object i) {
        System.out.println("Object " + i);
    }
    
    public static void avg(int a, int b) {
        System.out.println((a+b)/2.0);
    }
    public static void avg(int a, int b, int c) {
        System.out.println((a+b+c)/3.0);
    }
    public static void avg(String s, int... a) {// переменно кол-во переменных , заменяет два метода выше, a - это массив
        double sum = 0;
        for(int num: a) {
            sum += num;
        }
        System.out.println(s + sum/a.length);
    }
    
    public static void main(String[] args) {
        Passport.getCurrentNumber();

        Passport p = Passport.getNewPassport("Алексей","Золотарев");
        Passport p2 = Passport.getNewPassport("Леонид","Андреев");
        Passport p3 = new Passport();
        System.out.println(p.getId() + ": " + p.getFullName());
        System.out.println(p2.getId() + ": " + p2.getFullName());
        p = p2;
        System.out.println(p.getId() + ": " + p.getFullName());
        System.out.println(p2.getId() + ": " + p2.getFullName());     
        System.out.println(p3.getId() + ": " + p3.getFullName());   
 
        getCurrentNumber();
        
        int i1 = 100;
        System.out.println(i1);
        doSomething(i1);
        System.out.println(i1);
        
        String s = "qwerty"; // создан объект, как аналог String s = new String("34");
        System.out.println(s.length());
        
        Integer i2 = 200;
        int i3 = i2;  // создание примитика из объекта, как аналог int i3 = i2.intValue()
        System.out.println(i3);
        
        display(1);
        display(2.0);
        display("2L");
        
        avg(2,3);
        avg(2,3,3);
        avg("Среднее значение: ",3,4,4,4);
        
        final int f = 10; // пример инициализации переменной без возможности дальнейшего изменения, например ++f
        System.out.println(f);
        final Passport p4 = Passport.getNewPassport("Леонид","Андреев");// пример инициализированного объекта без возможности дальнейшего изменения, аналогично можно final для класса и метода, что не позволит наследовать класс и переопределять методы родителя @Overrade (защита от модификации)
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }
}