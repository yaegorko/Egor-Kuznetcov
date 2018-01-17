package ru.job4j.collectionspro.hashmap;

import org.junit.Test;
import ru.job4j.collectionspro.hashmap.MyHashMap;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyHashMapIteratorTest {

    MyHashMap myHashMap = new MyHashMap();
    Iterator it = myHashMap.iterator();

    /**
     * Тест который последовательно вызывает hasNext и next .
     */
    @Test (expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");
        myHashMap.insert(3, "Misha");

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Masha"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Dasha"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Misha"));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест, что последовательный вызов hasNext не влияет на порядок возврата результата.
     */
    @Test
    public void checkThatHasNextDoesNotAffect() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");
        myHashMap.insert(3, "Misha");
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Masha"));
        assertThat(it.next(), is("Dasha"));
        assertThat(it.next(), is("Misha"));
        assertThat(it.hasNext(), is(false));
    }
}