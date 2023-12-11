package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperation(int c) {
        return sum(c) + multiply(c) + minus(c) + divide(c);
    }

    public static void main(String[] args) {
        int resultSum = sum(5);
        System.out.println(resultSum);

        int resultMinus = minus(5);
        System.out.println(resultMinus);

        Calculator calculator = new Calculator();

        int resultMultiply = calculator.multiply(5);
        System.out.println(resultMultiply);

        int resultDivide = calculator.divide(5);
        System.out.println(resultDivide);

        int resultAll = calculator.sumAllOperation(5);
        System.out.println(resultAll);
    }
}
