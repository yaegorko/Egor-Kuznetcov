package ru.job4j.chess;

/**
 * Класс клетки шахматной доски.
 */

public class Cell {

    /**
     * Координата Х. (не по канону, не алфавитом).
     */
    private int positionX;
    /**
     * Координата Y.
     */
    private int positionY;

    /**
     * Конструктор.
     * @param positionX X
     * @param positionY Y
     */
    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    /**
     * Get X.
     * @return X.
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Get Y.
     * @return Y.
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Ох. Переопределяю сравнение объектов Cell (Клетка).
     * Без переопределения почему-то клетки не сравнивались.
     * @param obj Object приводим к Cell.
     * @return результат сравнения.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cell other = (Cell) obj;
        return this.positionX == other.positionX && this.positionY == other.positionY ? true : false;
    }

    /**
     * Переопределяю hashCode, без этого mvn ругается.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
