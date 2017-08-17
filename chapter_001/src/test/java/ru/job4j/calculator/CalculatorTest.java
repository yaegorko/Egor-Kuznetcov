package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты методов класса Calculator .
 *
 * @author - Egor K.
 * @since - 17.08.17
 * @version $Id$
 *
 */

public class CalculatorTest {

    /**
     * Тест сложения.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест вычитания.
     */

    @Test
    public void whenAddOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.minus(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }

    /**
     * Тест умножения.
     */
    @Test
    public void whenAddOneMultiplicationOneThenOne() {
        Calculator calc = new Calculator();
        calc.multiplicate(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Тест деления.
     */
    @Test
    public void whenAddTwoDivisionTwoThenOne() {
        Calculator calc = new Calculator();
        calc.division(2D, 2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

}
