package ru.job4j.tracker;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс управления меню.
 * @throws IOException екзепшн
 */
public class MenuTracker {
    /**
     * Метод ввода.
     */
    private Input input;
    /**
     * Трекер.
     */
    private Tracker tracker;
    /**
     * Массив действий с меню.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     * @param input метод ввода.
     * @param tracker трекер.
     */
    public MenuTracker(Input input, Tracker tracker) {

        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Добавляем новые объекты действий в массив действий меню.
     * @return возвращает длину массива действий. для массива диапазона прнимаемых значений в Input.
     */
    public int fillActions() {

        int count = 0;
        this.actions.add(count, new AddItem("Add task", count++));
        this.actions.add(count, new ShowAll("Show all tasks", count++));
        this.actions.add(count, new UpdateTask("Edit task", count++));
        this.actions.add(count, new DeleteTask("Delete task", count++));
        this.actions.add(count, new FindByID("Find task by ID", count++));
        this.actions.add(count, new FindByName("Find task by name", count++));
        this.actions.add(count, new ExitProgram("Exit", count++));

        return count;
    }

    /**
     * Метод запускающий действия с трекером в соответствии с ключом.
     * @param key ключ
     * @throws IOException экзепшн.
     */
    public void select(int key) throws IOException {

        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Выводим меню на экран.
     */
    public void show() {

        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Класс для пункта Добавить Таск.
     */
    private class AddItem extends BaseAction {

        /**
         * Конструктор.
         * @param name имя.
         * @param key позиция.
         */
        AddItem(String name, int key) {
            super(name, key);
        }

        /**
         * Add new Item.
         * @throws IOException exception
         * @param input инпут
         * @param tracker трекер
         */
        public void execute(Input input, Tracker tracker) throws IOException {

            String taskName = input.ask("Please, enter TaskName:");
            System.out.println();
            String tasksDescription = input.ask("Please, enter task's description: ");
            System.out.println();
            System.out.println("Task with ID " + tracker.add(new Item(taskName, tasksDescription)).getId() + " created");

        }
    }

    /**
     * Класс для пункта Показать все таски.
     */
    private static class ShowAll extends BaseAction {

        /**
         * Конструктор.
         * @param name имя.
         * @param key позиция.
         */
        ShowAll(String name, int key) {
            super(name, key);
        }

        /**
         * Метод для получения всех добавленных Тасков в трекере.
         * @param input инпут
         * @param tracker трекер
         * @throws IOException экзепшн
         */
        public void execute(Input input, Tracker tracker) throws IOException {

            ArrayList<Item> arrayOfAllItemInTracker = tracker.findAll();

            if (arrayOfAllItemInTracker.size() == 0) {
                System.out.println("No task in tracker!");
                System.out.println();
            }
            for (Item item : arrayOfAllItemInTracker) {
                if (item != null) {
                    System.out.println("ID: " + item.getId() + "  | Name: " + item.getName() + "  | Description:  " + item.getDescription());
                }
            }
        }
    }
}

/**
 * Класс для пункта Edit item.
 */
class UpdateTask extends BaseAction {

    /**
     * Конструктор.
     * @param name имя.
     * @param key позиция.
     */
    UpdateTask(String name, int key) {
        super(name, key);
    }

    /**
     * Метод для замены имеющегося таска новым, нужно знать ИД старого таска.
     * @param input инпут
     * @param tracker трекер
     * @throws IOException екзепшн
     */
    public void execute(Input input, Tracker tracker) throws IOException {

        Item newItem = new Item();
        newItem.setId(input.ask("For update task enter task's ID: "));
        newItem.setName(input.ask("Enter new Name: "));
        newItem.setDescription(input.ask("Enter new description: "));
        tracker.update(newItem);
    }
}

/**
 * Класс для пункта Delete item.
 */
class DeleteTask extends BaseAction {

    /**
     * Конструктор.
     * @param name имя.
     * @param key позиция.
     */
    DeleteTask(String name, int key) {
        super(name, key);
    }

    /**
     * Метод для удаления таска из трекера.
     * @param input инпут
     * @param tracker трекер
     * @throws IOException екзепшн
     */
    public void execute(Input input, Tracker tracker) throws IOException {
        Item deletedItem = new Item();
        deletedItem.setId(input.ask("For delete task enter task's ID: "));
        tracker.delete(deletedItem);
    }
}

/**
 * Класс для пункта Find item by Id.
 */
class FindByID extends BaseAction {

    /**
     * Конструктор.
     * @param name имя.
     * @param key позиция.
     */
    FindByID(String name, int key) {
        super(name, key);
    }

    /**
     * Ищем таски по ИД. ИД уникальные.
     * @param input инпут
     * @param tracker трекер
     * @throws IOException exception.
     */
    public void execute(Input input, Tracker tracker) throws IOException {

        Item findItem = tracker.findById(input.ask("For find task by ID, enter task's ID: "));
        if (findItem != null) {
            System.out.println("Name: " + findItem.getName() + " | Description: " + findItem.getDescription());
            System.out.println();
        }

    }
}

/**
 * Класс для пункта Find item by Name.
 */
class FindByName extends BaseAction {

    /**
     * Конструктор.
     * @param name имя.
     * @param key позиция.
     */
    FindByName(String name, int key) {
        super(name, key);
    }

    /**
     * Ищем таски по имени. Имена могут быть одинаковые.
     * @param input инпут
     * @param tracker трекер
     * @throws IOException екзепшн
     */
    public void execute(Input input, Tracker tracker) throws IOException {

        System.out.println();
        ArrayList<Item> findItems = tracker.findByName(input.ask("Enter the name: "));
        System.out.println("Founded Items: ");
        for (Item allFindItems : findItems) {
            if (allFindItems != null) {
                System.out.println("ID: " + allFindItems.getId() + " | Name: " + allFindItems.getName() + " | Description: " + allFindItems.getDescription());
            }
        }
    }
}

/**
 * Класс для выхода.
 */
class ExitProgram extends BaseAction {

    /**
     * Конструктор.
     * @param name имя.
     * @param key позиция.
     */
    ExitProgram(String name, int key) {
        super(name, key);
    }

    /**
     * Метод для выхода.
     * @param input метод ввода
     * @param tracker трекер
     * @throws IOException экзепшн.
     */
    public void execute(Input input, Tracker tracker) throws IOException {
        System.out.println("Press 'y' to exit!");
    }
}



