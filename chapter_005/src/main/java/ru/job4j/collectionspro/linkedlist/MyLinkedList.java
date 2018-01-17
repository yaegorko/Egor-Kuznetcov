package ru.job4j.collectionspro.linkedlist;

import ru.job4j.collectionspro.list.IndexNotInIndexRangeException;

import java.util.Iterator;

/**
 * Связный двусторонний список.
 * @param <E> объекты из дженерика.
 */
public class MyLinkedList<E> implements SimpleLinkedList<E> {
    /**
     * Стартовая нода.
     */
    private MyNode<E> startNode = new MyNode<>(null, null, null);
    /**
     * Последняя нода.
     */
    private MyNode<E> lastNode = new MyNode<>(null, null, null);
    /**
     * Количество добавленных элементов в списке.
     */
    private int numbersOfElements = 0;

    public int getNumbersOfElements() {
        return numbersOfElements;
    }

    /**
     * Геттр стартовой ноды.
     * @return стартовую ноду.
     */
    public MyNode<E> getStartNode() {
        return this.startNode;
    }

    /**
     * Конструктор.
     * Устанавливаем ссылки двух начальных нод друг на друга.
     */
    public MyLinkedList() {
        this.startNode.setNextNode(this.lastNode);
        this.lastNode.setPreviousNode(this.startNode);
    }

    /**
     * Метод добавляющий элемент в связный список.
     * @param e объекты из дженерика.
     */
    @Override
    public void add(E e) {
        MyNode addNode = this.lastNode;
        addNode.setValue(e);
        this.lastNode = new MyNode<>(null, addNode, null);
        addNode.setNextNode(this.lastNode);
        this.numbersOfElements++;
    }

    /**
     * Метод получающий значение элемента из списка по индексу.
     * @param index индекс элемента.
     * @return значение дженерика.
     */
    @Override
    public E get(int index) {
        return (E) getNode(index).getValue();
    }

    /**
     * Метод получающий ноду по индексу.
     * @param index индекс элемента.
     * @return ноду
     */
    public MyNode getNode(int index) {
        if (index >= 0 && index < this.numbersOfElements) {
            MyNode findNode = startNode;
            for (int i = 0; i <= index; i++) {
                findNode = findNode.getNextNode();
            }
            return findNode;
        }
        throw new IndexNotInIndexRangeException();
    }

    /**
     * Метод удаляющий ноду из списка по индексу.
     * @param index индекс.
     */
    public void remove(int index) {

       MyNode prevNode;
       MyNode nextNode;

       if (index == 0) {
           prevNode = this.startNode;
       } else {
           prevNode = getNode(index - 1);
       }
       if (index == numbersOfElements - 1) {
           nextNode = this.lastNode;
       } else {
           nextNode = getNode(index + 1);
       }

       prevNode.setNextNode(nextNode);
       nextNode.setPreviousNode(prevNode);
       this.numbersOfElements--;
    }

    /**
     * Итератор списка.
     * @return итератор
     */
    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator(this);
    }
}
