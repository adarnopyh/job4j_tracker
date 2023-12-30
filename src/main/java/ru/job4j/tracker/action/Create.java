package ru.job4j.tracker.action;

import ru.job4j.tracker.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class Create implements UserAction {
    private final Output output;

    public Create(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "create new item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create new item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Added item: " + item);
        return true;
    }
}