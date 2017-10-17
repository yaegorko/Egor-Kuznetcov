package ru.job4j.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов EvenIterator.
 */
public class EvenIteratorTest {
    /**
     * Тест последовательный вызов hasNext и next.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        EvenIterator it = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест, что последовательный вызов hasNext не влияет на порядок возврата результата.
     */
    @Test public void checkThatHasNextDoesntAffect() {
        EvenIterator it = new EvenIterator(new int[]{1, 2, 4, 6});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    /**
     * В массиве нет четных эл-тов.
     */
    @Test(expected = NoSuchElementException.class)
    public void noOneEvenElementsInArray() {
        EvenIterator it = new EvenIterator(new int[]{1, 3, 5, 7});
        it.next();
    }
}