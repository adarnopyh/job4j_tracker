package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();

    private int ids = items.size() + 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item>[] findAll() {
        ArrayList<Item> copyOf = new ArrayList<>(items);
        return new ArrayList[]{copyOf};
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.size()];
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            Item name = items.get(i);
            if (name.getName().equals(key)) {
                result[count] = name;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        boolean result = i != -1;
        if (result) {
            item.setId(id);
            items.set(i, item);
        }
        return result;
    }

    public void delete(int id) {
        int i = indexOf(id);
        boolean result = i != -1;
        if (result) {
            items.remove(i);
        }
    }
}