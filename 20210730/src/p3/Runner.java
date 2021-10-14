package p3;

import p2.MyException;

public class Runner {


    public void m() throws MyException {//��������� ��� �� ����� ������ ����� ��������� ������ ����������
        
        if(Math.random() >0.5) {
            System.out.println("Success");
        } else {
            throw new MyException("m() caused an exception");//����������� ����������
        }
        
    }
    
    public static void main(String[] args) throws Exception {//���� ������������ ����������
        
        try { // ����� ������� ���������� ���������� try catch
            new Runner().m();
            System.out.println("FINISH");
        } catch (MyException e) {
            System.out.println("The random number was bad");
            System.out.println( e.whatHappenes() );//����������� ����������
            throw e; 
        } finally { // ���� filally ��������� ����� �� ����� ��������� ��� ����������� ����������
            System.out.println("FINISH");
        }

        
        

    }
}
