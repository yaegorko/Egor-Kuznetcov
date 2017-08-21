package ru.job4j.condition;

/**
 *  Класс треугольник.
 *  @author - Egor K.
 *  @since - 15.08.17
 */
public class Triangle {
    /**
     * Точка 1.
     */
        private Point a;
    /**
     * Точка 2.
     */
        private Point b;
    /**
     * Точка 3.
     */
        private Point c;

    /**
     * Конструктор.
     * @param a точка 1.
     * @param b точка 2.
     * @param c точка 3.
     */
        public Triangle(Point a, Point b, Point c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        /**
         * Метод должен вычислять расстояние между точками left и right.
         *
         * Для вычисления расстояния использовать формулу.
         * √(xb - xa)^2 + (yb - ya)^2
         *
         * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
         *
         * ^ - степень.
         *
         * @param left Точка слева
         * @param right Точка с права.
         * @return расстояние между точками left и right.
         */
        public double distance(Point left, Point right) {
            return Math.sqrt(Math.pow((right.getX() - left.getX()), 2) + Math.pow((right.getY() - left.getY()), 2));
        }

        /**
         * Метод вычисления периметра по длинам сторон.
         *
         * Формула.
         *
         * (ab + ac + bc) / 2
         *
         * @param ab расстояние между точками a b
         * @param ac расстояние между точками a c
         * @param bc расстояние между точками b c
         * @return Перимент.
         */
        public double period(double ab, double ac, double bc) {
            return (ab + ac + bc) / 2;
        }

        /**
         * Метод должен вычислить прощадь треугольканива.
         *
         * Формула.
         *
         * √ p *(p - ab) * (p - ac) * (p - bc)
         *
         * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
         *
         * @return Вернуть прощадь, если треугольник существует или -1.
         */
        public double area() {
            double rsl = -1;
            double ab = this.distance(this.a, this.b);
            double ac = this.distance(this.a, this.c);
            double bc = this.distance(this.b, this.c);
            double p = this.period(ab, ac, bc);
            if (this.exist(ab, ac, bc)) {

                return Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
                // написать формулу для расчета площади треугольника.
                //rsl = ...
            }
            return rsl;
        }

        /**
         * Метод проверяет можно ли построить треугольник с такими длинами сторон.
         *
         * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
         *
         * @param ab Длина от точки a b.
         * @param ac Длина от точки a c.
         * @param bc Длина от точки b c.
         * @return возможно или нет.
         */
        private boolean exist(double ab, double ac, double bc) {
            if (ab + ac > bc && ab + bc > ac && ac + bc > ab) {
                return true;
            }
            return false;
        }
}
