package oop;

public class Error {
    private boolean activate;

    private int status;

    private String message;

    public Error() {
    }

    public Error(boolean activate, int status, String message) {
        this.activate = activate;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(activate);
        System.out.println(status);
        System.out.println(message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error err1 = new Error();
        err1.printInfo();
        Error err2 = new Error(true, 2, "this is err2");
        err2.printInfo();
        Error err3 = new Error(true, 3, "this is err3");
        err3.printInfo();
    }

}
