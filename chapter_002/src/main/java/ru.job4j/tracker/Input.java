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
}
