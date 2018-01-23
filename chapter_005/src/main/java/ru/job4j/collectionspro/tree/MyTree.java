package ru.job4j.collectionspro.tree;

import java.util.*;

public class MyTree<E extends Comparable<E>> implements SimpleTree {

    private final Node root;

    public MyTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean add(Comparable parent, Comparable child) {
        Optional<Node<E>> optionalNodeParent = findBy(parent);
        Optional<Node<E>> optionalNodeChild = findBy(child);

        if (optionalNodeParent.isPresent() && !optionalNodeChild.isPresent()) {
            optionalNodeParent.get().add(new Node(child));
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(Comparable value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue((E) value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyTreeIterator();

    }

    private class MyTreeIterator implements Iterator {

        Queue<Node<E>> data = new LinkedList<>();

        public MyTreeIterator() {
            data.offer(root);
        }

        @Override
        public boolean hasNext() {
            if (data.peek() != null) {
                return true;
            }
            return false;
        }

        @Override
        public Node<E> next() {
            if (hasNext()) {
                for (Node<E> child : data.peek().leaves()) {
                    data.offer(child);
                }
                return data.poll();
            }
            throw new NoSuchElementException();
        }
    }
}
