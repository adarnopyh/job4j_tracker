package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Mock;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new Stub();
        Input input = new Mock(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceAction() {
        Output output = new Stub();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new Mock(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new Stub();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new Mock(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new Delete(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new Stub();
        Input input = new Mock(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                        + "Enter 0 to exit" + System.lineSeparator()
                        + "=== Completing the program ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new Mock(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "Enter 0 to replace item" + ln
                        + "Enter 1 to exit" + ln
                        + "=== Replace item ===" + ln
                        + "Item replaced successfully." + ln
                        + "Menu:" + ln
                        + "Enter 0 to replace item" + ln
                        + "Enter 1 to exit" + ln
                        + "=== Completing the program ===" + ln
        );
    }

    @Test
    void whenFindAllActionIsSuccessfully() {
        Output output = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input input = new Mock(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "Enter 0 to list all items" + ln
                        + "Enter 1 to exit" + ln
                        + "=== List all items ===" + ln
                        + one + ln
                        + two + ln
                        + three + ln
                        + "Menu:" + ln
                        + "Enter 0 to list all items" + ln
                        + "Enter 1 to exit" + ln
                        + "=== Completing the program ===" + ln
        );
    }

    @Test
    void whenFindByNameActionIsSuccessfully() {
        Output output = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test"));
        Item three = tracker.add(new Item("test3"));
        Input input = new Mock(
                new String[]{"0", "test", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "Enter 0 to search items by name" + ln
                        + "Enter 1 to exit" + ln
                        + "=== Search items by name ===" + ln
                        + two + ln
                        + "Menu:" + ln
                        + "Enter 0 to search items by name" + ln
                        + "Enter 1 to exit" + ln
                        + "=== Completing the program ===" + ln
        );
    }

    @Test
    void whenFindByIdActionIsSuccessfully() {
        Output output = new Stub();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test"));
        Item three = tracker.add(new Item("test3"));
        Input input = new Mock(
                new String[]{"0", String.valueOf(three.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByID(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu:" + ln
                        + "Enter 0 to search item by ID" + ln
                        + "Enter 1 to exit" + ln
                        + "=== Search items by ID ===" + ln
                        + three + ln
                        + "Menu:" + ln
                        + "Enter 0 to search item by ID" + ln
                        + "Enter 1 to exit" + ln
                        + "=== Completing the program ===" + ln
        );
    }
}