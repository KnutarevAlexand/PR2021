package ru.ubrr.t1;


//�����
public enum Colors {
        YELLOW,
        RED,
        GREEN,
        BLUE,
        GRAY,
        CYAN,
        BLACK,
        MAGENTA;

    private static Colors[] list = Colors.values();

    public static Colors getColor() {
        int colorCode = Random.getRandom(0,7);//rnd(0,7);
        return list[colorCode];
    }
}