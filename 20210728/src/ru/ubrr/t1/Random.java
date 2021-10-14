package ru.ubrr.t1;


//√енератор случайного числа в заданном диапазоне
public class Random {

    public static int getRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
