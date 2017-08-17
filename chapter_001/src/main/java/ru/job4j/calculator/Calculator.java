package ru.job4j.calculator;

/**
 * Класс Calculator.
 * @author - Egor K.
 * @since - 14.08.17
 */

public class Calculator {
    /**
     * Результат.
     */
    private double result;

    /**
     * Метод сложения.
     * @param first первый
     * @param second второй
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Метод вычитания.
     * @param first первый
     * @param second второй
     */
    public void minus(double first, double second) {
        this.result = first - second;
    }
    /**
     * Метод умножения.
     * @param first первый
     * @param second второй
     */
    public void multiplicate(double first, double second) {
        this.result = first * second;
    }
    /**
     * Метод деления.
     * @param first первый
     * @param second второй
     */
    public void division(double first, double second) {
        this.result = first / second;
    }
    /**
     * Геттер результата.
     * @return this.result
     */

    public double getResult() {
        return this.result;
    }
}
