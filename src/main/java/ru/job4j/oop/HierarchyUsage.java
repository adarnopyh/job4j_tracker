package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        /* создаем объекта класса Car. */
        Car car = new Car();
        /* делаем приведение к типу родителя Transport. */
        Transport transport = car;
        /* делаем приведение к типу родителя Object. */
        Object object = car;
        /* Приведение типа при создании объекта. */
        Object objectCar = new Car();
        /* Приведение типа за счет понижения по иерархии. */
        Car carFromObject = (Car) objectCar;

        System.out.println(car);
        System.out.println(transport);
        System.out.println(object);
        System.out.println(objectCar);
        System.out.println();

        System.out.println(new Car());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}