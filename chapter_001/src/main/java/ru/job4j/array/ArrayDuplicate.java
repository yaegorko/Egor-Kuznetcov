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
            int unique = array.length;
            for (int i = 0; i < unique; i++) {
                for (int j = i + 1; j < unique; j++) {
                    if (array[i].equals(array[j])) {
                        array[j] = array[unique - 1];
                        unique--;
                        j--;
                    }
                }
            }

        return Arrays.copyOf(array, unique);
    }
}
