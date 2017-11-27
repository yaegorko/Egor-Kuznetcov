package ru.job4j.stackandqueue;

import ru.job4j.linkedlist.MyNode;

/**
 * Класс Стэк. LIFO.
 * @param <T> объекты из дженерика
 */
public class MyStack<T> extends SimpleContainer<T>  {
    /**
     * Возвращает значение элемента и удаляет его из коллекции.
     * @return значение
     */
    @Override
    public T poll() {
        MyNode myNode = linkedList.getNode(linkedList.getNumbersOfElements() - 1);
        linkedList.remove(linkedList.getNumbersOfElements() - 1);
        return (T) myNode.getValue();
    }
}
