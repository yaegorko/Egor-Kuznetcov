package ru.job4j.collectionspro.hashset;

import org.junit.Test;
import ru.job4j.collectionspro.hashset.MyHashSet;

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

    /**
     * Проверяем увеличение размера массива при переполнении.
     */
    @Test
    public void whenAddElementsInHashSetThanIncreaseLength() {
        myHashSet.add(0);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(5);
        myHashSet.add(6);
        myHashSet.add(7);
        myHashSet.add(8);
        myHashSet.add(9);
        Object[] expect = myHashSet.getArrayForHashSet();
        assertThat(expect.length, is(16));
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
        assertThat(expect["YYY".hashCode() & (expect.length - 1)], is("YYY"));
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
     * Тест на добавление 2х одинаковых элементов.
     */
    @Test
    public void whenTryAddTwoEqualsElementsInHashSet() {
        myHashSet.add(2);
        myHashSet.add("YYY");
        assertThat(myHashSet.contains(2), is(true));
        assertThat(myHashSet.contains("YYY"), is(true));
        assertThat(myHashSet.add(2), is(false));
        assertThat(myHashSet.add("YYY"), is(false));
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
