package ru.job4j.collectionspro.tree;

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
}
