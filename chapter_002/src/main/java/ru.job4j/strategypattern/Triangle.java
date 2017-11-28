package ru.job4j.strategypattern;

/**
 * Класс Треугольник.
 * @author - Egor K.
 * @since - 07.09.17
 */
public class Triangle implements Shape {

    /**
     * Метод рисует треугольник.
     * @return строчку с треугольником.
     */
    public String pic() {
        final String line = System.getProperty("line.separator");
        String compliteString;
        StringBuilder pic = new StringBuilder();
        pic.append("   +");
        pic.append(line);
        pic.append("  + +");
        pic.append(line);
        pic.append(" +   +");
        pic.append(line);
        pic.append("+++++++");
        compliteString = pic.toString();
        return compliteString;
    }
}
