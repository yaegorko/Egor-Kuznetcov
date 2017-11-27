package ru.job4j.stackandqueue;

import ru.job4j.linkedlist.MyNode;

/**
 * Класс Очередь. FIFO.
 * @param <T> объекты из дженерика
 */
public class MyQueue<T> extends SimpleContainer<T> {
    /**
     * Возвращает значение элемента и удаляет его из коллекции.
     * @return значение
     */
    @Override
    public T poll() {
        MyNode myNode = linkedList.getNode(0);
        linkedList.remove(0);
        return (T) myNode.getValue();
    }
}
