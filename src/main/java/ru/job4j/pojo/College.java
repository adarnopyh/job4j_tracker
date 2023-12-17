package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setFio("Иван Иванов Ивонович");
        student1.setGroup("A07");
        student1.setEntered(new Date());

        System.out.println(student1.getFio() + " entered in group: \"" + student1.getGroup() + "\" at " + student1.getEntered());
    }
}
