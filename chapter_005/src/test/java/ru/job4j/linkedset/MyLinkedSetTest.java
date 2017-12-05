package ru.job4j.linkedset;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyLinkedSetTest {

    MyLinkedSet myLinkedSet = new MyLinkedSet();

    @Test (expected = NoSuchElementException.class)
    public void test1() {
        this.myLinkedSet.add(1);
        this.myLinkedSet.add("2");
        this.myLinkedSet.add('@');
        assertThat(myLinkedSet.iterator().hasNext(), is(true));
        assertThat(myLinkedSet.iterator().next(), is(1));
        assertThat(myLinkedSet.iterator().hasNext(), is(true));
        assertThat(myLinkedSet.iterator().next(), is("2"));
        assertThat(myLinkedSet.iterator().hasNext(), is(true));
        assertThat(myLinkedSet.iterator().next(), is('@'));
        assertThat(myLinkedSet.iterator().hasNext(), is(false));
        myLinkedSet.iterator().next();
    }

}