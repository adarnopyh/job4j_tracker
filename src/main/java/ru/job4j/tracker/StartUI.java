package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

import java.util.ArrayList;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter menu: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Incorrect input, you can choose from 0 to " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        output.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            output.println("Enter " + i + " to " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new Create(output));
        actions.add(new FindAll(output));
        actions.add(new Replace(output));
        actions.add(new Delete(output));
        actions.add(new FindByID(output));
        actions.add(new FindByName(output));
        actions.add(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }

}
