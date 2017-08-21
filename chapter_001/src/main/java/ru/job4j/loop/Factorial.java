package ru.job4j.loop;

/**
 * Класс Факториал.
 * @author - Egor K.
 * @since - 21.08.17
 */
public class Factorial {
    /**
     * Метод вычисления факториала n.
     * @param n диапазон.
     * @return факториал n
     */
    public int calc(int n) {

        int factorial = 1;

        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }
        }
        return factorial;
    }
}
