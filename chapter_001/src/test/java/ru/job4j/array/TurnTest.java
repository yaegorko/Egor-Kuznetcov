package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты класса Turn, переворот массива.
 * @author - Egor K.
 * @since - 14.08.17
 * @version $Id$
 */

public class TurnTest {
    /**
     * Тест метода back при четном количестве элементов массива.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] expected = {4, 1, 6, 2};
        assertThat(turn.back(new int[]{2, 6, 1, 4}), is(expected));

    }
    /**
     * Тест метода back при нечетном количестве элементов массива.
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(turn.back(new int[]{1, 2, 3, 4, 5}), is(expected));

    }
}