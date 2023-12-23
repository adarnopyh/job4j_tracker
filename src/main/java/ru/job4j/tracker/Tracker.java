package ru.job4j.tracker;

import ru.job4j.pojo.Book;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] names = items;
        Item[] result = new Item[names.length];
        int size = 0;
        for (int i = 0; i < names.length; i++) {
            Item name = names[i];
            if (name != null) {
                result[size] = name;
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public Item[] findByName(String key) {
        Item[] names = items;
        Item[] result = new Item[names.length];
        int size = 0;
        for (int i = 0; i < names.length; i++) {
            Item name = names[i];
            if (name != null && name.getName().equals(key)) {
                result[size] = name;
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        if (i != -1) {
            Item cell = items[i];
            cell.setName(item.getName());
            return true;
        }
        return false;
    }

    public void delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int length = size - index -1;
        if (index != -1) {
            System.arraycopy(items, start, items, index, length);
            items[size - 1] = null;
            size--;
        }
    }
}