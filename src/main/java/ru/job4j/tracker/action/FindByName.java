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
        List<Item>[] items = new ArrayList[]{(ArrayList) tracker.findByName(name)};
        if (items.length > 0) {
            for (List<Item> item : items) {
                for (Item each : item) {
                    output.println(each);
                }
            }
        } else {
            output.println("Items with name: \"" + name + "\" are not found.");
        }
        return true;
    }
}
