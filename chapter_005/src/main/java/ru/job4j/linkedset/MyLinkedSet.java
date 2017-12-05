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

//    1
//    MyLinkedSet(){
//        this.startNode.setNextNode(this.lastNode);
//        this.lastNode.setPreviousNode(this.startNode);
//        currentNode = startNode;
//    }
//
//    2
    {
        this.startNode.setNextNode(this.lastNode);
        this.lastNode.setPreviousNode(this.startNode);
        currentNode = startNode;
    }

    /**
     * Добавляем элемент в список.
     * @param t объект из дженерика.
     */
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

    /**
     * Пролверяем уникальность объекта в множестве.
     * Требует переопределениия equals.
     * @param t объект из дженерика.
     * @return true если объект уже есть в множестве.
     */
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

    /**
     * Итератор.
     * @return итератор множества.
     */
    @Override
    public Iterator<T> iterator() {
        return new  MyLinkedSetIterator();
    }

    /**
     * Класс итератора.
     * @param <T> объект из дженерика.
     */
    private class MyLinkedSetIterator<T> implements Iterator<T> {
        /**
         * Проверяем есть ли следующий элемент.
         * @return true если есть.
         */
        @Override
        public boolean hasNext() {
            if (currentNode.getNextNode().getNextNode() != null) {
                return true;
            }
            return false;
        }

        /**
         * Получаем значение следующего элемента.
         * @return значение следующего элемента
         */
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
