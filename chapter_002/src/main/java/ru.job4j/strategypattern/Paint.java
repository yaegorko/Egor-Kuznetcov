package ru.job4j.strategypattern;

/**
 * Класс Пейнт. Реализуем паттерн Стратегия.
 * @author - Egor K.
 * @since - 07.09.17
 */
public class Paint {

    /**
     * Рисуем фигуры.
     * @param shape в зависимости от шейп треугольник или квадрат.
     */
    public void draw(Shape shape) {

        System.out.print(shape.pic());
    }

}
