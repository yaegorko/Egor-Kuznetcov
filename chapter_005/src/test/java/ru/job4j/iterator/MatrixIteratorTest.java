package ru.job4j.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса MatrixIterator.
 */
public class MatrixIteratorTest {
    /**
     * Тест который последовательно вызывает hasNext и next .
     */
    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocationFromMatrix() {
        MatrixIterator mit = new MatrixIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        Iterator<Integer> it = mit;
        assertThat(mit.hasNext(), is(true));
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
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    /**
     * Тест последовательного вызова только next, без hasNext.
     */
    @Test(expected = NoSuchElementException.class)
    public void onlyNextSequentialInvocationFromMatrix() {
        MatrixIterator mit = new MatrixIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        Iterator<Integer> it = mit;

        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        it.next();
    }

    /**
     * Тест, что последовательный вызов hasNext без вызова next не влияет на возврат значений.
     */
    @Test(expected = NoSuchElementException.class)
    public void sequentialHasNextInvocationDoesntAffect() {
        MatrixIterator mit = new MatrixIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        Iterator<Integer> it = mit;

        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        it.next();
    }

    /**
     * Тест jagged array.
     */
    @Test(expected = NoSuchElementException.class)
    public void jaggedArrayIterator() {
        MatrixIterator it = new MatrixIterator(new int[][]{{1}, {3, 4}});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

}