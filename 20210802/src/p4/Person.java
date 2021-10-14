package p4;

import java.time.LocalDate;


public class Person {   //������� �����
    
    private String firstName, surName, patronymic;

    public Person(String firstName, String patronymic, String surName) { 
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surName = surName;
    }
    
    public double getPension (Function f) {
        return f.getPension(this);// ��������� �������
    }


    public void setSurName(String surName) {
        this.surName = surName;
    }

    private Passport passport = new Passport();
    
    public Passport getPassport() {
        return this.passport;
    }
    
    private static int freePassportNumber = 1;

   
    public class Passport {    
        
        private String issuer;
        private LocalDate issueDate = LocalDate.now();
        private String passportNumber = new Integer(freePassportNumber++).toString();
        
        public void setFirstName(String string) {
            firstName = string;
        }
        
        public String getFirstName() {
            return firstName;
        }
        
        public void setSurName(String string) {
            surName = string;
        }
        
        public String getSurName() {
            return surName;
        }

        public void setPatronymic(String string) {
            patronymic = string;
        }
        
        public String getPatronymic() {
            return patronymic;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }
        
        public String getIssuer() {
            return issuer;
        }
        
        public String getInfo() {
            return "~~~~~~~~~~~~~~~~~~~" + "\n" +
                "| �������: " + this.passportNumber + "\n" +
                "| ���: " + this.getFirstName() + " " + this.getPatronymic() + " " + this.getSurName() + "\n" +
                "| �����: " + this.issueDate.toString() + "\n" +
                "|        " + this.getIssuer();
        }
       
    }    
    
    public static void main(String[] args) {
        Person p = new Person("���������", "���������", "������");
        Passport passport = p.getPassport();
        passport.setIssuer("���� �� �� �. �����-���������");
        passport = null; 

        System.out.println(p.getPassport().getInfo());
        System.out.println(p.getPension( new Function() { //��������� ������� ���������� ������
            public double getPension(Person p) {
                return 10000.0;
            }
        }));

        p.setSurName("���������");
        
        System.out.println(p.getPassport().getInfo());
        System.out.println(p.getPension( new Function() { //��������� ������� ���������� ������
            public double getPension(Person p) {
                return Math.random()*10000;
            }
        }));
        
        p.getPassport().setPatronymic("����������");
        
        System.out.println(p.getPassport().getInfo());
        System.out.println(p.getPension( new Function() { //��������� ������� ���������� ������
            public double getPension(Person p) {
                return Math.random()*100000;
            }
        }));
    }
    
}
