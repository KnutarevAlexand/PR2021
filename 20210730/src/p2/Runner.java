package p2;


public class Runner {


    public void m() throws MyException {//��������� ��� �� ����� ������ ����� ��������� ������ ����������
        
        if(Math.random() >0.5) {
            System.out.println("Success");
        } else {
            throw new MyException("m() caused an exception");//����������� ����������
        }
        
    }
    
    public static void main(String[] args) throws Exception{//������������ ���������� ����
 /*       
        int a = 10;
        int b = 1;
        
        System.out.println(a/(b-1));// �������� ������� �� ���� �� 10 ������
        
        int[] arr = new int[3];
        arr[4] =1;// ������ ������ �� ������� �������
*/        
        new Runner().m();
        

    }
}
