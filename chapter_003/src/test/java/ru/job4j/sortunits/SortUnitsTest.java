package ru.job4j.sortunits;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов класса сортировки подразделений.
 */
public class SortUnitsTest {
    /**
     * Объект класса.
     */
    private SortUnits sortUnits = new SortUnits();
    /**
     * Несортированный массив без некоторых явно указанных подразделений.
     */
    private String[] units = new String[]{
                                            "K1\\SK1",
                                            "K1\\SK2",
                                            "K1\\SK1\\SSK1",
                                            "K1\\SK1\\SSK2",
                                            "K2",
                                            "K2\\SK1\\SSK1",
                                            "K2\\SK1\\SSK2"};

    /**
     * Тест сортировки по возрастанию.
     */
    @Test
    public void whenSortAscending() {
        String[] expected = new String[]{
                                            "K1",
                                            "K1\\SK1",
                                            "K1\\SK1\\SSK1",
                                            "K1\\SK1\\SSK2",
                                            "K1\\SK2",
                                            "K2",
                                            "K2\\SK1",
                                            "K2\\SK1\\SSK1",
                                            "K2\\SK1\\SSK2"};
        String[] result = sortUnits.sortAscending(units);
        assertThat(expected, is(result));
    }

    /**
     * Тест сортировки по убыванию.
     */
    @Test
    public void whenSortDescendingly() {
        String[] expected = new String[]{
                                            "K2",
                                            "K2\\SK1",
                                            "K2\\SK1\\SSK2",
                                            "K2\\SK1\\SSK1",
                                            "K1",
                                            "K1\\SK2",
                                            "K1\\SK1",
                                            "K1\\SK1\\SSK2",
                                            "K1\\SK1\\SSK1"};
        String[] result = sortUnits.sortDescendingly(units);
        assertThat(expected, is(result));
    }
}
