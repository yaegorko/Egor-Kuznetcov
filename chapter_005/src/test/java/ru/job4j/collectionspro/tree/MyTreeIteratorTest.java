package ru.job4j.collectionspro.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов итератора MyTree.
 * @param <E> дженерик.
 */
public class MyTreeIteratorTest<E extends Comparable<E>> {

    MyTree<E> tree = new MyTree<>(new Node(1));
    {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(3, 6);
        tree.add(3, 7);
        tree.add(2, 8);
    }

    /**
     * Тест который последовательно вызывает hasNext и next .
     */
    @Test (expected = NoSuchElementException.class)
    public void shouldReturnElementsFromMyTreeSequentially() {
        Iterator it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        Node test = (Node) it.next();
        assertThat(test.eqValue(1), is(true));
        test = (Node) it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(test.eqValue(2), is(true));
        test = (Node) it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(test.eqValue(3), is(true));
        test = (Node) it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(test.eqValue(4), is(true));
        test = (Node) it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(test.eqValue(5), is(true));
        test = (Node) it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(test.eqValue(8), is(true));
        test = (Node) it.next();
        assertThat(it.hasNext(), is(true));
        assertThat(test.eqValue(6), is(true));
        test = (Node) it.next();
        assertThat(it.hasNext(), is(false));
        assertThat(test.eqValue(7), is(true));
        it.next();
    }
}