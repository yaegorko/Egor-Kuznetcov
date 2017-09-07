package ru.job4j.tracker;

import java.io.IOException;

/**
 * Класс связывающий все классы в трекере.
 */
public class StartUi {

    private Input input;

    private Tracker tracker;

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public StartUi(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Мейн.
     * @param args массив стрингов
     * @throws IOException бросаем эксепшены.
     */
    public static void main(String[] args) throws IOException {

        new StartUi(new ConsoleInput(), new Tracker()).init();

    }

    /**
     * Инит.
     * @throws IOException инит.
     */
    public void init() throws IOException {

        input.setTracker(this.tracker);
        input.menuOfTracker();
    }
}
