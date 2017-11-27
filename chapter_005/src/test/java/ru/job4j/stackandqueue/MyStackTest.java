package ru.job4j.stackandqueue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyStackTest {

    @Test
    public void whenPushElementsToStackThanCheck() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push("2");
        myStack.push('3');
        assertThat(myStack.linkedList.get(0), is(1));
        assertThat(myStack.linkedList.get(1), is("2"));
        assertThat(myStack.linkedList.get(2), is('3'));
    }

    @Test
    public void whenPollElementsFromStackThanCheck() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push("2");
        myStack.push('3');
        assertThat(myStack.poll(), is('3'));
        assertThat(myStack.poll(), is("2"));
        assertThat(myStack.poll(), is(1));
    }

}