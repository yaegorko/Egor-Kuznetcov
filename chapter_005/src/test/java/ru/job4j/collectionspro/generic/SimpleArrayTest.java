package ru.job4j.collectionspro.generic;

import org.junit.Test;
import ru.job4j.collectionspro.generic.SimpleArray;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс тестов класса SimpleArray.
 */
public class SimpleArrayTest {
    /**
     * Тест add.
     */
    @Test
    public void whenAddElementsToSimpleArray() {
        SimpleArray simpleArray = new SimpleArray(2);
        simpleArray.add(1);
        simpleArray.add("www");
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is("www"));

    }

    /**
     * Тест update.
     */
    @Test
    public void whenUpdateElementInSimpleArray() {
        SimpleArray simpleArray = new SimpleArray(2);
        simpleArray.add(1);
        simpleArray.add("www");
        simpleArray.update(0, "1");
        assertThat(simpleArray.get(0), is("1"));
        simpleArray.update(1, 2);
        assertThat(simpleArray.get(1), is(2));
    }

    /**
     * Тест delete.
     */
    @Test
    public void whenDeleteElementFromSimpleArray() {
        SimpleArray simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.delete(3);
        assertThat(simpleArray.get(3), is(5));
        simpleArray.add(6);
        assertThat(simpleArray.get(4), is(6));

    }

}