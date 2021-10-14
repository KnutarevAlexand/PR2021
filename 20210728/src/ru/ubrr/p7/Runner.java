package ru.ubrr.p7;


public class Runner {
    
    public Result f() {
        return Result.FAILURE;
    }
    
    public static void main(String[] args) {    // пример использования перечисления при аналлизе результата
        Result r = new Runner().f();
        if (r == Result.OK) {
            System.out.println("Run was OK");
        } else {
            System.out.println("Something went wrong");
        }
    }
}
