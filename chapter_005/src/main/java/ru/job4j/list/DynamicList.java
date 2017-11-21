package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicList<E> implements SimpleContainer<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] container;

    public Object[] getContainer() {
        return container;
    }

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public DynamicList() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    public DynamicList(int initialCapacity) {
        this.container = new Object[initialCapacity];
    }

    @Override
    public void add(E e) {
        if (checkContainerSize()) {
            this.container[this.position++] = e;
        } else {
            increaseContainerSize();
            this.container[this.position++] = e;
        }
    }

    @Override
    public E get(int index) {
        return (E) this.container[index];
    }

    private boolean checkContainerSize() {
        return this.position < this.container.length;
    }

    private void increaseContainerSize() {
        this.container = Arrays.copyOf(this.container, this.container.length * 2);
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicListIterator<E>(){

        };
    }

    private class DynamicListIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            int positionHasNext = getPosition();
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
