package ru.job4j.chess;

/**
 * Класс для доски.
 */
public class Board {

    /**
     * Массив фигур на доске.
     */
    private Figure[] figures;

    /**
     * Установить массив.
     * @param figures фигуры.
     */
    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    /**
     * Класс для проверки возможности движения фигур.
     * @param source начальная точка.
     * @param dist конечная точка.
     * @return тру или экзепшн.
     * @throws ImpossibleMoveException недостижимая точка для фигуры, фигура ходит не так.
     * @throws OccupiedWayException препятствие на пути фигуры.
     * @throws FigureNotFoundException фигура не найдена в стартовой точке.
     * @throws CloneNotSupportedException проблеммы с перезаписью фигуры в массиве.
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException, CloneNotSupportedException {

        for (int i = 0; i < figures.length; i++) {
            if (source.equals(this.figures[i].position)) {
                Cell[] way = figures[i].way(dist);
                    for (int n = 0; n < way.length; n++) {
                        for (int j = 0; j < figures.length; j++) {
                            if (way[n].equals(figures[j].position)) {
                                throw new OccupiedWayException("Путь занят");
                            }
                        }
                    }
                    figures[i] = figures[i].clone(dist);
                    return true;
                }
            }

        throw new FigureNotFoundException("Нет фигуры на стартовых координатах");
    }

}


