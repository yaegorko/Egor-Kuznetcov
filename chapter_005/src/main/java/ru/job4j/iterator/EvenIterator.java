package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс итератора четных чисел в массиве.
 */
public class EvenIterator implements Iterator {
    /**
     * Массив.
     */
    private int[] array;
    /**
     * Индекс массива.
     */
    private int index = 0;

    /**
     * Конструктор.
     * @param array массив.
     */
    public EvenIterator(int[] array) {
        this.array = array;
    }

    /**
     * Метод возвращающий true если есть следующий элемент в массиве.
     * false если достигнут конец
     * @return true, false.
     */
    @Override
    public boolean hasNext() {
        return array.length - 1 > index;
    }

    /**
     * Метод next проверяет текущий элемент если он четный то возвращает его и переходит к следующему.
     * если не четный, то проверяет на четность следующий итд.
     * Когда кончились эл-ты генерируется исключение NoSuchElementException.
     * @return четный элемент массива.
     */
    @Override
    public Object next() {

        if (index == array.length) {
            throw new NoSuchElementException();
        }

        if (array[index] % 2 != 0) {
            index++;
            return next();
        } else {
            return array[index++];
        }
    }
}
