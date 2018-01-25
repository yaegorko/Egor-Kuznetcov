package ru.job4j.collectionspro.tree;

import java.util.*;

/**
 * Класс реализующий базовую структуру дерево.
 * @param <E>
 */
public class MyTree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Корень, начало дерева.
     */
    private final Node root;

    /**
     * Конструктор.
     * @param value значение корня.
     */
    public MyTree(E value) {
        this.root = new Node(value);
    }

    /**
     * Добавляем в дерево элемент. В дереве не может быть двух одинаковых эл-тов.
     * @param parent parent родительский элемент.
     * @param child child дочерний элемент.
     * @return true если элемент добавлен.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> optionalNodeParent = findBy(parent);
        Optional<Node<E>> optionalNodeChild = findBy(child);

        if (optionalNodeParent.isPresent() && !optionalNodeChild.isPresent()) {
            optionalNodeParent.get().add(new Node(child));
            return true;
        }
        return false;
    }

    /**
     * Поиск по значению в дереве.
     * @param value значение.
     * @return Ноду со значением, если такое есть в дереве.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Проверяем бинарное ли дерево.
     * @return true если бинарное.
     */
    public boolean isBinary() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            Optional<Node<E>> node = findBy((E) iterator.next());
            if (node.get().leaves().size() > 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Итератор.
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyTreeIterator();

    }

    /**
     * Класс итератора для MyTree.
     */
    private class MyTreeIterator implements Iterator {
        /**
         * Очередь.
         */
        Queue<Node<E>> data = new LinkedList<>();

        /**
         * Конструктор, устанавливаем первый элемент в очереди - корень дерева.
         */
        public MyTreeIterator() {
            data.offer(root);
        }

        /**
         * Имеем ли следующий элемент в дереве.
         * @return true если элемент есть.
         */
        @Override
        public boolean hasNext() {
            if (data.peek() != null) {
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
                for (Node<E> child : data.peek().leaves()) {
                    data.offer(child);
                }
                return data.poll().getValue();
            }
            throw new NoSuchElementException();
        }
    }
}