package ru.job4j.chess;

/**
 * На пути фигуры припятствие.
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * На пути фигуры припятствие.
     * @param msg msg
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
