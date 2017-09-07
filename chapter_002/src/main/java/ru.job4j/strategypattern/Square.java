package ru.job4j.strategypattern;

/**
 * Класс Квадрат.
 * @author - Egor K.
 * @since - 07.09.17
 */
public class Square implements Shape {
    /**
     * Метод рисует квадрат.
     * @return строчку с квадратом.
     */
    public String pic() {

        String compliteString;
        StringBuilder pic = new StringBuilder();
        pic.append("++++\r\n");
        pic.append("+  +\r\n");
        pic.append("+  +\r\n");
        pic.append("++++");
        compliteString = pic.toString();
        return compliteString;
    }
}
