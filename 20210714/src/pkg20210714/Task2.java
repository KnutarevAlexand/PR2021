package pkg20210714;


public class Task2 {
    public static void main(String args[]) {
            //����:
            int beginDay = 9;
            int beginMonth = 8;
            int beginYear = 2021;
            int endDay = 21;
            int endMonth = 8;
            int endYear = 2021;

            int beginDay1 = 1;
            int beginMonth1 = 1;
            int beginYear1 = 1;
            int beginDay2 = beginDay1;
            int beginMonth2 = beginMonth1;
            int beginYear2 = beginYear1;
            int visYear;
            int maxDay = 0;
            int countDay = 0;
            int countDay2;
            int i = 0;
            int[] numDayWeek = new int[7];
            String[] dayWeek = new String[7];
            String daysWeek = "";
            int pathWeek = 0;
            int fullWeek = 0;
            int daysMonth = 0;
            int pathMonth = 0;
            int fullMonth = 0;
            dayWeek[0] = "�����������";
            dayWeek[1] = "�������";
            dayWeek[2] = "�����";
            dayWeek[3] = "�������";
            dayWeek[4] = "�������";
            dayWeek[5] = "�������";
            dayWeek[6] = "�����������";            
            
            
            
            for (countDay2 = 1; !(beginDay2 == endDay & beginMonth2 == endMonth & beginYear2 == endYear); countDay2++) {
                if(countDay > 0) countDay++;            
                if((beginDay2 == beginDay & beginMonth2 == beginMonth & beginYear2 == beginYear)) countDay++;
                 //�������� �� ������������
                if(beginYear2 == 400 | beginYear2%4 == 0) 
                    visYear = 1;
                else visYear = 0;
                //��������� ���� ���-�� ���� � ������
                switch(beginMonth2) {
                case 1:
                    maxDay = 31;
                    break;
                case 2: 
                    if(visYear == 0)
                        maxDay = 28;
                    else maxDay = 29;                
                    break;
                case 3: case 5: case 7:                   
                    maxDay = 31;
                    break;
                case 4:
                    maxDay = 30;                    
                    break;
                case 6:
                    maxDay = 30;
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
                
                if(beginDay2 + 1 <= maxDay) {
                    beginDay2++;
                }
                else {
                    beginDay2 = 1;
                    switch(beginMonth2) {
                    case 1:
                        beginMonth2 = 2;
                        break;
                    case 2:
                        beginMonth2 = 3;
                        break;
                    case 3:
                        beginMonth2 = 4;
                        break;
                    case 4:
                        beginMonth2 = 5;
                        break;
                    case 5:
                        beginMonth2 = 6;
                        break;
                    case 6:
                        beginMonth2 = 7;
                        break;
                    case 7:
                        beginMonth2 = 8;
                        break;
                    case 8:
                        beginMonth2 = 9;
                        break;
                    case 9:
                        beginMonth2 = 10;
                        break;
                    case 10:
                        beginMonth2 = 11;
                        break;
                    case 11:
                        beginMonth2 = 12;
                        break;
                    case 12:
                        beginMonth2 = 1;
                        beginYear2++;
                        break;
                    default:
                        beginMonth2 = 0;
                    }
                } 
            
                //������ ������
                if(countDay > 0) {
                    
                    i = countDay2%7;
                    switch(i) {
                    case 1:
                        i = 0;
                        break;
                    case 2:
                        i = 1;
                        break;
                    case 3:
                        i = 2;
                        break;
                    case 4:
                        i = 3;
                        break;
                    case 5:
                        i = 4;
                        break;
                    case 6:
                        i = 5;
                        break;
                    case 0:
                        i = 6;
                        break;
                     default:
                        i = 0;
                    }
                    numDayWeek[i]++;
                    daysWeek = daysWeek + i;
                        switch(daysWeek) {
                        case "0":
                            pathWeek++;
                            break;
                        case "1":
                            pathWeek++;
                            break;
                        case "2":
                            pathWeek++;
                            break;
                        case "3":
                            pathWeek++;
                            break;
                        case "4":
                            pathWeek++;
                            break;
                        case "5":
                            pathWeek++;
                            break;
                        case "6":
                            pathWeek++;
                            daysWeek = "";
                            break;
                        case "0123456":
                            pathWeek--;
                            fullWeek++;
                            daysWeek = "";
                            break;
                        default:
                        }
                }
                
                //������ �������
                if(countDay > 0) {
                  if(beginDay2 == 1) {
                      daysMonth = 1;
                      pathMonth++;
                  }
                
                      if(daysMonth == maxDay) {
                          fullMonth++;
                          pathMonth--;
                          daysMonth = 0;
                      }
                      else {
                          daysMonth++;
                          if(daysMonth == 1) pathMonth++;
                      }
                }
              }
            System.out.println("1) ���-�� ���� ����� "+beginYear+beginMonth+beginDay+" - "+endYear+endMonth+endDay+" : "+countDay+" ���");
            System.out.println("2) ������� ���� ������:");
            for(i = 0; i <= 6; ++i) {
                System.out.println(dayWeek[i]+" "+numDayWeek[i]);
            }
            System.out.println("3) �������� ������: "+pathWeek);
            System.out.println("4) ������ ������: "+fullWeek);
            System.out.println("5) �������� �������: "+pathMonth);
            System.out.println("6) ������ �������: "+fullMonth);
    }
    }
