package ru.job4j.tracker;

import java.io.IOException;

/**
 * Класс связывающий все классы в трекере.
 */
public class StartUi {

    /**
     * Поле для объектов классов интервейса Input.
     */
    private Input input;

    /**
     * Поле для объектов класса Tracker.
     */
    private Tracker tracker;

    /**
     * сеттер трекера. сетим в Инпуты.
     * @param tracker трекер.
     */
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Конструктор StartUi.
     * @param input принимаем инпуты.
     * @param tracker принимаем трекер.
     */
    public StartUi(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Мейн. Создаем объект.
     * @param args массив стрингов
     * @throws IOException бросаем эксепшены.
     */
    public static void main(String[] args) throws IOException {

        new StartUi(new ValidateInput(), new Tracker()).init();

    }

    /**
     * Инит. Передаем в инпут трекер. Стартуем меню инпутов.
     * @throws IOException инит.
     */
    public void init() throws IOException {

        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        int[] ranges = new int[menuTracker.fillActions()];
        int count = 0;

        for (int elements : ranges) {
            ranges[count] = count++;
        }
        do {
            menuTracker.show();
            menuTracker.select(input.ask("Select", ranges));
        } while (!"y".equals(this.input.ask("Exit program? (y/n)")));
    }
}
