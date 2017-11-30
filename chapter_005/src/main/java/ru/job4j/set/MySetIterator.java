package ru.job4j.set;

import ru.job4j.list.NoMoreElementsInContainerException;

import java.util.Iterator;

public class MySetIterator<T> implements Iterator<T> {

    Object[] arrayForSet;
    int index;

    public MySetIterator(Object[] arrayForSet) {
        this.arrayForSet = arrayForSet;
    }

    @Override
    public boolean hasNext() {

        int indexHasNext = index;
        boolean nextObject = false;

        while (indexHasNext < this.arrayForSet.length) {
            if (arrayForSet[indexHasNext] != null) {
                nextObject = true;
                break;
            } else {
                indexHasNext++;
            }
        }
        return nextObject;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return (T) arrayForSet[index++];
        } else {
            throw new NoMoreElementsInContainerException();
        }
    }
}
