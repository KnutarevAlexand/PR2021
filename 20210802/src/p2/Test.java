package p2;

import p1.Acc;

public class Test extends Acc{
    int d;

    public static void main(String[] args) {
        Acc obj = new Test();
        System.out.println(obj.s);//����������� ������� ��������� ������ ������ � �������� s � ������ ������� Acc
    }
}
