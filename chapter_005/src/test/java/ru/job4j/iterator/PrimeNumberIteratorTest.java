package ru.job4j.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса PrimeNumberIterator.
 */
public class PrimeNumberIteratorTest {
    /**
     * Тест последовательный вызов hasNext и next.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldReturnPrimeNumbersOnly() {
        PrimeNumberIterator it = new PrimeNumberIterator(new int[]{1, 2, 3, 4, 5, 6, 7, 3571});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3571));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест, что последовательный вызов hasNext не влияет на порядок возврата результата.
     */
    @Test
    public void checkThatHasNextDoesntAffect() {
        PrimeNumberIterator it = new PrimeNumberIterator(new int[]{2, 3, 4, 5, 6, 7, 12, 3571});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(3571));
    }

    /**
     * В массиве нет простых чисел.
     */
    @Test(expected = NoSuchElementException.class)
    public void arrayDontHavePrimeNumber() {
        PrimeNumberIterator it = new PrimeNumberIterator(new int[]{4, 6, 8, 10, 15, 1000});
        it.next();
    }

    /**
     * В массиве есть последовательность чисел меньше 1.
     */
    @Test(expected = NoSuchElementException.class)
    public void arrayHaveManyNegativeNumbers() {
        PrimeNumberIterator it = new PrimeNumberIterator(new int[]{-1, -3, 0, 1});
        it.next();
    }

    /**
     * В массиве есть последовательность чисел меньше 1 и простые числа.
     */
    @Test
    public void arrayHaveManyNegativeNumbersAndPrimeNumbers() {
        PrimeNumberIterator it = new PrimeNumberIterator(new int[]{-1, -3, 0, 1, 7, 2, 4, 3, 11});
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(11));
    }

}