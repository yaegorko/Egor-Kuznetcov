package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс Итератор простых чисел.
 */
public class PrimeNumberIterator implements Iterator {
    /**
     * Массив.
     */
    private int[] array;
    /**
     * индекс массива.
     */
    private int index = 0;

    /**
     * Конструктор.
     * @param array массив.
     */
    public PrimeNumberIterator(int[] array) {
        this.array = array;
    }

    /**
     * Чекаем простое число или нет.
     * @param number число - эл-т массива array.
     * @return true если простое.
     */
    private boolean checkPrime(int number) {

        boolean prime = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                prime = false;
                this.index++;
                break;
            }
        }
        return prime;
    }

    /**
     *
     * Метод возвращающий true если есть следующий элемент в массиве.
     * false если достигнут конец
     * @return true, false
     * @return
     */
    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    /**
     * Метод next проверяет текущий элемент, если он простое число, то возвращает его
     * и переходит к следующему. Если такого нет, то генерируется исключение NoSuchElementException.
     * @return простое число.
     */
    @Override
    public Object next() {

        while (index < array.length) {

            if (array[index] <= 1) {
                index++;
            } else if (checkPrime(array[index])) {
                return array[index++];
            }
        }
        throw new NoSuchElementException();
    }
}
