package ru.job4j.collectionspro.stackandqueue;

import ru.job4j.collectionspro.linkedlist.MyLinkedList;

/**
 * Класс прототип для классов MyStack, MyQueue на базе MyLinkedList.
 * @param <T>
 */
public abstract class SimpleContainer<T> implements SimpleQueue<T>, SimpleStack<T> {
    /**
     * Хранилище для MyStack, MyQueue.
     */
    MyLinkedList<T> linkedList = new MyLinkedList<>();

    /**
     * Возвращает значение элемента и удаляет его из коллекции. Для каждого свой.
     */
    abstract public T poll();

    /**
     * Добавляем элементы в MyStack, MyQueue.
     * @param value значение элемента.
     */
    @Override
    public void push(T value) {
        linkedList.add(value);
    }
}
