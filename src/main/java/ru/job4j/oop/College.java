package ru.job4j.oop;

public class College {

    public static void main(String[] args) {

        Freshman freshman = new Freshman();
        Student student = freshman;
        Object object = freshman;
        Object objectFreshman = new Freshman();

        System.out.println(freshman);
        System.out.println(student);
        System.out.println(object);
        System.out.println(objectFreshman);
        System.out.println();

        System.out.println(new Freshman());
        System.out.println(new Student());
        System.out.println(new Object());
    }

}
