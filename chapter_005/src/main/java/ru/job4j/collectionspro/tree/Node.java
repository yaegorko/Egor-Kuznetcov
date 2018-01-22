package ru.job4j.collectionspro.tree;

import java.util.ArrayList;
import java.util.List;

public class Node<E extends Comparable> implements Comparable {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public E getValue() {
        return value;
    }

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
        return this.compareTo(that) == 0;
    }

    @Override
    public int compareTo(Object o) {
        Node forCompare = (Node) o;
        return this.value.compareTo(forCompare.getValue());
    }
}