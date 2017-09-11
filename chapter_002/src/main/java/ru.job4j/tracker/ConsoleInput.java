package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс меню. В нем выбираем действия с трекером.
 * @author - Egor K.
 * @since - 05.09.17
 */

public class ConsoleInput implements Input {

    /**
     *Буфер ридр.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Аск вводим с клавиатуры ответы на вопросы.
     * @param question вопрос
     * @return ответ, либо пункт меню.
     * @throws IOException тянется от буфер ридера.
     */
    public String ask(String question) throws IOException {

        System.out.println(question);
        return reader.readLine();
    }

    /**
     * Перегруженный Аск для валидации ввода в консоль.
     * @param question вопрос
     * @param range дипазон допустимых значений ввода.
     * @return допустимое значение key (элемента меню действий) или исключение "Вне диапазона."
     * @throws IOException тянется от буфер ридера.
     */
    public int ask(String question, int[] range) throws IOException {

        int key = Integer.valueOf(ask(question));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
