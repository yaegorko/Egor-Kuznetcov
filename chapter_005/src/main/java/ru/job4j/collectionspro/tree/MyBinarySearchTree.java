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
    Node parent;

    MyBinarySearchTree(E data) {
        this.root = new Node(data);
        this.parent  = root;
    }

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

    public Iterator iterator() {
        return new MyBinarySearchTreeIterator();
    }

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
