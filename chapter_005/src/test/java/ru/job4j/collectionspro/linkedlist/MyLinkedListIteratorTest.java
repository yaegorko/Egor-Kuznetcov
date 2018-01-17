package ru.job4j.collectionspro.linkedlist;

import org.junit.Test;
import ru.job4j.collectionspro.linkedlist.MyLinkedList;
import ru.job4j.collectionspro.linkedlist.MyLinkedListIterator;
import ru.job4j.collectionspro.list.NoMoreElementsInContainerException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListIteratorTest {

    MyLinkedList list = new MyLinkedList();

    @Test (expected = NoMoreElementsInContainerException.class)
    public void shouldReturnEvenNumbersSequentially() {
        list.add(1);
        list.add("2");
        list.add('3');
        MyLinkedListIterator iterator = new MyLinkedListIterator(list);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is('3'));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test
    public void checkThatHasNextDoesNotAffect() {
        list.add(1);
        list.add("2");
        list.add('3');
        MyLinkedListIterator iterator = new MyLinkedListIterator(list);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.next(), is('3'));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void checkThatHasNextDoesNotAffect2() {
        list.add(1);
        MyLinkedListIterator iterator = new MyLinkedListIterator(list);
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }
}