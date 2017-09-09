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

        new StartUi(new ConsoleInput(), new Tracker()).init();

    }

    /**
     * Инит. Передаем в инпут трекер. Стартуем меню инпутов.
     * @throws IOException инит.
     */
    public void init() throws IOException {
        int key = 6;
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        do {
            menuTracker.show();
            try {
                key = Integer.valueOf(input.ask("Select (0-6):"));
            } catch (NumberFormatException x) {
                System.out.println("Enter number 0-6!");
            }

            if (key >= 0 && key < 7) {
                menuTracker.select(key);
            }
        } while (!"y".equals(this.input.ask("Exit program? (y/n)")));
    }
}
