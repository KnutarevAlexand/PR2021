package pkg20210714;


public class Task1 {
    public static void main(String args[]) {
        int a = 2;
        int b = 4;//4
        int c = 2;
        int d = (int)(b*b-4*a*c);
        int ans = -1;
        double x1 = 0;
        double x2 = 0;
        if(d > 0) {
            x1 = (0-b+Math.sqrt(d))/(2*a);
            x2 = (0-b-Math.sqrt(d))/(2*a);
            ans = 0;
        }
        if(d == 0) {
            x1 = x2 = 0 - b/(2*a);
            ans = 1;
        }
        if(d < 0) {
            x1 = x2 = 0;
            ans = 2;
        }
        double x1_ = (a * x1 * x1 + b * x1 + c);
        double x2_ = (a * x2 * x2 + b * x2 + c);
        System.out.println("����: �������� 3 ������������ a = "+a+", b = "+b+", c = "+c+" ������������ ��������� ������ ����");
        System.out.println("�������: �������� ����� ������� ��� ���������� ������ � ��������� ������������� D");
        switch(ans) {
        case 0:
            System.out.println("�����: �������� 2 ��������� �����: x1 = "+x1+", x2 = "+x2);
            System.out.println("�������� �������:");
            System.out.println("1) ��������� x1: a*x1*x1+b*x1+c = "+x1_);
            System.out.println("2) ��������� x2: a*x2*x2+b*x2+c = "+x2_);
            break;
        case 1:
            System.out.println("�����: ������� 1 ������: x1 = x2 "+x1);
            System.out.println("�������� �������: a*x1*x1+b*x1+c = a*x2*x2+b*x2+c = "+x1_);
            break; 
        case 2:
            System.out.println("�����: ������ �� ��������� ������������� ����� ���");
            System.out.println("�������� �������: �� ��������");
            break; 
        default:
            System.out.println("�����: ���� � �����������"); 
        }
    }
}
