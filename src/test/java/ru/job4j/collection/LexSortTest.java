package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "133. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] output = {
                "1. Task.",
                "2. Task.",
                "10. Task.",
                "133. Task."
        };
        for (String inputString : input ) {
            System.out.println(inputString);
        }
        System.out.println();
        for (String outputString : output ) {
            System.out.println(outputString);
        }
        System.out.println();
        Arrays.sort(input, new LexSort());
        for (String inputString : input ) {
            System.out.println(inputString);
        }
        assertThat(input).containsExactly(output);
    }
}