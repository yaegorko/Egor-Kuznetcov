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
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    buf = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buf;
                }
            }
        }

        return array;
    }
}
