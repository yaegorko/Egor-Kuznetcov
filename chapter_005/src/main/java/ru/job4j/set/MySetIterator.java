package ru.job4j.set;

import ru.job4j.list.NoMoreElementsInContainerException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор для MySetIterator.
 * @param <T> объекты из дженерика.
 */
public class MySetIterator<T> implements Iterator<T> {
    /**
     *  Массив для итерирования - копия массива из контейнера.
     */
    Object[] arrayForSet;
    /**
     * Стартовая позиция в массиве.
     */
    int index;

    /**
     * Конструктор, требует массив из контейнера.
     * @param arrayForSet Массив для итерирования.
     */
    public MySetIterator(Object[] arrayForSet) {
        this.arrayForSet = arrayForSet;
    }
    /**
     * Метод возвращающий true если есть следующий элемент в массиве и он не null.
     * @return true если есть следующий элемент и false если его нет.
     */
    @Override
    public boolean hasNext() {

        int indexHasNext = index;
        boolean nextObject = false;

        while (indexHasNext < this.arrayForSet.length) {
            if (arrayForSet[indexHasNext] != null) {
                nextObject = true;
                break;
            } else {
                indexHasNext++;
            }
        }
        return nextObject;
    }
    /**
     * Метод next возвращает текущий элемент и переходит к следующему.
     * если такого нет, то генерируется исключение NoMoreElementsInContainerException.
     * @return элемент массива.
     */
    @Override
    public T next() {
        if (hasNext()) {
            return (T) arrayForSet[index++];
        } else {
            throw new NoSuchElementException();
        }
    }
}
