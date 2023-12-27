package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "replace item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Replace item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter id: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Item replaced successfully.");
        } else {
            System.out.println("Error. Item is not replaced");
        }
        return true;
    }
}
