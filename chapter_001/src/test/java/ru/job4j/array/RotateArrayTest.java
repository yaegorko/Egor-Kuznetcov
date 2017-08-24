package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса RotateArray.
 * @author - Egor K.
 * @since - 24.08.17
 */
public class RotateArrayTest {
    /**
     * Тест для массива 2*2.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        RotateArray rotateArray = new RotateArray();
        int[][] initial = {{1, 2}, {3, 4}};
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat(rotateArray.rotate(initial), is(expected));
    }

    /**
     * Тест для массива 3*3.
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.
        RotateArray rotateArray = new RotateArray();
        int[][] initial = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(rotateArray.rotate(initial), is(expected));
    }
}