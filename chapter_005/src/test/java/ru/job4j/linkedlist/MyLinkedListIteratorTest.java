package ru.job4j.linkedlist;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListIteratorTest {


    @Test
    public void test1() {
        MyLinkedList list = new MyLinkedList();
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
    }
}