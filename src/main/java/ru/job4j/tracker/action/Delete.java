package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

public class Delete implements UserAction {
    private final Output output;

    public Delete(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        output.println(item != null ? "Item deleted successfully." : "Error. Item is not deleted");
        return true;
    }
}
