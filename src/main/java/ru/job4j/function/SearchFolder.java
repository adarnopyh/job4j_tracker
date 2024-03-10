package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> predicate) {
        List<Folder> result = new ArrayList<>(list);
        for (Folder item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}