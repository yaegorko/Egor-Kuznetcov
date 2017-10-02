package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса ConvertList.
 * @since 28.09.17
 */
public class ConvertListTest {
    /**
     * Объект класса ConvertList.
     */
    private ConvertList convertList = new ConvertList();

    /**
     * Тест метода toList.
     */
    @Test
    public void whenFromArrayToList() {
        int[][] initial = new int[][]{{1, 2}, {3, 4}, {5, 5}, {0, 6}};
        List<Integer> expected = new ArrayList<>(asList(1, 2, 3, 4, 5, 5, 0, 6));
        assertThat(convertList.toList(initial), is(expected));
    }

    /**
     * Тест метода toArray.
     * Количество э-тов ArrayList кратно количеству эл-тов массива при 3х строках.
     */
    @Test
    public void whenFromListToArrayWithDivisionWithoutRemainder() {
        List<Integer> initial = new ArrayList<>(asList(1, 2, 3, 4, 5, 6));
        int rows = 3;
        int[][] expected = new int[][]{{1, 2},
                                       {3, 4},
                                       {5, 6}};
        assertThat(convertList.toArray(initial, rows), is(expected));
    }
    /**
     * Тест метода toArray.
     * Количество э-тов ArrayList не кратно количеству эл-тов массива при 3х строках.
     * Оставшиеся эл-ты массива = 0.
     */
    @Test
    public void whenFromListToArrayWithDivisionWithRemainder() {
        List<Integer> initial = new ArrayList<>(asList(1, 2, 3, 4, 5, 6, 7));
        int rows = 3;
        int[][] expected =  new int[][]{{1, 2, 3},
                                        {4, 5, 6},
                                        {7, 0, 0}};
        assertThat(convertList.toArray(initial, rows), is(expected));
    }
    /**
     * Тест метода toArray.
     * Количество э-тов ArrayList не кратно количеству эл-тов массива при 4х строках.
     * Оставшиеся эл-ты массива = 0.
     */
    @Test
    public void whenFromListToArrayWithDivisionWithRemainder2() {
        List<Integer> initial = new ArrayList<>(asList(1, 2, 3, 4, 5, 6));
        int rows = 4;
        int[][] expected = new int[][]{{1, 2},
                                       {3, 4},
                                       {5, 6},
                                       {0, 0}};
        assertThat(convertList.toArray(initial, rows), is(expected));
    }
    /**
     * Тест метода toArray.
     * Количество э-тов ArrayList меньше количества строк.
     * Оставшиеся эл-ты массива = 0.
     */
    @Test
    public void whenFromListToArrayWithDivisionWithRemainder3() {
        List<Integer> initial = new ArrayList<>(asList(1, 2, 3, 4, 5, 6));
        int rows = 8;
        int[][] expected = new int[][]{{1},
                                       {2},
                                       {3},
                                       {4},
                                       {5},
                                       {6},
                                       {0},
                                       {0}};
        assertThat(convertList.toArray(initial, rows), is(expected));
    }

    /**
     * Тест метода toArray.
     * В листе есть null.
     */
    @Test
    public void whenFromListToArrayWithNullElements() {
        List<Integer> initial = new ArrayList<>(asList(1, 2, null, 4));
        int rows = 2;
        int[][] expected = new int[][]{{1, 2},
                                       {3, 4}};
        try {
            assertThat(convertList.toArray(initial, rows), is(expected));
        } catch (NullPointerException npe) {
            assertThat(npe.getMessage(), is("Null in list"));
        }


    }
}
