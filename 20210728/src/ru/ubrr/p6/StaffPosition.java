package ru.ubrr.p6;


public enum StaffPosition {     // перечисления с параметрами, используется для возврата результата работы
    DIRECTOR("Гендиректор", 200000),
    JANITOR("Уборщица", 25000, DIRECTOR),
    PROJECTMANAGER("Менеджер проекта", 60000, DIRECTOR),
    DEVELOPER("Разработчик", 50000, PROJECTMANAGER),
    SELLER("Продавец", 90000, DIRECTOR);
    
    private int salary;
    private String descr;
    private StaffPosition manager;
    
    private StaffPosition(String descr, int salary, StaffPosition manager) {
        this.salary = salary;
        this.descr = descr;
        this.manager = manager;
    }
    private StaffPosition(String descr, int salary) {
        this(descr, salary, null);
    }


    public int getSalary() {
        return salary;
    }

    public String getDescr() {
        return descr;
    }

    public StaffPosition getManager() {
        return manager;
    }
    
    public String toString() {
        return "Должность №" + this.ordinal() + " " + this.name() + ": " + this.getDescr() + " " + ", зарплата " + this.getSalary() + ", подчиняется " + this.getManager().name();
    }
}
