package ru.job4j.collectionspro.stackandqueue;

/**
 * Интерфейс для MyQueue.
 * @param <T> объекты из дженерика.
 */
public interface SimpleQueue<T> {

    T poll();

    void push(T value);
}
