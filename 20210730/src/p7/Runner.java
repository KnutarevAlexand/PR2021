package p7;


public class Runner {


    public void m() throws MyException {
        
        throw new MyException("m() caused an exception: my");
        
        }
     
    public static void main(String[] args) {
        
        Resource r = new Resource();// �������� � ����� �������� ����� ���� ���������� � ����� ������, ����� ����� ��������� ���������� ����� �������� close
        r.open();// ��������������� �������� �������
        try {
            new Runner().m();
        } catch (MyException e) {
                
        } finally {
            r.close();// ��������������� �������� ������� (����� ���� ���������� � ����� ������, ����� ����� ��������� ���������� ����� �������� close)
        }
    }
}
