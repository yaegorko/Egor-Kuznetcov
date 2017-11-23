package ru.job4j.linkedlist;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListTest {

    @Test
    public void test1(){
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
    }

    @Test
    public void test2() {
        MyLinkedList list = new MyLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        assertThat(list.get(0), is("1"));
        assertThat(list.get(1), is("2"));
        assertThat(list.get(2), is("3"));
    }

}