package ru.job4j.set;

import org.junit.Test;
import ru.job4j.linkedlist.MyNode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MySetTest {

    @Test
    public void testAddDifferentObj() {
        MySet mySet = new MySet();
        mySet.add(1);
        mySet.add(1);
        MyNode myNode = new MyNode(1, null, null);
        MyNode myNode1 = new MyNode(1, null, null);
        mySet.add(myNode);
        mySet.add(myNode1);
        Object[] setTest = mySet.getArrayForSet();
        assertThat(setTest.length, is(10));
        assertThat(setTest[0], is(1));
        assertThat(setTest[1], is(myNode));

    }

}