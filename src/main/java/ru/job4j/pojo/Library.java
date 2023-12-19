package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Buk Van", 152);
        Book book2 = new Book("Clean Cot", 158);
        Book book3 = new Book("Buk M3", 12);
        Book book4 = new Book("Buk M1", 3151);
        Book[] buks = new Book[4];
        buks[0] = book1;
        buks[1] = book2;
        buks[2] = book3;
        buks[3] = book4;
        for (int i = 0; i < buks.length; i++) {
            Book bubu = buks[i];
            System.out.println("This book name is \"" + bubu.getName() + "\" and it's total page quantity is " + bubu.getPagesQty() + " pages");
        }
        Book tempCell = buks[0];
        buks[0] = buks[3];
        buks[3] = tempCell;
        for (int i = 0; i < buks.length; i++) {
            Book bubu = buks[i];
            System.out.println("Now this book name is \"" + bubu.getName() + "\" and it's total page quantity is " + bubu.getPagesQty() + " pages");
        }
        for (int i = 0; i < buks.length; i++) {
            Book bubu = buks[i];
            if (bubu.getName().equals("Clean Cot")) {
                System.out.println("The reason why this book is printed out is that it's name is equal to \"" + bubu.getName() + "\" but it's total page quantity is " + bubu.getPagesQty() + " pages");
            }
        }
    }
}
