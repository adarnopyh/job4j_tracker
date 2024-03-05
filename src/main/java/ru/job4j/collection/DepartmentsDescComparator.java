package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split("/", 2);
        String[] rightSplit = right.split("/", 2);
        int result = rightSplit[0].compareTo(leftSplit[0]);
        return result == 0 ? left.compareTo(right) : result;
    }
}