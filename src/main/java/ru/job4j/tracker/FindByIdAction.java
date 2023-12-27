package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "search item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Search items by ID ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item with ID: " + id + " is not found.");
        }
        return true;
    }
}
