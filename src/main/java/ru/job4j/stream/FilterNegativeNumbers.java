package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 3, -8, 5, -6, 77, 21, -3, 0, 2, 3);
        List<Integer> positive = numbers.stream().filter(number -> number > 0).toList();
        positive.forEach(System.out::println);
    }
}