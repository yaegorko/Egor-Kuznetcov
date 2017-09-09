package ru.job4j.tracker;

import java.io.IOException;

/**
 * Класс меню для тестов действий пользователя.
 * @author - Egor K.
 * @since - 07.09.17
 */

public class StubInput implements Input {

    /**
     * Массив для имитации последовательности действий пользователя.
     */
    private String[] strings;

    /**
     * Конструктор с массивом стрингов для последовательности действий.
     * @param strings массивом стрингов для имитации последовательности действий.
     */
    public StubInput(String[] strings) {
        this.strings = strings;
    }

    /**
     * Позиция в массиве.
     */
    private int count = 0;

    /**
     * Метод аск возвращает последовательно массив.
     * @param question вопрос
     * @return ответ, либо пункт меню.
     * @throws IOException ексепшн.
     */
    public String ask(String question) throws IOException {
        System.out.println(question);
        System.out.println(strings[count]);
        return strings[count++];
    }
}
