package ru.job4j.linkedset;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс тестов MyLinkedSet.
 */
public class MyLinkedSetTest {
    /**
     * Множество.
     */
    MyLinkedSet myLinkedSet = new MyLinkedSet();

    /**
     * Добавляем разные элементы и итерируем их.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenAddInLinkedSetAndIteration() {
        this.myLinkedSet.add(1);
        this.myLinkedSet.add("2");
        this.myLinkedSet.add('@');
        Iterator iterator = myLinkedSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is('@'));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    /**
     * Проверяем дубликаты на примитивных типах.
     */
    @Test
    public void whenAddEqualElementsInList() {
        this.myLinkedSet.add(1);
        this.myLinkedSet.add(1);
        this.myLinkedSet.add("2");
        this.myLinkedSet.add("2");
        this.myLinkedSet.add('@');
        this.myLinkedSet.add('@');
        Iterator iterator = myLinkedSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is('@'));
        assertThat(iterator.hasNext(), is(false));
    }

}