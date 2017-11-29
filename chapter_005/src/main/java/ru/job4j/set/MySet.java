package ru.job4j.set;

import java.util.Iterator;


public class MySet<T> implements SimpleSet<T> {

    private Object[] arrayForSet = new Object[2];

    public Object[] getArrayForSet() {
        return arrayForSet;
    }

    private int numbersOfElements = 0;

    @Override
    public void add(T t) {
        for (int i = 0; i < numbersOfElements ; i++) {
            if (t.equals(arrayForSet[i])) {
                return;
            }
        }
        arrayForSet[numbersOfElements++] = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new MySetIterator();
    }
}
