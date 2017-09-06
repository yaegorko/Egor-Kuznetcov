package ru.job4j.tracker;

import java.io.IOException;

/**
 * Класс связывающий все классы в трекере.
 */
public class StartUi {

    private Input input;
    private Tracker tracker;

    public StartUi() {
    }

    public StartUi(Input input) {
        this.input = input;
    }

    public StartUi(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }

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

        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        input.setTracker(tracker);
        input.start();

    }
}
