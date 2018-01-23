package ru.job4j.collectionspro.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyTreeTest<E extends Comparable<E>> {

    @Test
    public void when6ElFindLastThen6() {
        MyTree<E> tree = new MyTree<>(new Node(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when15ElFindLastThenFalse() {
        MyTree<E> tree = new MyTree<>(new Node(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        tree.add(15, 14);
        assertThat(
                tree.findBy(15).isPresent(),
                is(false)
        );
        assertThat(
                tree.findBy(14).isPresent(),
                is(false)
        );
    }

    @Test
    public void whenTryAddTow6ElThanFindLastIn5() {
        MyTree<E> tree = new MyTree<>(new Node(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        tree.add(4, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
        assertThat(
                tree.findBy(4).get().leaves().size(),
                is(1)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        MyTree<E> tree = new MyTree<E>(new Node(1));
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
}