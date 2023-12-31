package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key == value[i]) {
                result = i;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            String[] yo = {"i", "This is iThis isThis is i t", "f", "r"};
            indexOf(yo, "k");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}