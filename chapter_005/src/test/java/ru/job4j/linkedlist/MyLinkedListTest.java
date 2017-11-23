package ru.job4j.linkedlist;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListTest {

    @Test
    public void whenAddDifferentObjectsInContainerThanGetEmByMethodAndCheck() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add("2");
        list.add('3');
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is("2"));
        assertThat(list.get(2), is('3'));
    }

    @Test
    public void whenAddThreeDifferentObjectsThanCheckAllWithIterator() {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add("2");
        list.add('3');
        Iterator iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is('3'));
        assertThat(iterator.hasNext(), is(false));
    }
}