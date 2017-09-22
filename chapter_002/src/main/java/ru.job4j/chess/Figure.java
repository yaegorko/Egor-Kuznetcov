package ru.job4j.chess;

/**
 * Абстрактный класс для шахматных фигур.
 */
public abstract class Figure {
    /**
     * Клетка под фигурой.
     * MVN ругается на приватность. Как исправить?
     */
    final Cell position;

    /**
     * Конструктор.
     * @param position клетка
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Движение фигур.
     * @param dist конечная точка.
     * @return массив клеток пути.
     * @throws ImpossibleMoveException неправильный путь.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Клон.
     * @param dist конечная точка.
     * @return фигуру.
     */
    public abstract Figure clone(Cell dist);

}


