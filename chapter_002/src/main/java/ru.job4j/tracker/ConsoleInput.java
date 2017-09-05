package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс меню. В нем выбираем действия с трекером.
 * @author - Egor K.
 * @since - 05.09.17
 */

public class ConsoleInput {
    /**
     * add.
     */
    private static final String ADD = "0";
    /**
     * showall.
     */
    private static final String SHOWALL = "1";
    /**
     * edit.
     */
    private static final String EDIT = "2";
    /**
     * delete.
     */
    private static final String DELETE = "3";
    /**
     * findbyid.
     */
    private static final String FINDID = "4";
    /**
     * findbyname.
     */
    private static final String FINDNAME = "5";
    /**
     * exit.
     */
    private static final String EXIT = "6";
    /**
     * Создаем объект трекер.
     */
    private Tracker tracker = new Tracker();
    /**
     * Потоки ввода с клавиатуры.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Add new Item.
     * @throws IOException exception
     */

    public void addNewItem() throws IOException {
        System.out.println("Please, enter UserName: ");
        String userName = reader.readLine();

        System.out.println("Please, enter task's description: ");
        String tasksDescription = reader.readLine();

        System.out.println();
        System.out.println("Task ID " + tracker.add(new Item(userName, tasksDescription)).getId() + " created");

    }

    /**
     * Find Item by ID.
     * @throws IOException exception.
     */
    public void findItemById() throws IOException {

        System.out.println("For find task by ID, enter task's ID: ");
        Item findItem = tracker.findById(reader.readLine());
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

        } else if (SHOWALL.equals(pointOfMenu)) {

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

        } else if (FINDID.equals(pointOfMenu)) {

            findItemById();
            menuOfTracker();

        /*
            Ищем таск по имени.
        */

        } else if (FINDNAME.equals(pointOfMenu)) {

            menuOfTracker();

        /*
            Выход.
        */

        } else if (EXIT.equals(pointOfMenu)) {

            tracker = null;

        /*
            Просим ввести числа от 0 до 6.
        */

        } else {

            System.out.println("Enter the number (0-6)");
            menuOfTracker();
        }


    }

}
