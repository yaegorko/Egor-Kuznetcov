package ru.job4j.tracker;

import java.io.IOException;

/**
 * Класс меню для тестов действий пользователя.
 * @author - Egor K.
 * @since - 07.09.17
 */

public class StubInput implements Input {

    /**
     * Массив для имитации последовательности действий пользователя.
     */
    private String[] strings;

    /**
     * Поле для трекера, получаем из СтартУи.
     */
    private Tracker tracker;

    /**
     * Сеттр трекера.
     * @param tracker трекер
     */
    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Конструктор с массивом стрингов для последовательности действий.
     * @param strings массивом стрингов для имитации последовательности действий.
     */
    public StubInput(String[] strings) {
        this.strings = strings;
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
    private static final String FIND_BY_ID_TEST = "4";
    /**
     * find by name.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * exit.
     */
    private static final String EXIT = "6";

    /**
     * Маркер для ввода в консоль EXIT = "6", меняется на false после ввода переменной для.
     * инициализации первого действия.
     */
    private boolean marker = true;

    /**
     * Переменная для инициализации действий с меню.
     */
    private String pointOfMenu;

    /**
     * Метод для добавления Таска в трекер.
     * @throws IOException экзепшн.
     */
    public void addNewItem() throws IOException {
        System.out.println("Please, enter TaskName: ");
        String taskName = this.strings[1];
        System.out.println(strings[1]);

        System.out.println("Please, enter task's description: ");
        String tasksDescription = this.strings[2];
        System.out.println(strings[2]);

        System.out.println();
        System.out.println("Task with ID " + this.tracker.add(new Item(taskName, tasksDescription)).getId() + " created");
    }

    /**
     * Метод для получения всех добавленных Тасков в трекере.
     * @throws IOException экзепшн
     */
    public void findAll() throws IOException {

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
    }

    /**
     * Метод для замены имеющегося таска новым, нужно знать ИД старого таска.
     */
    public void updateTask() {
        Item newItem = new Item();

        System.out.println("For update task enter task's ID: ");
        newItem.setId(strings[1]);
        System.out.println(strings[1]);

        System.out.println("Enter new Name: ");
        newItem.setName(strings[2]);
        System.out.println(strings[2]);

        System.out.println("Enter new description: ");
        newItem.setDescription(strings[3]);
        System.out.println(strings[3]);

        this.tracker.update(newItem);
    }

    /**
     * Метод для удаления таска из трекера.
     * @throws IOException екзепшн
     */
    public void deleteItem() throws IOException {
        Item deletedItem = new Item();
        System.out.println("For delete task enter task's ID: ");
        deletedItem.setId(strings[1]);
        System.out.println(strings[1]);
        tracker.delete(deletedItem);
    }

    /**
     * Ищем таски по ИД. ИД уникальные.
     * @throws IOException exception.
     */
    public void findItemById() throws IOException {

        System.out.println("For find task by ID, enter task's ID: ");
        Item findItem = this.tracker.findById(strings[1]);
        System.out.println(strings[1]);
        if (findItem != null) {
            System.out.println("Name: " + findItem.getName() + " | Description: " + findItem.getDescription());
            System.out.println();
        }
    }

    /**
     * Ищем таски по имени. Имена могут быть одинаковые.
     */
    public void findByName() {
        System.out.println("Enter the name: ");
        Item[] findItems = tracker.findByName(strings[1]);
        System.out.println(strings[1]);
        System.out.println("Founded Items: ");
        for (Item allFindItems : findItems) {
            if (allFindItems != null) {
                System.out.println("ID: " + allFindItems.getId() + " | Name: " + allFindItems.getName() + " | Description: " + allFindItems.getDescription());
            }
        }
    }

    /**
     * Метод управляющий меню действий с трекером.
     * @throws IOException экзепшн.
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
        if (marker) {
            pointOfMenu = strings[0];
            System.out.println(pointOfMenu);
            System.out.println();
            marker = false;
        } else {
            pointOfMenu = strings[strings.length - 1];
            System.out.println(pointOfMenu);
        }

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

            findAll();
            menuOfTracker();

        /*
            Редактируем имеющийся в трекере таск.
        */
        } else if (EDIT.equals(pointOfMenu)) {

            updateTask();
            menuOfTracker();

        /*
            Удаляем таск.
        */
        } else if (DELETE.equals(pointOfMenu)) {

            deleteItem();
            menuOfTracker();

        /*
            Ищем таск по айди.
        */
        } else if (FIND_BY_ID_TEST.equals(pointOfMenu)) {

            findItemById();
            menuOfTracker();

        /*
            Ищем таск по имени.
        */
        } else if (FIND_BY_NAME.equals(pointOfMenu)) {

            findByName();
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
