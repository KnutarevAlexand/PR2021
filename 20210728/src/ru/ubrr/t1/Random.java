package ru.ubrr.t1;


//��������� ���������� ����� � �������� ���������
public class Random {

    public static int getRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
