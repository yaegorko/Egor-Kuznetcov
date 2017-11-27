package ru.job4j.stackandqueue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void whenPushElementsToQueueThanCheck() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push("2");
        queue.push('3');
        assertThat(queue.linkedList.get(0), is(1));
        assertThat(queue.linkedList.get(1), is("2"));
        assertThat(queue.linkedList.get(2), is('3'));
    }

    @Test
    public void whenPollElementsFromQueueThanCheck() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push("2");
        queue.push('3');
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is("2"));
        assertThat(queue.poll(), is('3'));
    }

}