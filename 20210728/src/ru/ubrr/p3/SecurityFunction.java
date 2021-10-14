package ru.ubrr.p3;


public interface SecurityFunction {
    
    public static void display() {
        System.out.println("CALL");
    }
    public String encrypt(String decryptedData);
    public String decrypt(String encryptedData);
    public void info();
    
    public default void trace(String s) { // ��������� ������ � ���������� �� ���������
        System.out.println("TRACE: ");
    }
    
}
