package ru.job4j.array;

/**
 * Класс RotateArray. Поворачиваем матрицу.
 * @author - Egor K.
 * @since - 24.08.17
 */
public class RotateArray {
    /**
     * Метод поворота матрицы.
     * @param array входящий двумерный массив.
     * @return повернутый 90* вправо массив.
     */

    public int[][] rotate(int[][] array) {

        int buf;
        for (int i = 0; i < array.length / 2; i++) {
            for (int j = i; j < array.length - 1 - i; j++) {
                buf = array[i][j];
                array[i][j] = array[array.length - j - 1][i];
                array[array.length - j - 1][i] = array[array.length - i - 1][array.length - j - 1];
                array[array.length - i - 1][array.length - j - 1] = array[j][array.length - i - 1];
                array[j][array.length - i - 1] = buf;
            }
        }
        return array;
    }
}
