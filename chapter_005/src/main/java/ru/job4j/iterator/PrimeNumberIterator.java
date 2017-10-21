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
     * Индекс массива.
     */
    private int index = 0;
    /**
     * Конструктор.
     *
     * @param array массив.
     */
    public PrimeNumberIterator(int[] array) {
        this.array = array;
    }

    /**
     * Чекаем простое число или нет.
     *
     * @param number число - эл-т массива array.
     * @return true если простое.
     */
    private boolean checkPrime(int number) {

        boolean prime = true;

        if (number <= 1) {
            prime = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        return prime;
    }

    /**
     * Метод возвращающий true если есть следующий элемент - простое число в массиве,
     * false если достигнут конец или такого числа нет.
     * @return nextPrime
     */
    @Override
    public boolean hasNext() {

        int indexHasNext = index;
        boolean nextPrime = false;

        while (indexHasNext < array.length) {
            if (checkPrime(array[indexHasNext])) {
                nextPrime = true;
                break;
            } else {
                indexHasNext++;
            }
        }
        return nextPrime;
    }



    /**
     * Метод next проверяет текущий элемент, если он простое число, то возвращает его
     * и переходит к следующему. Если такого нет, то генерируется исключение NoSuchElementException.
     * @return простое число.
     */
    @Override
    public Object next() {

        while (index < array.length) {
           if (checkPrime(array[index])) {
                return array[index++];
           } else {
               index++;
           }
        }
        throw new NoSuchElementException();
    }
}
