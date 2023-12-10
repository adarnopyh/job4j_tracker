package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String defaultString = "Неизвестное слово. ";
        return defaultString + eng;
    }

    public static void main(String[] args) {
        DummyDic funDic = new DummyDic();
        String say = funDic.engToRus("funny Dic");
        System.out.println(say);
    }
}
