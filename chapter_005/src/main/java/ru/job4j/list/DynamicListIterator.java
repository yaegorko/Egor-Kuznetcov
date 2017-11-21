package ru.job4j.list;

import java.util.Iterator;

/**
 * Итератор для DynamicList.
 * @param <E> объекты из дженерика.
 */
public class DynamicListIterator<E> implements Iterator<E> {
    /**
     *  Массив для итерирования - копия массива из контейнера.
     */
    Object[] dynamicList;

    /**
     * Конструктор, требует массив из контейнера.
     * @param dynamicList Массив для итерирования.
     */
    public DynamicListIterator(Object[] dynamicList) {
        this.dynamicList = dynamicList;
    }

    /**
     * Стартовая позиция в массиве.
     */
    private int index = 0;

    /**
     * Метод возвращающий true если есть следующий элемент в массиве и он не null.
     * @return true если есть следующий элемент и false если его нет.
     */
    @Override
    public boolean hasNext() {

        int indexHasNext = index;
        boolean nextObject = false;

        while (indexHasNext < this.dynamicList.length) {
            if (dynamicList[indexHasNext] != null) {
                nextObject = true;
                break;
            } else {
                indexHasNext++;
            }
        }
        return nextObject;
    }

    /**
     * /**
     * Метод next возвращает текущий элемент и переходит к следующему.
     * если такого нет, то генерируется исключение NoMoreElementsInContainerException.
     * @return элемент массива.
     */
    @Override
    public E next() {
        if (hasNext()) {
            return (E) dynamicList[index++];
        } else {
            throw new NoMoreElementsInContainerException();
        }
    }
}