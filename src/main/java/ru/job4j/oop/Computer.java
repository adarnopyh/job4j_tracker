package ru.job4j.oop;

public class Computer {

    private boolean multiMonitor;
    private int ssd;
    private String cpu;

    public Computer() {
    }

    public Computer(boolean multiMonitor, int ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = ssd;
        this.cpu = cpu;
    }

    public Computer(int ssd, String cpu) {
        this.ssd = ssd;
        this.cpu = cpu;
    }

    public Computer(boolean multiMonitor, double ssd, String cpu) {
        this.multiMonitor = multiMonitor;
        this.ssd = (int) ssd;
        this.cpu = cpu;
    }

    public void printInfo() {
        System.out.println("Много мониторов: " + multiMonitor);
        System.out.println("SSD: " + ssd + " GB");
        System.out.println("Модель CPU: " + cpu);
        System.out.println();
    }

    public static void main(String[] args) {
        Computer computer = new Computer(true, 500, "Intel Core I7-10700K");
        Computer comp = new Computer(true, 256, "AMD Ryzen 5 3600");
        computer.printInfo();
        comp.printInfo();

        Computer defaultConstructor = new Computer();
        defaultConstructor.printInfo();

        Computer third = new Computer(256, "AMD Ryzen 5 3600");
        third.printInfo();

        Computer forth = new Computer(true, 512.0, "AMD Ryzen 7 3700X");
        forth.printInfo();
    }
}