package ru.job4j.chess;

public abstract class Figure {

    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        return new Cell[7];
    }
}


