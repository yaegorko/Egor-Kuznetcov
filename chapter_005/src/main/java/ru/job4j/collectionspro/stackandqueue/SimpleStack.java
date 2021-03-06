package ru.job4j.collectionspro.stackandqueue;
/**
 * Интерфейс для MyStack.
 * @param <T> объекты из дженерика.
 */
public interface SimpleStack<T> {

    T poll();

    void push(T value);
}

