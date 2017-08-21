package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты класса Factorial.
 * @author - Egor K.
 * @since - 21.08.17
 */
public class FactorialTest {
    /**
     * Тест метода calc.
     * n = 5;
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factorial = new Factorial();
        int expected = 120;
        assertThat(factorial.calc(5), is(expected));
    }

    /**
     * Тест метода calc.
     * n = 0;
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        int expected = 1;
        assertThat(factorial.calc(0), is(expected));
    }
}
