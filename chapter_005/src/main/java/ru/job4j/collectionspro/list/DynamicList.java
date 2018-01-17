package ru.job4j.collectionspro.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Динамический список на основе массива.
 * @param <E> дженерик объектов.
 */
public class DynamicList<E> implements SimpleContainer<E> {
    /**
     * Размер массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Массив - основа динамического списка.
     */
    private Object[] container;

    /**
     * Геттр для теста метода адд, в логике не участвует.
     * @return массив основу.
     */
    public Object[] getContainer() {
        return container;
    }

    /**
     * Позиция в массиве.
     */
    private int position = 0;

    /**
     * Конструктор списка, размер по умолчанию.
     */
    public DynamicList() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Метод "добавить элемент".
     * @param e объект из дженерика Е.
     */
    @Override
    public void add(E e) {
        if (checkContainerSize()) {
            this.container[this.position++] = e;
        } else {
            increaseContainerSize();
            this.container[this.position++] = e;
        }
    }

    /**
     * Метод получить элемент по его индексу.
     * @param index
     * @return элемент.
     */
    @Override
    public E get(int index) {
        if (index >= 0 && index < this.position) {
            return (E) this.container[index];
        } else {
            throw new IndexNotInIndexRangeException();
        }
    }

    /**
     * Проверка размера массива при добавлении элемента.
     * @return
     */
    private boolean checkContainerSize() {
        return this.position < this.container.length;
    }

    /**
     * Увеличение размера при окончании свободных ячеек.
     */
    private void increaseContainerSize() {
        this.container = Arrays.copyOf(this.container, this.container.length * 2);
    }

    /**
     * Итератор контейнера.
     * @return итератор.
     */
    @Override
    public Iterator<E> iterator() {
        return new DynamicListIterator<>(this.container);
    }
}


