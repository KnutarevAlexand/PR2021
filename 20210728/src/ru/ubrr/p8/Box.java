package ru.ubrr.p8;


public class Box {
    private Object thing;
    public Box(Object t) {
        this.thing = t;
    }

    public void setThing(Object thing) {
        this.thing = thing;
    }

    public Object getThing() {
        return thing;
    }


}
