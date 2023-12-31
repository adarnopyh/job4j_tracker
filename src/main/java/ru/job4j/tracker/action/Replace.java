package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class Replace implements UserAction {
    private final Output output;

    public Replace(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Replace item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter id: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("Item replaced successfully.");
        } else {
            output.println("Error. Item is not replaced");
        }
        return true;
    }
}
