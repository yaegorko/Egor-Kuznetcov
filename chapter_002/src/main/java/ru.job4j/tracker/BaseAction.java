package ru.job4j.tracker;

import java.io.IOException;

/**
 * Класс прототип классов действий меню.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Название пункта меню.
     */
    private String name;

    /**
     * Позиция в меню.
     */
    private int key;

    /**
     * Конструктор.
     * @param name имя.
     * @param key позиция.
     */
    BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     * Вернем позицию.
     * @return кей - позиция.
     */
    public int key() {
        return this.key;
    }

    /**
     * Прототип метода выполняющего действиия соответствующие выбору.
     * @param input метод ввода
     * @param tracker трекер
     * @throws IOException тянет буфер реадер.
     */
    public abstract void execute(Input input, Tracker tracker) throws IOException;

    /**
     * Метод формирует позицию в меню.
     * @return строку с номером и названием
     */
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
