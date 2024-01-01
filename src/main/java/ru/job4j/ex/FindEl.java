package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(key, value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return result;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        boolean result = true;
        for (int i = 0; i < abuses.length; i++) {
            if (Objects.equals(value, abuses[i])) {
                result = false;
                break;
            }
        }
        if (!result) {
            throw new ElementAbuseException("No permission");
        }
        /* if contains throw ElementAbuseException */
        return true;
    }

    public static void main(String[] args) {
        String[] values = {"i", "This is iThis isThis is i t", "f", "r"};
        String key = "i";
        String[] abuses = {"k","l","m", "i"};
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
                if (sent(key, abuses)) {
                    System.out.println("message has been sent");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        try {
//            String[] yo = {"i", "This is iThis isThis is i t", "f", "r"};
//            indexOf(yo, "k");
//        } catch (ElementNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}