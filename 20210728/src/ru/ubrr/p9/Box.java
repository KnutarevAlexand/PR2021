package ru.ubrr.p9;

public class Box<T> { //������ ��������� (generic), ���������
    private T thing;
    public Box(T t) {
        this.thing = t;
    }

    public void setThing(T thing) {
        this.thing = thing;
    }

    public T getThing() {
        return thing;
    }


}
