package ru.job4j.tracker;

import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateID());
        this.items[position++] = item;
        return item;
    }

    String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public void update(Item item) {
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null && item.getId().equals(this.items[index].getId())) {
                this.items[index] = item;
                break;
            }
        }
    }

    public void delete(Item item) {
        Item[] newArray = new Item[this.position - 1];
        for (int index = 1; index < position + 1; index++) {
            if (this.items[index - 1] != null && item.getId().equals(this.items[index - 1].getId())) {
                System.arraycopy(this.items, 0, newArray, 0, index - 1);
                System.arraycopy(this.items, index, newArray, index - 1, this.position - index);
                System.arraycopy(newArray, 0, this.items, 0, newArray.length - 1);
                this.items[this.position - 1] = null;
                break;
            }
        }
    }

    public Item[] findAll() {
        Item[] resultArray = new Item[position];
        int resultArrayIndex = 0;
        for (Item itemsInArray : items) {
            if (itemsInArray != null) {
                resultArray[resultArrayIndex] = itemsInArray;
                resultArrayIndex++;
            }
        }
        return resultArray;
    }

    public Item[] findByName(String key) {
        Item[] resultArray = new Item[position];
        int resultArrayIndex = 0;
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null && key.equals(this.items[index].getName())) {
                resultArray[resultArrayIndex] = this.items[index];
                resultArrayIndex++;
            }
        }
        return resultArray;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item itemInArray : this.items) {
            if (itemInArray != null && itemInArray.getId().equals(id)) {
                result = itemInArray;
            }
        }

        return result;
    }
}
