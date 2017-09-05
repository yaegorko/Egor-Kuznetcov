package ru.job4j.tracker;

import java.io.IOException;

/**
 * Класс связывающий все классы в трекере.
 */
public class StartUi {
    /**
     * Мейн.
     * @param args массив стрингов
     * @throws IOException бросаем эксепшены.
     */
    public static void main(String[] args) throws IOException {

      new StartUi().init();

    }

    /**
     * Инит.
     * @throws IOException инит.
     */
    public void init() throws IOException {

        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.menuOfTracker();
    }
}
