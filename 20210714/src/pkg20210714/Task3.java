package pkg20210714;


public class Task3 {
    public static void main(String args[]) {
            //Дано:
            int month = 7;
            int year = 2021;

            int beginDay = 1;
            int beginMonth = 1;
            int beginYear = 1;
            int visYear;
            int maxDay = 0;
            int countDay = 0;
            int lastDayWeek = 0;
            
            String[] dayWeek = new String[7];
            dayWeek[0] = "пн";
            dayWeek[1] = "вт";
            dayWeek[2] = "ср";
            dayWeek[3] = "чт";
            dayWeek[4] = "пт";
            dayWeek[5] = "сб";
            dayWeek[6] = "вс"; 

            String[] cal = new String [7];
            cal[0] = "";
            cal[1] = "";
            cal[2] = "";
            cal[3] = "";
            cal[4] = "";
            cal[5] = "";
            cal[6] = "";
            int valPos = 0;
            String elemCal = "";

            String nameMonth;
            switch(month) {
            case 1:
                nameMonth = "Январь";
                break;
            case 2:
                nameMonth = "Февраль";
                break;
            case 3:
                nameMonth = "Март";
                break;
            case 4:
                nameMonth = "Апрель";
                break;
            case 5:
                nameMonth = "Май";
                break;
            case 6:
                nameMonth = "Июнь";
                break;
            case 7:
                nameMonth = "Июль";
                break;
            case 8:
                nameMonth = "Август";
                break;
            case 9:
                nameMonth = "Сентябрь";
                break;
            case 10:
                nameMonth = "Октябрь";
                break;
            case 11:
                nameMonth = "Ноябрь";
                break;
            case 12:
                nameMonth = "Декабрь";
                beginYear++;
                break;
            default:
                nameMonth = "Январь";
            }

            
            //Вычисляем день недели 1 числа          
            for (countDay = 1; !(beginDay == 2 & beginMonth == month & beginYear == year); countDay++) {
                  //проверка на високосность
                if(beginYear == 400 | beginYear%4 == 0) 
                    visYear = 1;
                else visYear = 0;
                //установка макс кол-во дней в месяце
                switch(beginMonth) {
                case 1:
                    maxDay = 31;
                    break;
                case 2: 
                    if(visYear == 0)
                        maxDay = 28;
                    else maxDay = 29;                
                    break;
                case 3:
                    maxDay = 31;
                    break;
                case 4:
                    maxDay = 30;                    
                    break;
                case 5:
                    maxDay = 31;
                    break;
                case 6:
                    maxDay = 30;
                    break;
                case 7:
                    maxDay = 31;
                    break;
                case 8:
                    maxDay = 31;
                    break;
                case 9:
                    maxDay = 30;
                    break;
                case 10:
                    maxDay = 31;                    
                    break;
                case 11:
                    maxDay = 30;
                    break;
                case 12:
                    maxDay = 31;
                    break;
                default:
                    maxDay = 0;
                }
                
                if(beginDay + 1 <= maxDay) beginDay++;
                else {
                    beginDay = 1;
                    switch(beginMonth) {
                    case 1:
                        beginMonth = 2;
                        break;
                    case 2:
                        beginMonth = 3;
                        break;
                    case 3:
                        beginMonth = 4;
                        break;
                    case 4:
                        beginMonth = 5;
                        break;
                    case 5:
                        beginMonth = 6;
                        break;
                    case 6:
                        beginMonth = 7;
                        break;
                    case 7:
                        beginMonth = 8;
                        break;
                    case 8:
                        beginMonth = 9;
                        break;
                    case 9:
                        beginMonth = 10;
                        break;
                    case 10:
                        beginMonth = 11;
                        break;
                    case 11:
                        beginMonth = 12;
                        break;
                    case 12:
                        beginMonth = 1;
                        beginYear++;
                        break;
                    default:
                        beginMonth = 0;
                    }
                }
                lastDayWeek = (countDay+maxDay-2)%7;
                switch(lastDayWeek) {
                case 1:
                    lastDayWeek = 0;
                    break;
                case 2:
                    lastDayWeek = 1;
                    break;
                case 3:
                    lastDayWeek = 2;
                    break;
                case 4:
                    lastDayWeek = 3;
                    break;
                case 5:
                    lastDayWeek = 4;
                    break;
                case 6:
                    lastDayWeek = 5;
                    break;
                case 0:
                    lastDayWeek = 6;
                    break;
                 default:
                    lastDayWeek = 0;
                }
            }
            //System.out.println("1) Последний день недели месяца: "+lastDayWeek);
            //System.out.println("2) Кол-во дней в месяце: "+maxDay);
            
            //Собираем вторую строку календаря
            for(int i = 0; i <= 6; i++) {
                cal[0] = cal[0]+'\t'+ dayWeek[i];
               
            }
            cal[0] = cal[0].trim();

            //Собираем числа месяца
            for(int i = 6; i >= 1; i--) {
                for(int b = 6; b >= 0; b--) {
                    if(i == 6 & b == lastDayWeek) valPos = maxDay;
                    else if(valPos >= 1) --valPos;
                    
                    if(valPos == 0) elemCal = "";
                    else elemCal = String.valueOf(valPos);
                                         
                    if(b == 6) cal[i] = elemCal;
                    else cal[i] = elemCal +'\t'+cal[i];      
                }
            }
              //Выводим календарь
            System.out.println("   "+nameMonth+" "+year);
            for(String v: cal) {
                if( v.matches(".+\\d.*") | v.matches(".*\\d.+")) System.out.println(v);
            }
            
    }
    }