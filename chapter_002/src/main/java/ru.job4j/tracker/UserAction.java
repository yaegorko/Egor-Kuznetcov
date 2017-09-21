package ru.job4j.tracker;

import java.io.IOException;

/**
 * Прототип класса BaseActionпше управления меню трекера.
 */
public interface UserAction {
    /**
     * Позиция в меню и в массиве меню.
     * @return кей - позицию.
     */
    int key();

    /**
     * Метод выполняющий действия соответствующие позиции меню.
     * @param input метод ввода
     * @param tracker трекер
     * @throws IOException экзепшн
     */
    void execute(Input input, Tracker tracker) throws IOException;

    /**
     * Метод вывода информации о классе.
     * @return имя в меню
     */
    String info();
}
