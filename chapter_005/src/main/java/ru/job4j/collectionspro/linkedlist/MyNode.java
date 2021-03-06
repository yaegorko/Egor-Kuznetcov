package ru.job4j.collectionspro.linkedlist;

public class MyNode<E> {

    public E value;

    private MyNode<E> previousNode;

    private MyNode<E> nextNode;

    public E getValue() {
        return value;
    }

    public MyNode<E> getNextNode() {
        return nextNode;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setPreviousNode(MyNode<E> previousNode) {
        this.previousNode = previousNode;
    }

    public void setNextNode(MyNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    public MyNode(E value, MyNode<E> previousNode, MyNode<E> nextNode) {
        this.value = value;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }
}
