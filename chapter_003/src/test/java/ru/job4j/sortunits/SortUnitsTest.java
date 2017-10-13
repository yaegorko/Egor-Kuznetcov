package ru.job4j.sortunits;

import org.junit.Test;

public class SortUnitsTest {

    SortUnits sortUnits = new SortUnits();

    String[] units = new String[]{  "K1\\SK1",
                                    "K1\\SK2",
                                    "K1\\SK1\\SSK1",
                                    "K1\\SK1\\SSK2",
                                    "K2",
                                    "K2\\SK1\\SSK1",
                                    "K2\\SK1\\SSK2"};

    String[] expected = new String[]{ "K1",
                                      "K1\\SK1",
                                      "K1\\SK1\\SSK1",
                                      "K1\\SK1\\SSK2",
                                      "K1\\SK2",
                                      "K2",
                                      "K2\\SK1",
                                      "K2\\SK1\\SSK1",
                                      "K2\\SK1\\SSK2"};

    @Test
    public void test1() {
        sortUnits.parseUnits(units);
    }

}
