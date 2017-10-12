package ru.job4j.sortunits;

public class SortUnitsTest {

    String[] units = new String[]{  "K1",
                                    "K2",
                                    "K1\\SK1",
                                    "K1\\SK2",
                                    "K2\\SK1",
                                    "K1\\SK1\\SSK1",
                                    "K1\\SK1\\SSK2",
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

}
