package ru.job4j.collectionspro.iterator;

import org.junit.Test;
import ru.job4j.collectionspro.iterator.Converter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса Converter.
 */
public class ConverterTest {
    /**
     * Тест: последовательные вызовы hasNext и next.
     */
    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        Iterator it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator> its = Arrays.asList(it1, it2, it3).iterator();
        Converter converter = new Converter();
        Iterator it = converter.convert(its);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест: поседовательный вызов метода next.
     */
    @Test(expected = NoSuchElementException.class)
    public void nextInvocationsOnly() {
        Iterator it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator> its = Arrays.asList(it1, it2, it3).iterator();
        Converter converter = new Converter();
        Iterator it = converter.convert(its);
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(9));
        it.next();
    }

}