package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
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