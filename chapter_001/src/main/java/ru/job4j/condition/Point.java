package ru.job4j.condition;

/**
 * Класс точка.
 *  @author - Egor K.
 *  @since - 15.08.17
 */

public class Point {
    /**
     * Переменая под х.
     */
    private int x;
    /**
     * Переменная под у.
     */
    private int y;

    /**
     * Конструктор класса.
     * @param x координата.
     * @param y координата.
     */

    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Геттер аргумента Х.
     * @return x
     */

    public int getX() {
        return this.x;
    }

    /**
     * Геттер функции У.
     * @return у
     */

    public int getY() {
        return this.y;
    }

    /**
     *
     * y(x) = a * x + b;.
     * @param a коэффициэнт.
     * @param b смещение.
     * @return пренадлежит или нет.
     */
    public boolean is(int a, int b) {
        return getY() == a * getX() + b ? true : false;
    }
}
