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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (name.getName().equals(key)) {
                result[count] = name;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
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
        int length = size - index - 1;
        if (index != -1) {
            System.arraycopy(items, start, items, index, length);
            items[size - 1] = null;
            size--;
        }
    }

}