package ru.job4j.loop;
/**.
 * Класс посчета суммы четных чисел в заданном диапазоне.
 * @author - Egor K.
 * @since - 21.08.17
 */
public class Counter {

    /**
     * Метод для посчета.
     * @param start начало диапазона.
     * @param finish конец диапозона.
     * @return сумма
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
