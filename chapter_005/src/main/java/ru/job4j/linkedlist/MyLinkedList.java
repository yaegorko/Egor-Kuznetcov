package ru.job4j.linkedlist;

import ru.job4j.list.IndexNotInIndexRangeException;

import java.util.Iterator;

/**
 * Связный двусторонний список.
 * @param <E> объекты из дженерика.
 */
public class MyLinkedList<E> implements SimpleLinkedList<E> {
    /**
     * Стартовая нода.
     */
    private MyNode<E> startNode = new MyNode<E>(null, null, null);
    /**
     * Последняя нода.
     */
    private MyNode<E> lastNode = new MyNode<E>(null, null, null);
    /**
     * Количество добавленных элементов в списке.
     */
    private int numbersOfElements = 0;

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
     * Метод получающий элемент из списка по индексу.
     * @param index индекс элемента.
     * @return значение дженерика.
     */
    @Override
    public E get(int index) {
        if (index >= 0 && index < this.numbersOfElements) {
            MyNode findNode = startNode;
            for (int i = 0; i <= index; i++) {
                findNode = findNode.getNextNode();
            }
            return (E) findNode.getValue();
        }
        throw new IndexNotInIndexRangeException();
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
