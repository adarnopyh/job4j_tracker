package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select menu item: ");
            if (select == 0) {
                System.out.println("=== Create new request ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Added request: " + item);
            } else if (select == 1) {
                System.out.println("=== List all requests ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("The database is empty");
                }
            } else if (select == 2) {
                System.out.println("=== Replace request ===");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter id: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Request replaced successfully.");
                } else {
                    System.out.println("Error. Request is not replaced");
                }
            } else if (select == 3) {
                System.out.println("=== Delete request ===");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                tracker.delete(id);
                System.out.println(item != null ? "Request deleted successfully." : "Error. Item is not deleted");
            } else if (select == 4) {
                System.out.println("=== Search request by ID ===");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Requesrt with ID: " + id + " is not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Search requests by name ===");
                String name = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Requests with name: \"" + name + "\" are not found.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Create new request", "List all requests", "Replace request",
                "Delete request", "Search request by ID", "Search requests by name",
                "Exit"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
