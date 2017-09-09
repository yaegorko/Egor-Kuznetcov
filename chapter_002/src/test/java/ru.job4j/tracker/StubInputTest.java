package ru.job4j.tracker;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов имитации последовательности действий пользователя.
 * @author - Egor K.
 * @since - 07.09.17
 */
public class StubInputTest {
    /**
     * Трекер для всех тестов.
     */
    private Tracker tracker = new Tracker();

    /**
     * Тест добавления таска в трекер пользователем.
     * @throws IOException экзепшн.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws IOException {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "n", "6", "y"});
        new StartUi(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Тест получения всех добавленных тасков пользователем.
     * @throws IOException экзепшн
     */
    @Test
    public void whenUserGetAllItemsThenCheckItNumber() throws IOException {
        tracker.add(new Item());
        tracker.add(new Item());
        Input input = new StubInput(new String[]{"1", "n", "6", "y"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));
    }

    /**
     * Тест замены пользователем таска новым таском.
     * @throws IOException экзепшн
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws IOException {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("Old name", "Old desk"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "New name", "New desc", "n", "6", "y"});
        //проверяем наличие старого таска в трекере
        assertThat(tracker.findById(item.getId()).getName(), is("Old name"));
        // создаём StartUI и вызываем метод init()
        new StartUi(input, tracker).init();
        // проверяем, что таск поменялся.
        assertThat(tracker.findById(item.getId()).getName(), is("New name"));
    }

    /**
     * Тест удаления таска пользователем.
     * @throws IOException экзепшн
     */
    @Test
    public void whenDeleteTaskThanCheckNewArrayLength() throws IOException {
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "n", "6", "y"});
        assertThat(tracker.findAll().length, is(1));
        new StartUi(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    /**
     * Тест поиска тасков пользователем по имени.
     * @throws IOException экзепшн
     */
    @Test
    public void whenFindTaskByIdThanCheckName() throws IOException {
        Item item = tracker.add(new Item("findByIdName", "findByIdDesc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "n", "6", "y"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("findByIdName"));
    }

    /**
     * Тест поиска таска пользователем по ИД.
     * @throws IOException экзепшн
     */
    @Test
    public void findByName() throws IOException {
        Item item = tracker.add(new Item("findByNameName", "findByNameDesc"));
        Item item2 = tracker.add(new Item("findByNameName", "findByNameDesc2"));
        Input input = new StubInput(new String[]{"5", item.getName(), "n", "6", "y"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findByName("findByNameName").length, is(2));
    }
}
