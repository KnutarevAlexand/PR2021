package p4;

import java.time.LocalDate;


public class Person {   //внешний класс
    
    private String firstName, surName, patronymic;

    public Person(String firstName, String patronymic, String surName) { 
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surName = surName;
    }
    
    public double getPension (Function f) {
        return f.getPension(this);// анонимная функция
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
                "| Паспорт: " + this.passportNumber + "\n" +
                "| ФИО: " + this.getFirstName() + " " + this.getPatronymic() + " " + this.getSurName() + "\n" +
                "| Выдан: " + this.issueDate.toString() + "\n" +
                "|        " + this.getIssuer();
        }
       
    }    
    
    public static void main(String[] args) {
        Person p = new Person("Александр", "Сергеевич", "Пушкин");
        Passport passport = p.getPassport();
        passport.setIssuer("ОФМС РФ по г. Санкт-Петербург");
        passport = null; 

        System.out.println(p.getPassport().getInfo());
        System.out.println(p.getPension( new Function() { //анонимная функция анонимного класса
            public double getPension(Person p) {
                return 10000.0;
            }
        }));

        p.setSurName("Вяземский");
        
        System.out.println(p.getPassport().getInfo());
        System.out.println(p.getPension( new Function() { //анонимная функция анонимного класса
            public double getPension(Person p) {
                return Math.random()*10000;
            }
        }));
        
        p.getPassport().setPatronymic("Михайлович");
        
        System.out.println(p.getPassport().getInfo());
        System.out.println(p.getPension( new Function() { //анонимная функция анонимного класса
            public double getPension(Person p) {
                return Math.random()*100000;
            }
        }));
    }
    
}
