package ru.job4j.collectionspro.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Node - элемент дерева.
 * @param <E> дженерик.
 */
public class Node<E extends Comparable> {
    /**
     * Потомки - ветви элемента.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Значение элемента.
     */
    private final E value;

    /**
     * Конструктор. Не используем элементы без значений.
     * @param value
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * Добавляем потомков - ветви в ноду.
     * @param child потомок
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Получаем всех потомков.
     * @return ArrayList с потомками.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Сравниваем значения нод.
     * @param that значение другой ноды.
     * @return true если значения равны.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
}