package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс итератор для двумерных массивов.
 */
public class MatrixIterator implements Iterator {
    /**
     * Двумерный массив.
     */
    private int[][] matrix;
    /**
     * Индекс X.
     */
    private int indexX = 0;
    /**
     * индекс У.
     */
    private int indexY = 0;

    /**
     * Конструктор.
     * @param matrix массив.
     */
    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Метод возвращающий true если есть следующий элемент в массиве.
     * false если достигнут конец
     * @return true, false.
     */
    public boolean hasNext() {

        return matrix.length + matrix[indexY].length - 1 > indexX + indexY;

    }

    /**
     * Метод next возвращает текущий элемент и переходит к следующему.
     * если такого нет, то генерируется исключение NoSuchElementException.
     * @return элемент массива.
     */
    public Object next() {
        if (indexX == matrix[indexY].length) {
            indexX = 0;
            indexY++;
        }
        if (indexY == matrix.length) {
            throw new NoSuchElementException();
        } else {
            return matrix[indexY][indexX++];
        }
    }
}
