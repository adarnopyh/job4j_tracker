package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.List;

public class FindAll implements UserAction {
    private final Output output;

    public FindAll(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "list all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== List all items ===");
        List<Item>[] items = tracker.findAll();
        if (items.length > 0) {
            for (List<Item> item : items) {
                for (Item each : item) {
                    output.println(each);
                }
            }
        } else {
            output.println("The database is empty");
        }
        return true;
    }
}
