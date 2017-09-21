package ru.job4j.chess;

import static java.lang.Math.abs;

public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {

        Cell[] trueWay = new Cell[0];

        //проверяем корректность
        //if (position.getPositionY() % 2 == 0 && position.getPositionX() % 2 != 0 && dist.getPositionX() == 0 && dist.getPositionY() != 0) {
            //проверяем нахождение координат цели пути на одной диагонали сщ стартовой точкой.
            if (abs(dist.getPositionX() - position.getPositionX()) ==  abs(dist.getPositionY() - position.getPositionY())) {

                trueWay = new Cell[abs(position.getPositionX() - dist.getPositionX())];

                //слон идет вправо вверх.
                if (dist.getPositionX() - position.getPositionX() > 0 && dist.getPositionY() - position.getPositionY() > 0) {

                    for (int i = 0; i < trueWay.length; i++) {
                        trueWay[i] = new Cell(position.getPositionX() + i + 1, position.getPositionY() + i + 1);
                    }
                //слон идет вправо вниз.
                } else if (dist.getPositionX() - position.getPositionX() > 0 && dist.getPositionY() - position.getPositionY() < 0) {

                    for (int i = 1; i < trueWay.length; i++) {
                        trueWay[i] = new Cell(position.getPositionX() + i, position.getPositionY() - i);
                    }
                //слон идет влево вверх
                } else if ((dist.getPositionX() - position.getPositionX() < 0 && dist.getPositionY() - position.getPositionY() > 0)) {

                    for (int i = 1; i < trueWay.length; i++) {
                        trueWay[i] = new Cell(position.getPositionX() - i, position.getPositionY() + i);
                    }
                //слон идет влево вниз
                } else if ((dist.getPositionX() - position.getPositionX() < 0 && dist.getPositionY() - position.getPositionY() < 0)) {

                    for (int i = 0; i < trueWay.length; i++) {
                        trueWay[i] = new Cell(position.getPositionX() - i - 1, position.getPositionY() - i - 1);
                    }
                }
            }
        //}

        return trueWay;
    }
}
