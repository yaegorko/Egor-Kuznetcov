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
            if (source.equals(this.figures[i].getPosition())) { //проверяю есть ли на source фигура из массива Figures
                Cell[] way = figures[i].way(dist); //если есть вызываю метод way для фигуры, он вернет либо путь, либо исключение ImpossibleMoveException
                    for (int n = 0; n < way.length; n++) {          // на всем пути фигуры полученном из way
                        for (int j = 0; j < figures.length; j++) {  // проверяем наличие всех других фигур из Figures
                            if (way[n].equals(figures[j].getPosition())) { // проверяем позицию фигур из Figures на пути фигуры стоявшей на source
                                throw new OccupiedWayException("Путь занят"); // если совпало бросаем OccupiedWayException
                            }
                        }
                    }
                    figures[i] = figures[i].clone(dist); // если все ок, переписываем положение фигуры стоявшей на source, новым объектом
                    return true; //цель достигнута, заканчиваем.
                } else {
                    throw new FigureNotFoundException("Нет фигуры на стартовых координатах"); //если нет фигуры на source бросаем FigureNotFoundException
                }
            }

        return false; //Сюда не должны доходить.
    }
}


