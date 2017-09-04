package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    private final Tracker tracker = new Tracker();
    private final Item firstItem = new Item("test1", "Description1", 123L);
    private final Item secondItem = new Item("test2", "Description2", 321L);
    private final Item thirdItem = new Item("test3", "Description2", 321L);


    @Test
    public void updateTest() {
        tracker.add(firstItem);
        secondItem.setId(firstItem.getId());
        tracker.update(secondItem);
        assertThat(tracker.findById(secondItem.getId()).getName(), is("test2"));
    }

    @Test
    public void deletedTest() {

        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.add(thirdItem);
        tracker.delete(secondItem);
        assertThat(tracker.findAll()[0], is(firstItem));

    }

    @Test
    public void findAllTest() {

        tracker.add(firstItem);
        tracker.add(secondItem);
        Item[] result = tracker.findAll();
        assertThat(result.length, is(2));
    }

    @Test
    public void findByNameTest() {
        int firstItemCounter = 0;
        for (int i = 0; i < 10; i++) {
            tracker.add(firstItem);
            tracker.add(secondItem);
            tracker.add(thirdItem);
            firstItemCounter++;
        }
        Item[] result = tracker.findByName("test1");
        for (int i = 0; i < result.length - firstItemCounter * 2; i++) {
            assertThat(result[i].getName(), is("test1"));
        }


    }
}
