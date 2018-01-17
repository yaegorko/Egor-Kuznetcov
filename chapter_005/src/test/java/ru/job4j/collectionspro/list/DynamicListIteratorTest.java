package ru.job4j.collectionspro.list;

import org.junit.Test;
import ru.job4j.collectionspro.list.DynamicListIterator;
import ru.job4j.collectionspro.list.NoMoreElementsInContainerException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса DynamicListIterator.
 */
public class DynamicListIteratorTest {
    /**
     * Тест который последовательно вызывает hasNext и next .
     */
    @Test (expected = NoMoreElementsInContainerException.class)
    public void shouldReturnEvenNumbersSequentially() {
        DynamicListIterator dynamicListIterator = new DynamicListIterator(new Object[]{1, "2", '3'});
        assertThat(dynamicListIterator.hasNext(), is(true));
        assertThat(dynamicListIterator.next(), is(1));
        assertThat(dynamicListIterator.hasNext(), is(true));
        assertThat(dynamicListIterator.next(), is("2"));
        assertThat(dynamicListIterator.hasNext(), is(true));
        assertThat(dynamicListIterator.next(), is('3'));
        assertThat(dynamicListIterator.hasNext(), is(false));
        dynamicListIterator.next();
    }
    /**
     * Тест, что последовательный вызов hasNext не влияет на порядок возврата результата.
     */
    @Test
    public void checkThatHasNextDoesNotAffect() {
        DynamicListIterator it = new DynamicListIterator(new Object[]{1, "2", '3'});
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is("2"));
        assertThat(it.next(), is('3'));
        assertThat(it.hasNext(), is(false));
    }

}