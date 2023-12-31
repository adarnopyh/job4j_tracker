package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class FindByID implements UserAction {
    private final Output output;

    public FindByID(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "search item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Search items by ID ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("Item with ID: " + id + " is not found.");
        }
        return true;
    }
}
