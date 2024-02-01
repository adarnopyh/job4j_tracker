package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
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

    private void showMenu(List<UserAction> actions) {
        output.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            output.println("Enter " + i + " to " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new Create(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new FindByID(output),
                new FindByName(output),
                new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }
}
