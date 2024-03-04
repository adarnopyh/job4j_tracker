package ru.job4j.collection;

import java.util.*;

public class Departments implements Comparator<String> {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        for (String value : departments) {
            String start = "";
            for (String element : value.split("/")) {
                temp.add(start == "" ? element : start + element);
                start += element + "/";
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        Collections.sort(departments, new DepartmentsDescComparator());
    }

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}