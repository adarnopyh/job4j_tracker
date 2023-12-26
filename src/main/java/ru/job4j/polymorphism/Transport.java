package ru.job4j.polymorphism;

public interface Transport {
    void drive();

    void passengers(int passengersCount);

    double refuel(int fuel);
}
