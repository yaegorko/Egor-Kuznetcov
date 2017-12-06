package ru.job4j.hashset;

import java.util.Arrays;

public class MyHashSet<T> {

    private Object[] arrayForHashSet = new Object[10];

    public Object[] getArrayForHashSet() {
        return arrayForHashSet;
    }

    private int calculateHash(T t) {
        int myHash = t.hashCode();
        return myHash;
    }

    public boolean add(T t) {
        int index = calculateHash(t);
        if (!isInRange(index)) {
            increaseLength(index);
        }
        arrayForHashSet[index] = t;
        return true;
    }

    private boolean isInRange(int index) {
        return index < arrayForHashSet.length;
    }

    private void increaseLength(int newLength) {
        arrayForHashSet = Arrays.copyOf(arrayForHashSet, newLength + 1);
    }

    public boolean contains(T t) {
        int index = calculateHash(t);
        return isInRange(index) && arrayForHashSet[index] != null && arrayForHashSet[index] == t;
    }

    public boolean remove(T t) {
        int index = calculateHash(t);
        if (isInRange(index)) {
            arrayForHashSet[index] = null;
            return true;
        } else {
            return false;
        }
    }


}
