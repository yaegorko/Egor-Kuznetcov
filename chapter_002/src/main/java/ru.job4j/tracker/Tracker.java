package ru.job4j.tracker;

import java.util.Random;

/**
 * Класс трекер.
 * @author - Egor K.
 * @since - 04.09.17
 */

public class Tracker {

    /**
     * Массив заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Переменная отвечающая за индекс элемента массива.
     */
    private int position = 0;
    /**
     * Для генерации Айди.
     */
    private static final Random RN = new Random();

    /**
     * Добавляем новую заявку в Трекер.
     * @param item новая заявка.
     * @return итем (зачем?)
     * спросить почему метод не войд??
     *
     */
    public Item add(Item item) {
        item.setId(this.generateID());
        this.items[position++] = item;
        return this.items[position - 1];
    }

    /**
     * Генерим Айди.
     * @return Айди.
     * Время создания заявки + рандом.
     */
    String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Апдейтим заявку.
     * @param item новая заявка с АйДи той которую меняем.
     */

    public void update(Item item) {
        for (int index = 0; index < position; index++) {
            if (this.items[index] != null && item.getId().equals(this.items[index].getId())) {
                this.items[index] = item;
                break;
            }
        }
        // System.out.println("No one task with same ID!");
    }

    /**
     * Удаляем заявку.
     * @param item который удаляем.
     * Сдвигаем массив влево затирая элемент который нужно удалить, последний э-лт в исходном массиве заявок зануляем.
     */

    public void delete(Item item) {
        Item[] newArray = new Item[this.position - 1];
        for (int index = 1; index < position + 1; index++) {
            if (this.items[index - 1] != null && item.getId().equals(this.items[index - 1].getId())) {
                System.arraycopy(this.items, 0, newArray, 0, index - 1);
                System.arraycopy(this.items, index, newArray, index - 1, this.position - index);
                this.items[this.position - 1] = null;
                System.arraycopy(newArray, 0, this.items, 0, newArray.length);
                this.position--;
                break;
            }
        }
    }

    /**
     * Метод возвращает все не нулевые эл-ты массива заявок.
     * @return массив ненулевых эл-тов массива заявок.
     */
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

    /**
     * МЕтод поиска в массиве заявок по имени.
     * @param key имя итема.
     * @return массив эл-тов с именем key.
     */
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

    /**
     * МЕтод поиска в массиве заявок по ID.
     * @param id ID
     * @return элемент с уникальным ID.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item itemInArray : this.items) {
            if (itemInArray != null && itemInArray.getId().equals(id)) {
                result = itemInArray;
            } else {
                result = new Item();
                result.setDescription("Can't find task in tracker!");
                result.setName("ERROR: Wrong ID!");
            }
        }
        return result;
    }
}
