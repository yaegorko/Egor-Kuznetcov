package ru.job4j.collectionspro.tree;

import java.util.Iterator;
import java.util.Optional;

public class MyTree implements SimpleTree {

    @Override
    public boolean add(Comparable parent, Comparable child) {
        return false;
    }

    @Override
    public Optional<Node> findBy(Comparable value) {
        return Optional.empty();
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
