package ru.job4j.linkedlist;

public interface SimpleLinkedList<E> extends Iterable<E> {

    void add(E e);

    E get(int index);
}
