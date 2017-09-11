package ru.job4j.tracker;

import java.io.IOException;

/**
 * Интефейс классов StubInput и ConsoleInput.
 */

public interface Input {

   /**
    * Прототип аска.
    * @param question вопрос.
    * @return ответ.
    * @throws IOException екзепшн.
    */
   String ask(String question) throws IOException;

    /**
     * Прототип перегруженного метода Аск для валидации ввода в консоль.
     * @param question вопрос
     * @param range дипазон допустимых значений ввода.
     * @return допустимое значение key (элемента меню действий) или исключение "Вне диапазона."
     * @throws IOException тянется от буфер ридера.
     */
   int ask(String question, int[] range) throws IOException;
}

