package ru.job4j.collectionspro.set;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тесты для MySetIterator.
 */
public class MySetIteratorTest {

    /**
     * Тест который последовательно вызывает hasNext и next .
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        MySetIterator mySetIterator = new MySetIterator(new Object[]{1, "2", '3'});
        assertThat(mySetIterator.hasNext(), is(true));
        assertThat(mySetIterator.next(), is(1));
        assertThat(mySetIterator.hasNext(), is(true));
        assertThat(mySetIterator.next(), is("2"));
        assertThat(mySetIterator.hasNext(), is(true));
        assertThat(mySetIterator.next(), is('3'));
        assertThat(mySetIterator.hasNext(), is(false));
        mySetIterator.next();
    }
    
    /**
     * Тест, что последовательный вызов hasNext не влияет на порядок возврата результата.
     */
    @Test
    public void checkThatHasNextDoesNotAffect() {
        MySetIterator mySetIterator = new MySetIterator(new Object[]{1, "2", '3'});
        assertThat(mySetIterator.hasNext(), is(true));
        assertThat(mySetIterator.hasNext(), is(true));
        assertThat(mySetIterator.next(), is(1));
        assertThat(mySetIterator.next(), is("2"));
        assertThat(mySetIterator.next(), is('3'));
        assertThat(mySetIterator.hasNext(), is(false));
    }

}