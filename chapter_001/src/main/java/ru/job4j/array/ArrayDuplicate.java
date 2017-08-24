package ru.job4j.array;


import java.util.Arrays;

/**
 * Класс ArrayDuplicate.
 * @author - Egor K.
 * @since - 24.08.17
 */
public class ArrayDuplicate {
    /**
     * Метод remove убирающий повторяющиеся элементы массива.
     * @param array исходный массив строк.
     * @return обработанный массив без повторений.
     */
    public String[] remove(String[] array) {
            String buf;
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i].equals(array[j]) && i != j) {
                       buf = array[array.length - 1 - i];
                       array[array.length - 1 - i] = array[j];
                       array[j] = buf;
                    }
                }
            }

            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length; j++) {
                    if (array[i].equals(array[j]) && i != j) {
                        array[j] = String.valueOf(j);
                        count++;
                    }
                }
            }

        return Arrays.copyOf(array, array.length - count);
    }
}
