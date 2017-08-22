package ru.job4j.max;

/**
 * Класс на определение максимума из 2х чисел.
 * @author - Egor K.
 * @since - 15.08.17
 */

public class Max {
    /**
     * Метод максимума двух чисел.
     * @param first первое число
     * @param second второе число
     * @return максимум
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * Перегрузка метода max для трех чисел.
     * @param first первое.
     * @param second второе.
     * @param third третье.
     * @return максимум из трех.
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
