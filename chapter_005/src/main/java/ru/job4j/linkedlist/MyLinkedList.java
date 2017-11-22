package ru.job4j.linkedlist;

import java.util.Iterator;

public class MyLinkedList<E> implements SimpleLinkedList<E> {

    MyNode<E> startNode;
    MyNode<E> lastNode;
    private int numbersOfElements = 0;

    public MyLinkedList() {
        this.startNode = new MyNode<E>(null, null, lastNode);
        this.lastNode = new MyNode<E>(null, startNode, null);
    }

    @Override
    public void add(E e) {
        MyNode<E> addNode = new MyNode<E>(e, this.lastNode.getPreviousNode(), this.lastNode);
        this.lastNode = new MyNode<E>(null, addNode, null);
        this.numbersOfElements++;
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
