package ru.job4j.linkedlist;

import ru.job4j.list.NoMoreElementsInContainerException;

import java.util.Iterator;

/**
 * Класс итератора для  класса MyLinkedList.
 * @param <E> объекты из дженерика.
 */
public class MyLinkedListIterator<E> implements Iterator<E> {
    /**
     * Объект связный список для итерирования.
     */
    MyLinkedList list;
    /**
     * Стартовая нода.
     */
    MyNode node;

    /**
     * Конструктор.
     * @param list связный список для итерирования
     */
    public MyLinkedListIterator(MyLinkedList list) {
        this.list = list;
        this.node = this.list.getStartNode();
    }
    /**
     * Метод возвращающий true если есть ссылка на следующий элемент в списке.
     * @return true если есть следующий элемент и false если его нет.
     */
    @Override
    public boolean hasNext() {
        return node.getNextNode().getNextNode() != null;
    }

    /**
     * Метод next возвращает текущий элемент и переходит к следующему.
     * если такого нет, то генерируется исключение NoMoreElementsInContainerException.
     * @return элемент списка.
     */
    @Override
    public E next() {
        if (hasNext()) {
            node = node.getNextNode();
            return (E) node.getValue();
        }
        throw new NoMoreElementsInContainerException();
    }
}