package ru.job4j.hashset;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Класс тестов MyHashSet
 */
public class MyHashSetTest {
    /**
     * Хэш множество.
     */
    MyHashSet myHashSet = new MyHashSet();


    @Test
    public void whenAddElementsInHashSetThanCheck1() {
        myHashSet.add(2);
        myHashSet.add("YYY");
        myHashSet.add("YYYzzzzYYY");
        myHashSet.add("YYYss");
    }

    /**
     * Тест add.
     */
    @Test
    public void whenAddElementsInHashSetThanCheck() {
        myHashSet.add(2);
        myHashSet.add("YYY");
        Object[] expect = myHashSet.getArrayForHashSet();
        assertThat(expect[2], is(2));
        assertThat(expect["YYY".hashCode()], is("YYY"));
    }

    /**
     * Тест contains. Хэшсет содержит элементы.
     */
    @Test
    public void whenHashSetContainsAddedElements() {
        myHashSet.add(2);
        myHashSet.add("YYY");
        assertThat(myHashSet.contains(2), is(true));
        assertThat(myHashSet.contains("YYY"), is(true));
    }

    /**
     * Тест contains. Хэшсет не содержит элементы.
     */
    @Test
    public void whenHashSetDosNotContainsAddedElements() {
        myHashSet.add(2);
        myHashSet.add("YYY");
        assertThat(myHashSet.contains(2), is(true));
        assertThat(myHashSet.contains("YYY"), is(true));
        assertThat(myHashSet.contains("ZZZZZZZ"), is(false));
        assertThat(myHashSet.contains(1), is(false));
    }

    /**
     * Тест remove.
     */
    @Test
    public void whenRemoveElementsFromHashSet() {
        myHashSet.add(2);
        myHashSet.add("YYY");
        assertThat(myHashSet.contains(2), is(true));
        assertThat(myHashSet.contains("YYY"), is(true));
        assertThat(myHashSet.remove(2), is(true));
        assertThat(myHashSet.remove("YYY"), is(true));
        assertThat(myHashSet.contains(2), is(false));
        assertThat(myHashSet.contains("YYY"), is(false));
        assertThat(myHashSet.remove(2), is(false));
        assertThat(myHashSet.remove("YYY"), is(false));
    }
}