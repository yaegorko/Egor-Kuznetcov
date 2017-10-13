package ru.job4j.sortunits;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Класс сортирующий справочник подразделений.
 */
public class SortUnits {

    /**
     * Парсим список и выносим неявно указанные подразделения в отдельную строку.
     * Побочный эффект подразделения сортируются по возрастанию ( задача 1)
     * @param unsorted несортированный массив без некоторых явно указанных подразделений.
     * @return сортированный по возрастанию массив со всеми подразделениями.
     */
    public String[] sortAscending(String[] unsorted) {

        TreeSet<String> allUnits = new TreeSet<>();

        int startSubstring = 0;
        int endSubstring;

        for (String units : unsorted) {
            for (int i = 0; i < units.length(); i++) {

                endSubstring = units.indexOf("\\", startSubstring);
                if (endSubstring != -1) {
                    String substring = units.substring(0, endSubstring);
                    allUnits.add(substring);
                    startSubstring = endSubstring + 1;
                } else {
                    allUnits.add(units);
                    startSubstring = 0;
                    break;
                }
            }
        }

        String[] sortedAscending  = allUnits.toArray(new String[allUnits.size()]);

        return sortedAscending;
    }

    /**
     * Сортируем массив по убыванию.
     * @param unsorted несортированный массив без некоторых явно указанных подразделений.
     * @return сортированный по убыванию массив со всеми подразделениями.
     */
    public String[] sortDescendingly(String[] unsorted) {

        Comparator comparator = (Comparator<String>) (o1, o2) -> {
            if (o1.length() < o2.length()) {
                return -1;
            } else if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            } else if (o1.length() > o2.length()) {
                return 1;
            }
            return 0;
        };

        String[] sorted = sortAscending(unsorted);

        int k1Length = 0;

        for (String s: sorted) {
            if (s.charAt(1) == 49) {
                k1Length++;
            } else {
                break;
            }
        }

        String[] k1 = Arrays.copyOf(sorted, k1Length);
        String[] k2 = Arrays.copyOfRange(sorted, k1Length, sorted.length);

        Arrays.sort(k1, comparator);
        Arrays.sort(k2, comparator);

        sorted = ArrayUtils.addAll(k2, k1);
        return sorted;
    }
}
