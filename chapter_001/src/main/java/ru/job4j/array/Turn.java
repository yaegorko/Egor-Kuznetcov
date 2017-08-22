package ru.job4j.array;

/**
 * Класс Turn.
 * @author - Egor K.
 * @since - 22.08.17
 * @version - $Id$
 */
public class Turn {
    /**
     * Метод back переворачивает массив.
     * @param array передаваемый массив.
     * @return полученный перевернутый массив.
     */
    public int[] back(int[] array) {
        int buf; //переменная для временного хранения элементов массива.
        if (array.length % 2 == 0) { // четное число элементов в массиве.
            for (int i = 0; i < array.length / 2; i++) {
                buf = array[array.length - 1 - i];
                array[array.length - 1 - i] = array[i];
                array[i] = buf;
            }
        } else { // нечетное число элементов в массиве.
            for (int i = 0; i < (array.length - 1) / 2; i++) {
                buf = array[array.length - 1 - i];
                array[array.length - 1 - i] = array[i];
                array[i] = buf;
            }
        }
        return array;
    }
}
