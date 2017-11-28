package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса Paint.
 * @author - Egor K.
 * @since - 22.08.17
 */
public class PaintTest {

    final String line = System.getProperty("line.separator");

    /**
     * Тест метода piramid.
     * высота пирамиды 2 этажа.
     */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^", line);
        assertThat(result, is(expected));
    }

    /**
     * Тест метода piramid.
     * высота пирамиды 3 этажа.
     */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        //напишите здесь тест, проверяющий формирование пирамиды для высоты 3.
        Paint paint = new Paint();
        String result = paint.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^", line, line);
        assertThat(result, is(expected));
    }
}
