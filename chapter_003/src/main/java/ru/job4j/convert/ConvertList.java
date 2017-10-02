package ru.job4j.convert;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс конвертации из двумерного массива в лист и обратно.
 * @since 28.09.17
 */
public class ConvertList {
    /**
     * Из массива в лист.
     * @param array массив двумерный
     * @return arraylist.
     */
    public List<Integer> toList(int[][] array) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * Из листа в двумерный массив.
     * @param list arraylist
     * @param rows количество строк в массиве.
     * @return двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {

        int columns;

        if (list.size() % rows == 0) {
            columns = list.size() / rows;
        } else {
            columns = list.size() / rows + 1;
        }

        int[][] array = new int[rows][columns];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (count < list.size()) {
                    if (list.get(count) != null) {
                        array[i][j] = list.get(count);
                        count++;
                    } else {
                        throw new NullPointerException("Null in list");
                    }
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
