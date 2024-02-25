package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {
    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List result = tracker.findAll();
        assertThat(result.get(0).equals(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        tracker.delete(1000);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
    }

    @Test
    public void whenAscByName() {
        List<Item> items = new ArrayList<>();
        Item itemB = new Item("B");
        Item itemA = new Item("A");
        Item itemC = new Item("C");
        items.add(itemB);
        items.add(itemA);
        items.add(itemC);
        items.sort(new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(itemA);
        expected.add(itemB);
        expected.add(itemC);
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenDescByName() {
        List<Item> items = new ArrayList<>();
        Item itemB = new Item("B");
        Item itemA = new Item("A");
        Item itemC = new Item("C");
        items.add(itemB);
        items.add(itemA);
        items.add(itemC);
        items.sort(new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(itemC);
        expected.add(itemB);
        expected.add(itemA);
        assertThat(items).isEqualTo(expected);
    }
}