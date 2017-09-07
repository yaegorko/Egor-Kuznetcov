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
     * Поле для трекера.
     */
    private Tracker tracker;

    /**
     * сеттр трекера.
     * @param tracker Трекер
     */
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
    /**
     * add.
     */
    private static final String ADD = "0";
    /**
     * show all.
     */
    private static final String SHOW_ALL = "1";
    /**
     * edit.
     */
    private static final String EDIT = "2";
    /**
     * delete.
     */
    private static final String DELETE = "3";
    /**
     * find by id.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * find by name.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * exit.
     */
    private static final String EXIT = "6";

    /**
     * Потоки ввода с клавиатуры.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Add new Item.
     * @throws IOException exception
     */
    public void addNewItem() throws IOException {
        System.out.println("Please, enter TaskName: ");
        String taskName = reader.readLine();

        System.out.println("Please, enter task's description: ");
        String tasksDescription = reader.readLine();

        System.out.println();
        System.out.println("Task with ID " + this.tracker.add(new Item(taskName, tasksDescription)).getId() + " created");

    }

    /**
     * Find Item by ID.
     * @throws IOException exception.
     */
    public void findItemById() throws IOException {

        System.out.println("For find task by ID, enter task's ID: ");
        Item findItem = this.tracker.findById(reader.readLine());
        if (findItem != null) {
            System.out.println("Name: " + findItem.getName() + " | Description: " + findItem.getDescription());
            System.out.println();
        }
    }

    /**
     * Метод меню трекера.
     * @throws IOException ексепшены ввода-вывода.
     */
    public void menuOfTracker() throws IOException {

        System.out.println();
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");

        /*
            Переменная для выбора пункта меню.
        */
        String pointOfMenu = reader.readLine();
        System.out.println();

        /*
             Добавляем новый таск.
        */

        if (ADD.equals(pointOfMenu)) {

            addNewItem();
            menuOfTracker();

        /*
            Показываем все таски в трекере.
        */

        } else if (SHOW_ALL.equals(pointOfMenu)) {

            menuOfTracker();

        /*
            Редактируем имеющийся в трекере таск.
        */

        } else if (EDIT.equals(pointOfMenu)) {

            menuOfTracker();

        /*
            Удаляем таск.
        */

        } else if (DELETE.equals(pointOfMenu)) {

            menuOfTracker();

        /*
            Ищем таск по айди.
        */

        } else if (FIND_BY_ID.equals(pointOfMenu)) {

            findItemById();
            menuOfTracker();

        /*
            Ищем таск по имени.
        */

        } else if (FIND_BY_NAME.equals(pointOfMenu)) {

            menuOfTracker();

        /*
            Выход.
        */

        } else if (EXIT.equals(pointOfMenu)) {

            return;

        /*
            Просим ввести числа от 0 до 6.
        */

        } else {

            System.out.println("Enter the number (0-6)");
            menuOfTracker();
        }
    }
}
