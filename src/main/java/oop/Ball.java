package oop;

public class Ball {
    public static Ball tryRun(boolean condition) {
        if (condition) {
            System.out.println("ball is done");
        } else {
            System.out.println("ball ran away");
        }
        return null;
    }
}
