package ru.job4j.linkedlist;

import java.util.Iterator;

public class MyLinkedList<E> implements SimpleLinkedList<E> {

    MyNode<E> startNode = new MyNode<E>(null, null, null);
    MyNode<E> lastNode = new MyNode<E>(null, null, null);
    private int numbersOfElements = 0;

    public MyLinkedList() {
        this.startNode.setNextNode(this.lastNode);
        this.lastNode.setPreviousNode(this.startNode);
    }

    @Override
    public void add(E e) {
        MyNode addNode = this.lastNode;
        addNode.setValue(e);
        this.lastNode = new MyNode<>(null, addNode, null);
        addNode.setNextNode(this.lastNode);
        this.numbersOfElements++;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < this.numbersOfElements) {

        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
