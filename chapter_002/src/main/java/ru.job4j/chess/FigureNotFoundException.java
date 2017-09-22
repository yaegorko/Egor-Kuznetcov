package ru.job4j.chess;

/**
 * Фигура не найдена на точке.
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * Фигура не найдена на точке.
     * @param msg msg
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }

}
