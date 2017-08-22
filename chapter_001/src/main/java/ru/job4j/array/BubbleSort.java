package ru.job4j.array;

/**
 * Класс BubbleSort.
 * @author - Egor K.
 * @since - 22.08.17
 */
public class BubbleSort {
    /**
     * Метод sort - сортируем пузырьком.
     * @param array массив для сортировки.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {

        int buf;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    buf = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = buf;
                }
            }
        }

        return array;
    }
}
