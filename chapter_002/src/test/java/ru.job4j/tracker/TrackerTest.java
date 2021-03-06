package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса Tracker.
 * @author - Egor K.
 * @since - 04.09.17
 */

public class TrackerTest {
    /**
     * новый трекер.
     */
    private final Tracker tracker = new Tracker();
    /**
     * первый эл-т в трекере.
     */
    private final Item firstItem = new Item("test1", "Description1", 123L);
    /**
     * второй.
     */
    private final Item secondItem = new Item("test2", "Description2", 321L);
    /**
     * третий.
     */
    private final Item thirdItem = new Item("test3", "Description3", 456L);

    /**
     * Тест метода add.
     */
    @Test
    public void whenAddNewItemsToTrackerThanReturnTheirNames() {
        assertThat(tracker.add(firstItem).getName(), is("test1"));
        assertThat(tracker.add(secondItem).getName(), is("test2"));
    }

    /**
     * Тест метода update.
     */
    @Test
    public void whenUpdateItemWithSameIdThenReturnNewName() {
        tracker.add(firstItem);
        assertThat(tracker.findAll().get(0), is(firstItem));
        secondItem.setId(firstItem.getId());
        tracker.update(secondItem);
        assertThat(tracker.findAll().get(0), is(secondItem));
    }

    /**
     * Тест метода delete.
     */
    @Test
    public void whenDeleteItemThenCheckOtherOnFirstPlace() {

        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.add(thirdItem);
        tracker.delete(secondItem);
        assertThat(tracker.findAll().get(0), is(firstItem));
        assertThat(tracker.findAll().get(1), is(thirdItem));
        assertThat(tracker.findAll().get(2), is(thirdItem));
    }

    /**
     * тест метода findAll.
     */
    @Test
    public void whenGetAllNotNullItemThenReturnNewArrayLength() {

        tracker.add(firstItem);
        ArrayList<Item> result = tracker.findAll();
        assertThat(result.size(), is(1));
        tracker.add(secondItem);
        result = tracker.findAll();
        assertThat(result.size(), is(2));
        tracker.add(thirdItem);
        result = tracker.findAll();
        assertThat(result.size(), is(3));
    }

    /**
     * тест метода findByName.
     */
    @Test
    public void whenFindByNameThanCheckAllItemsInNewArrayByName() {
        int firstItemCounter = 0;
        for (int i = 0; i < 10; i++) {
            tracker.add(firstItem);
            tracker.add(secondItem);
            tracker.add(thirdItem);
            firstItemCounter++;
        }
        ArrayList<Item> result = tracker.findByName("test1");
        for (int i = 0; i < result.size() - firstItemCounter * 2; i++) {
            assertThat(result.get(i).getName(), is("test1"));
        }
    }
}
