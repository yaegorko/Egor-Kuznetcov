package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты для класса Counter.
 */

public class CounterTest {
    /**
     * Тест метода подсчета суммы четных.
     */
    @Test
    public void fromOneToTenSumEvenIsThirty() {
        Counter counter = new Counter();
        int expected  = 30;
        assertThat(counter.add(1, 10), is(expected));
    }

}
