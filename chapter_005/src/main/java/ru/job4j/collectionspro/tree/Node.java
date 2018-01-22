package ru.job4j.collectionspro.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version $Id$
 * @since 0.1
 */
public class Node<E> implements Comparable {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.equals(that);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}