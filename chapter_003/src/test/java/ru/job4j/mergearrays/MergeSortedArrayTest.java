package ru.job4j.mergearrays;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов слияния сортированных массивов.
 */
public class MergeSortedArrayTest {
    /**
     * Тест слияния четного и нечетного массива.
     */
    @Test
    public void whenWeHaveEvenAndOddSortedArraysThanMerge() {
        int[] even = new int[]{1, 3, 5, 7, 9};
        int[] odd = new int[]{2, 4, 6, 8, 10};

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        int[] expected = mergeSortedArray.merge(even, odd);

        assertThat(expected.length, is(10));
        assertThat(expected[0], is(1));
        assertThat(expected[9], is(10));

    }

    /**
     * Тест слияния массивов где все элементы одного больше элементов другого.
     */
    @Test
    public void test2() {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{6, 7, 8, 9, 10};

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        int[] expected = mergeSortedArray.merge(first, second);

        assertThat(expected.length, is(10));
        assertThat(expected[0], is(1));
        assertThat(expected[9], is(10));
    }

    /**
     * Тест слияния массивов с повторяющимися элементами.
     */
    @Test
    public void test3() {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{1, 2, 8, 9, 10};

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        int[] expected = mergeSortedArray.merge(first, second);

        assertThat(expected.length, is(10));
        assertThat(expected[0], is(1));
        assertThat(expected[9], is(10));
    }

    /**
     * Тест слияния массивов разной длинны с повторяющимися элементами.
     */
    @Test
    public void test4() {
        int[] first = new int[]{1, 2, 3, 4, 11, 12, 14};
        int[] second = new int[]{0, 2, 8, 9, 10};

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        int[] expected = mergeSortedArray.merge(first, second);

        assertThat(expected.length, is(12));
        assertThat(expected[0], is(0));
        assertThat(expected[11], is(14));
    }
}
