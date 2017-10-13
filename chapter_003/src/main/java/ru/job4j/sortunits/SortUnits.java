package ru.job4j.sortunits;

import java.util.*;

public class SortUnits {

    public String[] parseUnits(String[] unsorted) {

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

    public String[] sortAscending(String[] unsorted) {

        String[] sorted = parseUnits(unsorted);

        return sorted;
    }


    public String[] sortDescendingly(String[] unsorted) {
        String[] sorted = parseUnits(unsorted);

        return sorted;
    }
}
