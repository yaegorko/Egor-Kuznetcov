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

        String compliteString;
        StringBuilder pic = new StringBuilder();
        pic.append("   +\r\n");
        pic.append("  + +\r\n");
        pic.append(" +   +\r\n");
        pic.append("+++++++");
        compliteString = pic.toString();
        return compliteString;
    }
}
