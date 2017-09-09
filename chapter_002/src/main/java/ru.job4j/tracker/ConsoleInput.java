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
     * @throws IOException ексепшн.
     */
    public String ask(String question) throws IOException {
        System.out.println(question);
        return reader.readLine();
    }
}
