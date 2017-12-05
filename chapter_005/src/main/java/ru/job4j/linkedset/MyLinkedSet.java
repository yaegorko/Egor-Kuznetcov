package ru.job4j.linkedset;

import ru.job4j.linkedlist.MyNode;
import ru.job4j.set.SimpleSet;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс реализующий LinkedSet.
 * @param <T> объекты из дженерика.
 */
public class MyLinkedSet<T> implements SimpleSet<T> {

    private MyNode<T> startNode = new MyNode(null, null, null);
    private MyNode<T> lastNode = new MyNode(null, null, null);
    private MyNode<T> currentNode;

//    MyLinkedSet(){
//        this.startNode.setNextNode(this.lastNode);
//        this.lastNode.setPreviousNode(this.startNode);
//        currentNode = startNode;
//    }

    {
        this.startNode.setNextNode(this.lastNode);
        this.lastNode.setPreviousNode(this.startNode);
        currentNode = startNode;
    }

    @Override
    public void add(T t) {
        if (hasDuplicate(t)) {
            return;
        }
        MyNode<T> addNode = this.lastNode;
        addNode.setValue(t);
        this.lastNode = new MyNode(null, addNode, null);
        addNode.setNextNode(lastNode);
    }

    private boolean hasDuplicate(T t) {
        MyNode testNode = this.startNode;
        while (testNode.getNextNode() != null) {
            if (t.equals(testNode.getValue())) {
                return true;
            }
            testNode = testNode.getNextNode();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new  MyLinkedSetIterator();
    }

    private class MyLinkedSetIterator<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            if (currentNode.getNextNode().getNextNode() != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                currentNode = currentNode.getNextNode();
                return (T) currentNode.getValue();
            }
            throw new NoSuchElementException();
        }
    }
}
