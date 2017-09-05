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
     * Создаем объект трекер.
     */
    private Tracker tracker = new Tracker();
    /**
     * Потоки ввода с клавиатуры.
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Переменная для выбора пункта меню.
     */
    private String pointOfMenu = "";

    /**
     * Метод меню трекера.
     * @throws IOException ексепшены ввода-вывода.
     */

    public void menuOfTracker() throws IOException {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");

        pointOfMenu = reader.readLine();

        System.out.println();
        /**
         * Добавляем новый таск.
         */
        if (pointOfMenu.equals("0")) {

            System.out.println("Please, enter UserName: ");
            String userName = reader.readLine();

            System.out.println("Please, enter task's description: ");
            String tasksDescription = reader.readLine();

            System.out.println();
            System.out.println("task ID " + tracker.add(new Item(userName, tasksDescription)).getId());

            System.out.println();
            menuOfTracker();

        /**
        * Показываем все таски в трекере.
        */

        } else if (pointOfMenu.equals("1")) {

            Item[] arrayOfAllItemInTracker = tracker.findAll();

            if (arrayOfAllItemInTracker.length == 0) {
                System.out.println("No task in tracker!");
                System.out.println();
                menuOfTracker();
            }

            for (Item item : arrayOfAllItemInTracker) {
                if (item != null) {
                    System.out.println("ID: " + item.getId() + "  | Name: " + item.getName() + "  | Description:  " + item.getDescription());
                }
            }

            System.out.println();
            menuOfTracker();
        /**
        *  Редактируем имеющийся в трекере таск.
        */
        } else if (pointOfMenu.equals("2")) {
            Item newItem = new Item();

            System.out.println("For update task enter task's ID: ");
            newItem.setId(reader.readLine());

            System.out.println("Enter new Name: ");
            newItem.setName(reader.readLine());

            System.out.println("Enter new description: ");
            newItem.setDescription(reader.readLine());

            tracker.update(newItem);

            System.out.println();
            menuOfTracker();

            /**
             * Удаляем таск.
             */

        } else if (pointOfMenu.equals("3")) {

            Item deletedItem = new Item();
            System.out.println("For delete task enter task's ID: ");
            deletedItem.setId(reader.readLine());

            tracker.delete(deletedItem);

            System.out.println("The task with ID " + deletedItem.getId() + " was deleted");

            System.out.println();
            menuOfTracker();

            /**
             * Ищем таск по айди.
             */

        } else if (pointOfMenu.equals("4")) {

            System.out.println("For find task by ID, enter task's ID: ");
            Item findItem = tracker.findById(reader.readLine());
            if (findItem != null) {
                System.out.println("Name: " + findItem.getName() + " | Description: " + findItem.getDescription());
                System.out.println();
            }

            menuOfTracker();

            /**
             * Ищем таск по имени.
             */

        } else if (pointOfMenu.equals("5")) {

            System.out.println("Enter the name: ");
            Item[] findItems = tracker.findByName(reader.readLine());
            System.out.println("Founded Items: ");
            for (Item allFindItems : findItems) {
                if (allFindItems != null) {
                    System.out.println("ID: " + allFindItems.getId() + " | Name: " + allFindItems.getName() + " | Description: " + allFindItems.getDescription());
                }
            }

            System.out.println();
            menuOfTracker();

            /**
             * Выход.
             */

        } else if (pointOfMenu.equals("6")) {

            reader.close();
            tracker = null;

            /**
             * Просим ввести числа от 0 до 6.
             */

        } else {

            System.out.println("Enter the number (0-6)");

            System.out.println();
            menuOfTracker();
        }


    }
}
