package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = Math.min(left.length(), right.length());
        if (left.length() == right.length()) {
            for (int i = 0; i < length; i++) {
                if (left.charAt(i) > right.charAt(i)) {
                    return 1;
                }
                if (left.charAt(i) < right.charAt(i)) {
                    return -1;
                }
            }
        } else if (left.length() > right.length()) {
            for (int i = 0; i < length; i++) {
                if (left.charAt(i) > right.charAt(i)) {
                    return 1;
                }
                if (left.charAt(i) < right.charAt(i)) {
                    return -1;
                }
            }
            result = 1;
        } else {
            for (int i = 0; i < length; i++) {
                if (left.charAt(i) > right.charAt(i)) {
                    return 1;
                } else if (left.charAt(i) < right.charAt(i)) {
                    return -1;
                }
            }
            result = -1;
        }
        return result;
    }
}