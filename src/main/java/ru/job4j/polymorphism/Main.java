package ru.job4j.polymorphism;

public class Main {
    public static void main(String[] args) {
        Vehicle townCar = new TownCar();
        townCar.changeGear();
        townCar.accelerate();
        townCar.steer();
        townCar.brake();
        System.out.println();

        Vehicle sportCar = new SportCar();
        sportCar.changeGear();
        sportCar.accelerate();
        sportCar.steer();
        sportCar.brake();
        System.out.println();

        SportCar sportCarFuel = new SportCar();
        Vehicle vehicle = sportCarFuel;
        Fuel fuel = sportCarFuel;
        vehicle.changeGear();
        vehicle.accelerate();
        vehicle.steer();
        vehicle.brake();
        fuel.refill();
        System.out.println();

        Vehicle sportCar3 = new SportCar();
        sportCar3.changeGear();
        sportCar3.accelerate();
        sportCar3.steer();
        sportCar3.brake();
        sportCar3.refill();
        Vehicle.getDragCoefficient();
    }
}
