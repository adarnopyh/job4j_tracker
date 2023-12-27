package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("drvie");
    }

    @Override
    public void passengers(int passengersCount) {
        System.out.println(passengersCount);
    }

    @Override
    public double refuel(int fuel) {
        return fuel;
    }
}
