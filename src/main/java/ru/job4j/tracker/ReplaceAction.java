package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
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
