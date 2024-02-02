package ru.job4j.tracker.action;

import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.List;

public class FindByName implements UserAction {
    private final Output output;

    public FindByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "search items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Search items by name ===");
        String name = input.askStr("Enter name: ");
//        public List<Item> findAll() {return new ArrayList<>(items);}
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                    output.println(item);
            }
        } else {
            output.println("Items with name: \"" + name + "\" are not found.");
        }
        return true;
    }
}
