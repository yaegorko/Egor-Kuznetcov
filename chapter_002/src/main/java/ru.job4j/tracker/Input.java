package ru.job4j.tracker;

import java.io.IOException;

/**
 * Интефейс классов StubInput и ConsoleInput.
 */

public interface Input {
   /**
    * Метод для меню.
    * @throws IOException эксепшн ввода вывода.
    */
   void menuOfTracker() throws IOException;

   /**
    * Передаем трекер.
    * @param tracker трекер
    */
   void setTracker(Tracker tracker);

}
