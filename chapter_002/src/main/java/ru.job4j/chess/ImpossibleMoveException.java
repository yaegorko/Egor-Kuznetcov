package ru.job4j.chess;

/**
 * Неправильный путь для фигуры.
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
     * Неправильный путь для фигуры.
     * @param msg msg
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
