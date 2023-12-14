package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {
    @Test
    public void when000and527Then8() {
        int x1 = 0;
        int y1 = 0;
        int z1 = 0;
        int x2 = 5;
        int y2 = 2;
        int z2 = 7;
        Point pointDistance = new Point(x1, y1, z1);
        Point that = new Point(x2, y2, z2);
        double result = pointDistance.distance3d(that);
        double expected = 8.831;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when111and444Then5() {
        int x1 = 1;
        int y1 = 1;
        int z1 = 1;
        int x2 = 4;
        int y2 = 4;
        int z2 = 4;
        Point pointDistance = new Point(x1, y1, z1);
        Point that = new Point(x2, y2, z2);
        double result = pointDistance.distance3d(that);
        double expected = 5.196;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }
}