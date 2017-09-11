package ru.job4j.tracker;

import java.io.IOException;
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
    private UserAction[] actions = new UserAction[7];

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

        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAll();
        this.actions[2] = new UpdateTask();
        this.actions[3] = new DeleteTask();
        this.actions[4] = new FindByID();
        this.actions[5] = new FindByName();
        this.actions[6] = new ExitProgram();

        return actions.length;
    }

    /**
     * Метод запускающий действия с трекером в соответствии с ключом.
     * @param key ключ
     * @throws IOException экзепшн.
     */
    public void select(int key) throws IOException {

        this.actions[key].execute(this.input, this.tracker);
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
    private class AddItem implements UserAction {
        /**
         * Позиция в меню и в массиве меню.
         * @return кей.
         */
        public int key() {
            return 0;
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

        /**
         * Метод вывода информации о классе.
         * @return имя в меню
         */
        public String info() {

            return String.format("%s. %s", this.key(), "Add new item.");
        }
    }

    /**
     * Класс для пункта Показать все таски.
     */
    private static class ShowAll implements UserAction {
        /**
         * Позиция в меню и в массиве меню.
         * @return кей.
         */
        public int key() {
            return 1;
        }
        /**
         * Метод для получения всех добавленных Тасков в трекере.
         * @param input инпут
         * @param tracker трекер
         * @throws IOException экзепшн
         */
        public void execute(Input input, Tracker tracker) throws IOException {

            Item[] arrayOfAllItemInTracker = tracker.findAll();

            if (arrayOfAllItemInTracker.length == 0) {
                System.out.println("No task in tracker!");
                System.out.println();
            }
            for (Item item : arrayOfAllItemInTracker) {
                if (item != null) {
                    System.out.println("ID: " + item.getId() + "  | Name: " + item.getName() + "  | Description:  " + item.getDescription());
                }
            }
        }

        /**
         * Метод вывода информации о классе.
         * @return имя в меню
         */
        public String info() {

            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
}

/**
 * Класс для пункта Edit item.
 */
class UpdateTask implements UserAction {
    /**
     * Позиция в меню и в массиве меню.
     * @return кей.
     */
    public int key() {
        return 2;
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

    /**
     * Метод вывода информации о классе.
     * @return имя в меню
     */
    public String info() {

        return String.format("%s. %s", this.key(), "Edit item.");
    }
}

/**
 * Класс для пункта Delete item.
 */
class DeleteTask implements UserAction {
    /**
     * Позиция в меню и в массиве меню.
     * @return кей.
     */
    public int key() {
        return 3;
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

    /**
     * Метод вывода информации о классе.
     * @return имя в меню
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item.");
    }
}

/**
 * Класс для пункта Find item by Id.
 */
class FindByID implements UserAction {
    /**
     * Позиция в меню и в массиве меню.
     * @return кей.
     */
    public int key() {
        return 4;
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

    /**
     * Метод вывода информации о классе.
     * @return имя в меню
     */
    public String info() {

        return String.format("%s. %s", this.key(), "Find item by Id.");
    }
}

/**
 * Класс для пункта Find item by Name.
 */
class FindByName implements UserAction {
    /**
     * Позиция в меню и в массиве меню.
     * @return кей.
     */
    public int key() {
        return 5;
    }

    /**
     * Ищем таски по имени. Имена могут быть одинаковые.
     * @param input инпут
     * @param tracker трекер
     * @throws IOException екзепшн
     */
    public void execute(Input input, Tracker tracker) throws IOException {

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
     * Метод вывода информации о классе.
     * @return имя в меню
     */
    public String info() {

        return String.format("%s. %s", this.key(), "Find item by Name.");
    }
}

/**
 * Класс для выхода.
 */
class ExitProgram implements UserAction {
    /**
     * Позиция в меню и в массиве меню.
     * @return кей.
     */
    public int key() {
        return 6;
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

    /**
     * Метод вывода информации о классе.
     * @return имя в меню
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Exit.");
    }
}


