package ru.job4j.linkedlist;

import ru.job4j.list.NoMoreElementsInContainerException;

import java.util.Iterator;

public class MyLinkedListIterator<E> implements Iterator<E> {

    MyLinkedList list;
    MyNode node;

    public MyLinkedListIterator(MyLinkedList list) {
        this.list = list;
        this.node = this.list.getStartNode();
    }

    @Override
    public boolean hasNext() {
        if (node.getNextNode().getNextNode() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E next() {
        if (hasNext()) {
            node = node.getNextNode();
            return (E) node.getValue();
        }
        throw new NoMoreElementsInContainerException();
    }
}
