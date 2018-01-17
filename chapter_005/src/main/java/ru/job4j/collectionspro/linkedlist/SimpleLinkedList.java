package ru.job4j.collectionspro.linkedlist;

public interface SimpleLinkedList<E> extends Iterable<E> {

    void add(E e);

    E get(int index);
}
