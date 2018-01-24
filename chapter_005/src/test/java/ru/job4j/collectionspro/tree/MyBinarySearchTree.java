package ru.job4j.collectionspro.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MyBinarySearchTree<E extends Comparable> {

    private class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public E getData() {
            return data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        Node(E data) {
            this.data = data;
        }
    }

    Node root;

    MyBinarySearchTree(E data) {
        this.root = new Node(data);
    }

    public boolean add(E data) {
        isLeftOrRight(data, root);
        return true;
    }

    private Node isLeftOrRight(E data, Node<E> parent) {

        Node addedNode;
        if (data.compareTo(parent.getData()) <= 0 && parent.getLeft() != null) {
            addedNode = isLeftOrRight(data, parent.getLeft());
        } else if (data.compareTo(parent.getData()) > 0 && parent.getRight() != null) {
            addedNode = isLeftOrRight(data, parent.getRight());
        } else if (data.compareTo(parent.getData()) <= 0 && parent.getLeft() == null) {
            addedNode = new Node(data);
            parent.setLeft(addedNode);
        } else if (data.compareTo(parent.getData()) > 0 && parent.getRight() == null) {
            addedNode = new Node(data);
            parent.setRight(addedNode);
        } else {
            throw new RuntimeException();
        }
        return addedNode;
    }

    public Iterator iterator() {
        return new MyBinarySearchTreeIterator();
    }

    private class MyBinarySearchTreeIterator implements Iterator {
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
        public Node<E> next() {
            if (hasNext()) {
                if (dataQueue.peek().getLeft() != null) {
                    dataQueue.offer(dataQueue.peek().getLeft());
                }
                if (dataQueue.peek().getRight() != null) {
                    dataQueue.offer(dataQueue.peek().getRight());
                }
                return dataQueue.poll();
            }
            throw new NoSuchElementException();
        }
    }
}
