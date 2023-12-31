package ru.job4j.tracker;

import ru.job4j.tracker.action.*;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Enter menu: ");
            if (select < 0 || select >= actions.length) {
                output.println("Incorrect input, you can choose from 0 to " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        output.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            output.println("Enter " + i + " to " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new FindAll(output),
                new Replace(output),
                new Delete(output),
                new FindByID(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
