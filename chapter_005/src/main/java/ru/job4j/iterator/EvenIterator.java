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
     * Метод возвращающий true если есть следующий четный элемент в массиве.
     * false если достигнут конец или такого эл-та нет.
     * @return true, false.
     */
    @Override
    public boolean hasNext() {

        int indexHasNext = index;
        boolean nextEven = false;

        while (indexHasNext < array.length) {
            if (array[indexHasNext] % 2 == 0) {
                nextEven = true;
                break;
            } else {
                indexHasNext++;
            }
        }
        return nextEven;
    }

    /**
     * Метод next проверяет текущий элемент если он четный то возвращает его и переходит к следующему.
     * если не четный, то проверяет на четность следующий итд.
     * Когда кончились эл-ты генерируется исключение NoSuchElementException.
     * @return четный элемент массива.
     */
    @Override
    public Object next() {

// рабочий код с помощью рекурсии.
//        if (index == array.length) {
//            throw new NoSuchElementException();
//        }
//        if (array[index] % 2 != 0) {
//            index++;
//            return next();
//        } else {
//            return array[index++];
//        }
//---------------------------------------

        while (index < array.length) {
            if (array[index] % 2 != 0) {
                index++;
            } else {
                return array[index++];
            }
        }
        throw new NoSuchElementException();
    }
}
