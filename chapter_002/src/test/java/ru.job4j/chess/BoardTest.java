package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов для класса Board.
 */
public class BoardTest {
    /**
     * Тест перемещения слона на новые координаты, при нормальных условиях.
     * @throws CloneNotSupportedException что-то связаное с клонилкой, пока не разобрался.
     */
    @Test
    public void whenAllCoordinatesAndPositionIsCorrectThanFigureGetNewPosition() throws CloneNotSupportedException {
        Board board = new Board();
        Cell start = new Cell(2, 1);
        Cell finish = new Cell(6, 5);
        Figure whiteDiagonalBishop = new Bishop(start);
        Figure whiteDiagonalBishop2 = new Bishop(new Cell(4, 5));
        Figure[] figures = new Figure[] {whiteDiagonalBishop, whiteDiagonalBishop2};
        board.setFigures(figures);
        board.move(start, finish);
        assertThat(figures[0].position, is(finish));
    }

    /**
     * Тест два слона на одной белой диагонали, один пытается пройти сквозь другого, ожидаем OccupiedWayException.
     * Вариант с expected в @Test
     * @throws CloneNotSupportedException что-то связаное с клонилкой, пока не разобрался.
     */
    @Test(expected = OccupiedWayException.class)
    public void dvaSlonaNaOdnoiDiagonali() throws CloneNotSupportedException {
        Board board = new Board();
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 1));
        Figure whiteDiagonalBishop2 = new Bishop(new Cell(4, 3));
        board.setFigures(new Figure[] {whiteDiagonalBishop, whiteDiagonalBishop2});
        board.move(new Cell(2, 1), new Cell(6, 5));
    }

    /**
     * Тест два слона на одной белой диагонали, для одного указали не верную конечную точку.
     * Вариант с expected в @Test
     * @throws CloneNotSupportedException что-то связаное с клонилкой, пока не разобрался.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenMakeWrongFinishPointThanImpossibleMoveException() throws CloneNotSupportedException {
        Board board = new Board();
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 1));
        Figure whiteDiagonalBishop2 = new Bishop(new Cell(4, 3));
        board.setFigures(new Figure[] {whiteDiagonalBishop, whiteDiagonalBishop2});
        board.move(new Cell(2, 1), new Cell(6, 4));
    }

    /**
     * Тест2 два слона на одной белой диагонали, один пытается пройти сквозь другого, ожидаем OccupiedWayException.
     * вариант2 с try / cathe
     * @throws CloneNotSupportedException что-то связаное с клонилкой, пока не разобрался.
     */
    @Test
    public void dvaSlonaNaOdnoiDiagonali2() throws CloneNotSupportedException {
        Board board = new Board();
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 1));
        Figure whiteDiagonalBishop2 = new Bishop(new Cell(4, 3));
        board.setFigures(new Figure[] {whiteDiagonalBishop, whiteDiagonalBishop2});
        try {
            board.move(new Cell(2, 1), new Cell(6, 5));
        } catch (OccupiedWayException owe) {
            assertThat(owe.getMessage(), is("Путь занят"));
        }
    }

    /**
     * Тест2 два слона на одной белой диагонали, для одного указали не верную конечную точку.
     * вариант2 с try / cathe
     * @throws CloneNotSupportedException что-то связаное с клонилкой, пока не разобрался.
     */
    @Test
    public void whenMakeWrongFinishPointThanImpossibleMoveException2() throws CloneNotSupportedException {
        Board board = new Board();
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 1));
        Figure whiteDiagonalBishop2 = new Bishop(new Cell(4, 3));
        board.setFigures(new Figure[]{whiteDiagonalBishop, whiteDiagonalBishop2});
        try {
            board.move(new Cell(2, 1), new Cell(6, 4));
        } catch (ImpossibleMoveException ime) {
            assertThat(ime.getMessage(), is("Wrong way!"));
        }
    }

    /**
     * Тест на задонной стартовой точке нет фигур.
     * Вариант с expected в @Test
     * @throws CloneNotSupportedException что-то связаное с клонилкой, пока не разобрался.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenWeGetEmptyStartCoordinatesThenFigureNotFoundException() throws CloneNotSupportedException {
        Board board = new Board();
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 1));
        Figure whiteDiagonalBishop2 = new Bishop(new Cell(4, 3));
        board.setFigures(new Figure[]{whiteDiagonalBishop, whiteDiagonalBishop2});
        board.move(new Cell(2, 5), new Cell(6, 4));
    }
    /**
     * Тест2 на задонной стартовой точке нет фигур.
     * вариант2 с try / cathe
     * @throws CloneNotSupportedException что-то связаное с клонилкой, пока не разобрался.
     */
    @Test
    public void whenWeGetEmptyStartCoordinatesThenFigureNotFoundException2() throws CloneNotSupportedException {
        Board board = new Board();
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 1));
        Figure whiteDiagonalBishop2 = new Bishop(new Cell(4, 3));
        board.setFigures(new Figure[]{whiteDiagonalBishop, whiteDiagonalBishop2});
        try {
            board.move(new Cell(2, 5), new Cell(6, 4));
        } catch (FigureNotFoundException fnfe) {
            assertThat(fnfe.getMessage(), is("Нет фигуры на стартовых координатах"));
        }
    }
}
