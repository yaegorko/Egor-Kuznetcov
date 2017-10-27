package ru.job4j.list;

import java.util.Iterator;

public class DinamicList<E> implements SimpleContainer<E> {

    private static final int DEFAULT_CAPACITY = 10;

    Object[] container;

    public DinamicList() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    public DinamicList(int INITIAL_CAPACITY) {
        this.container = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(E e) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
