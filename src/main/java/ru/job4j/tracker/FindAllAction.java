package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "list all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== List all items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("The database is empty");
        }
        return true;
    }
}
