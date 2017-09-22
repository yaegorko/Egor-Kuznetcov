package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов фигуры Слон.
 */
public class BishopTest {

    /**
     * По белой диагонали идем вправо вверх.
     */
    @Test
    public void whenHaveWhiteStartPointAndCorrectFinishPointThanGetTrueWayToRightTop() {
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 1));
        Cell finishPoint = new Cell(6, 5);
        Cell[] trueWay = whiteDiagonalBishop.way(finishPoint);
        assertThat(trueWay[0].getPositionX(), is(3));
        assertThat(trueWay[0].getPositionY(), is(2));
        assertThat(trueWay[1].getPositionX(), is(4));
        assertThat(trueWay[1].getPositionY(), is(3));
        assertThat(trueWay[2].getPositionX(), is(5));
        assertThat(trueWay[2].getPositionY(), is(4));
        assertThat(trueWay[3].getPositionX(), is(6));
        assertThat(trueWay[3].getPositionY(), is(5));
    }

    /**
     * по белой диагонали идем влево вниз.
     */
    @Test
    public void whenHaveWhiteStartPointAndCorrectFinishPointThanGetTrueWayToLeftBot() {
        Figure whiteDiagonalBishop = new Bishop(new Cell(8, 7));
        Cell finishPoint = new Cell(2, 1);
        Cell[] trueWay = whiteDiagonalBishop.way(finishPoint);
        assertThat(trueWay[0].getPositionX(), is(7));
        assertThat(trueWay[0].getPositionY(), is(6));
        assertThat(trueWay[1].getPositionX(), is(6));
        assertThat(trueWay[1].getPositionY(), is(5));
        assertThat(trueWay[2].getPositionX(), is(5));
        assertThat(trueWay[2].getPositionY(), is(4));
        assertThat(trueWay[3].getPositionX(), is(4));
        assertThat(trueWay[3].getPositionY(), is(3));
        assertThat(trueWay[5].getPositionX(), is(2));
        assertThat(trueWay[5].getPositionY(), is(1));
    }

    /**
     * по белой диагонали идем вправо вниз.
     */
    @Test
    public void whenBishopMoveToWhiteDiagonalRightBot() {
        Figure whiteDiagonalBishop = new Bishop(new Cell(2, 7));
        Cell finishPoint = new Cell(7, 2);
        Cell[] trueWay = whiteDiagonalBishop.way(finishPoint);
        for (int i = 0; i < trueWay.length; i++) {
            assertThat(trueWay[i].getPositionX(), is(2 + 1 + i));
            assertThat(trueWay[i].getPositionY(), is(7 - 1 - i));
        }
    }

    /**
     * слон по черной диагонали вправо вниз.
     */
    @Test
    public void whenBishopMoveToBlackDiagonalRightBot() {
        Figure blackDiagonalBishop = new Bishop(new Cell(1, 7));
        Cell finishPoint = new Cell(7, 1);
        Cell[] trueWay = blackDiagonalBishop.way(finishPoint);
        assertThat(trueWay.length, is(6));
        for (int i = 0; i < trueWay.length; i++) {
            assertThat(trueWay[i].getPositionX(), is(1 + 1 + i));
            assertThat(trueWay[i].getPositionY(), is(7 - 1 - i));
        }
    }

    /**
     * Слон по белой диагонали влево вверх.
     */
    @Test
    public void whenHaveWhiteStartPointAndCorrectFinishPointThanGetTrueWayToLeftTop() {
        Figure whiteDiagonalBishop = new Bishop(new Cell(6, 3));
        Cell finishPoint = new Cell(2, 7);
        Cell[] trueWay = whiteDiagonalBishop.way(finishPoint);
        assertThat(trueWay.length, is(4));
        for (int i = 0; i < trueWay.length; i++) {
            assertThat(trueWay[i].getPositionX(), is(6 - 1 - i));
            assertThat(trueWay[i].getPositionY(), is(3 + 1 + i));
        }
    }

}
