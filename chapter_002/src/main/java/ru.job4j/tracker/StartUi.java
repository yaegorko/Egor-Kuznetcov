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
     * Переменная для пунктов меню.
     */
    private String pointOfMenu;

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
     * Add new Item.
     * @throws IOException exception
     */
    public void addNewItem() throws IOException {
        String taskName = input.ask("Please, enter TaskName:");
        System.out.println();
        String tasksDescription = input.ask("Please, enter task's description: ");
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
     * @throws IOException екзепшн
     */
    public void updateTask() throws IOException {

        Item newItem = new Item();
        newItem.setId(input.ask("For update task enter task's ID: "));
        newItem.setName(input.ask("Enter new Name: "));
        newItem.setDescription(input.ask("Enter new description: "));
        this.tracker.update(newItem);
    }

    /**
     * Метод для удаления таска из трекера.
     * @throws IOException екзепшн
     */
    public void deleteItem() throws IOException {

        Item deletedItem = new Item();
        deletedItem.setId(input.ask("For delete task enter task's ID: "));
        tracker.delete(deletedItem);
    }

    /**
     * Ищем таски по ИД. ИД уникальные.
     * @throws IOException exception.
     */
    public void findItemById() throws IOException {

        Item findItem = this.tracker.findById(input.ask("For find task by ID, enter task's ID: "));
        if (findItem != null) {
            System.out.println("Name: " + findItem.getName() + " | Description: " + findItem.getDescription());
            System.out.println();
        }
    }

    /**
     * Ищем таски по имени. Имена могут быть одинаковые.
     * @throws IOException екзепшн
     */
    public void findByName() throws IOException {
        System.out.println();
        Item[] findItems = tracker.findByName(input.ask("Enter the name: "));
        System.out.println("Founded Items: ");
        for (Item allFindItems : findItems) {
            if (allFindItems != null) {
                System.out.println("ID: " + allFindItems.getId() + " | Name: " + allFindItems.getName() + " | Description: " + allFindItems.getDescription());
            }
        }
    }

    /**
     * Метод управления меню.
     * @throws IOException екзепшн
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
        //System.out.println("Select:");

        pointOfMenu = input.ask("Select:");

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

        menuOfTracker();
    }
}
