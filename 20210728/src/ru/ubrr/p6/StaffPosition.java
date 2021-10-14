package ru.ubrr.p6;


public enum StaffPosition {     // ������������ � �����������, ������������ ��� �������� ���������� ������
    DIRECTOR("�����������", 200000),
    JANITOR("��������", 25000, DIRECTOR),
    PROJECTMANAGER("�������� �������", 60000, DIRECTOR),
    DEVELOPER("�����������", 50000, PROJECTMANAGER),
    SELLER("��������", 90000, DIRECTOR);
    
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
        return "��������� �" + this.ordinal() + " " + this.name() + ": " + this.getDescr() + " " + ", �������� " + this.getSalary() + ", ����������� " + this.getManager().name();
    }
}
