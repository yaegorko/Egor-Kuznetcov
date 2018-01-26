package ru.job4j.collectionspro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Класс бинарное дерево.
 * @param <E> дженерик.
 */
public class MyBinarySearchTree<E extends Comparable<E>> implements Iterable<E>  {
    /**
     * Класс Нода - ячейка бинарного дерева.
     * @param <E>
     */
    private class Node<E> {
        /**
         * Хранимое значение.
         */
        private E data;
        /**
         * Ссылка на левюу ветвь значения меньшие или равные хранимому.
         */
        private Node<E> left;
        /**
         * Ссылка на правую ветвь значения  большие хранимого.
         */
        private Node<E> right;

        /**
         * Геттр значения.
         * @return значение.
         */
        public E getData() {
            return data;
        }

        /**
         * Геттр левой ветки.
         * @return левая.
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * Сеттр левой ветки.
         * @param left левая.
         */
        public void setLeft(Node<E> left) {
            this.left = left;
        }

        /**
         * Геттр правой ветки.
         * @return правая
         */
        public Node<E> getRight() {
            return right;
        }

        /**
         * Сеттр правой.
         * @param right правая
         */
        public void setRight(Node<E> right) {
            this.right = right;
        }

        /**
         * Крнструктор. не создаем ноды без значений.
         * @param data
         */
        Node(E data) {
            this.data = data;
        }
    }

    /**
     * Корень - константа.
     */
    private final Node<E> root;
    /**
     * Текущая родительская нода.
     */
    private Node<E> parent;

    /**
     * Конструктор, задаем значение кореня.
     * @param data значение корня
     */
    MyBinarySearchTree(E data) {
        this.root = new Node(data);
        this.parent  = root;
    }

    /**
     * Добавляем данные в дерево.
     * @param data значение.
     * @return true если добавилось.
     */
    public boolean add(E data) {
        if (data.compareTo(parent.getData()) <= 0 && parent.getLeft() != null) {
            parent = parent.getLeft();
            add(data);
        } else if (data.compareTo(parent.getData()) > 0 && parent.getRight() != null) {
            parent = parent.getRight();
            add(data);
        } else if (data.compareTo(parent.getData()) <= 0 && parent.getLeft() == null) {
            parent.setLeft(new Node(data));
        } else if (data.compareTo(parent.getData()) > 0 && parent.getRight() == null) {
            parent.setRight(new Node(data));
        } else {
            return false;
        }
        parent = root;
        return true;
    }

    /**
     * Итератор дерева.
     * @return итератор
     */
    @Override
    public Iterator iterator() {
        return new MyBinarySearchTreeIterator();
    }

    /**
     * Класс итератора дерева.
     */
    private class MyBinarySearchTreeIterator implements Iterator<E> {
        /**
         * Очередь.
         */
        Queue<Node<E>> dataQueue = new LinkedList<>();

        /**
         * Конструктор, устанавливаем первый элемент в очереди - корень дерева.
         */
        public MyBinarySearchTreeIterator() {
            dataQueue.offer(root);
        }

        /**
         * Имеем ли следующий элемент в дереве.
         * @return true если элемент есть.
         */
        @Override
        public boolean hasNext() {
            if (dataQueue.peek() != null) {
                return true;
            }
            return false;
        }

        /**
         * Получаем следующий элемент.
         * @return следующая нода.
         */
        @Override
        public E next() {
            if (hasNext()) {
                if (dataQueue.peek().getLeft() != null) {
                    dataQueue.offer(dataQueue.peek().getLeft());
                }
                if (dataQueue.peek().getRight() != null) {
                    dataQueue.offer(dataQueue.peek().getRight());
                }
                return dataQueue.poll().getData();
            }
            throw new NoSuchElementException();
        }
    }
}
