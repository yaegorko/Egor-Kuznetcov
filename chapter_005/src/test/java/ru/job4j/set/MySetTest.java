package ru.job4j.set;

import org.junit.Test;
import ru.job4j.linkedlist.MyNode;
import ru.job4j.list.NoMoreElementsInContainerException;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тесты MySet.
 */
public class MySetTest {
    /**
     * Тест на добавление одинаковых элементов в MySet.
     */
    @Test
    public void testAddToMySetDifferentObj() {
        MySet mySet = new MySet();
        mySet.add(1);
        mySet.add(1);
        mySet.add(1);
        MyNode myNode = new MyNode(1, null, null);
        mySet.add(myNode);
        Object[] setTest = mySet.getArrayForSet();
        assertThat(setTest.length, is(10));
        assertThat(setTest[0], is(1));
        assertThat(setTest[1], is(myNode));
    }

    /**
     * Тест увеличения размера контейнера.
     */
    @Test
    public void testIncreaseSize() {
        MySet mySet = new MySet();
        for (int i = 0; i < 15; i++) {
            mySet.add(i);
        }
        assertThat(mySet.getArrayForSet().length, is(20));
    }

    /**
     * Тест итератора.
     */
    @Test (expected = NoMoreElementsInContainerException.class)
    public void testIteratorMethod() {
        MySet mySet = new MySet();
        mySet.add(1);
        mySet.add("2");
        mySet.add("2");
        mySet.add("3");
        Iterator iterator = mySet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("3"));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

}