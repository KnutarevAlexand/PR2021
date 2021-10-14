package p3;

import java.time.LocalDate;


public class Person {   //внешний класс
    
    private String firstName, surName, patronymic;

    public Person(String firstName, String patronymic, String surName) { //ФИО хранится на уровне персоны
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.surName = surName;
    }


    public void setSurName(String surName) {
        this.surName = surName;
    }

    private Passport passport = new Passport();// автоматичская инициализация нового объекта типа Паспорт при инициализации новой персоны
    
    public Passport getPassport() {
        return this.passport;
    }
    
    private static int freePassportNumber = 1;

   
    public class Passport {     //внутренний класс
        
        //private static int t = 0; статическая декларация во вн. классе не допустима
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
        Person p = new Person("Александр", "Сергеевич", "Пушкин");// Вложенный класс позволяет посмотреть на одни и те-же данные как свойства объекта Персона, так и свойства Паспорт (см. ниже)
        Passport passport = p.getPassport();
        passport.setIssuer("ОФМС РФ по г. Санкт-Петербург");
        passport = null; //Обнуляем ссылку на паспорт для демонстрации

        System.out.println(p.getPassport().getInfo());//показ через призму паспорт

        p.setSurName("Вяземский");
        
        System.out.println(p.getPassport().getInfo());
        
        p.getPassport().setPatronymic("Михайлович");
        
        System.out.println(p.getPassport().getInfo());
    }
    
}
