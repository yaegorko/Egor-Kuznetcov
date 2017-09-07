package ru.job4j.tracker;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StubInputTest {
    // создаём Tracker
    private Tracker tracker = new Tracker();

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws IOException {
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUi(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUserGetAllItemsThenCheckIt() throws IOException {
        tracker.add(new Item());
        tracker.add(new Item());
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findAll().length, is(2));

    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws IOException {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("Old name", "Old desk"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "New name", "New desc", "6"});
        assertThat(tracker.findById(item.getId()).getName(), is("Old name"));
        // создаём StartUI и вызываем метод init()
        new StartUi(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("New name"));
    }

    @Test
    public void deleteTest() throws IOException {
        Item item = tracker.add(new Item());
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        assertThat(tracker.findAll().length, is(1));
        new StartUi(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void findById() throws IOException {
        Item item = tracker.add(new Item("findByIdName", "findByIdDesc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("findByIdName"));
    }

    @Test
    public void findByName() throws IOException {
        Item item = tracker.add(new Item("findByNameName", "findByNameDesc"));
        Item item2 = tracker.add(new Item("findByNameName", "findByNameDesc2"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUi(input, tracker).init();
        assertThat(tracker.findByName("findByNameName").length, is(2));
    }
}
