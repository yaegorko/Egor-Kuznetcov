package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopTest {

    //по белой диагонали идем вправо вверх.
    @Test
    public void whenHaveWhiteStartPointAndCorrectFinishPointThanGetTrueWay() {
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

    //по белой диагонали идем влево вниз.
    @Test
    public void whenHaveWhiteStartPoint() {
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
}
