package ru.job4j.loop;

/**
 * Класс Paint рисуем пирамиду.
 * @author - Egor K.
 * @since - 22.08.17
 */
public class Paint {
    /**
     * Метод отрисовки пирамиды.
     * @param h высота пирамиды.
     * @return горовую строку с пирамидой.
     */
    public String piramid(int h) {
        String completedString;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = h; i > 0; i--) { //цикл этажности пирамиды;

            for (int y = 0; y < i - 1; y++) { //цикл левых пробелов;
                stringBuilder.append(" ");
            }
            for (int j = 0; j < h - (i - 1); j++) { //цикл кирпичей ^;
                if (j == 0) {
                    stringBuilder.append("^"); // на вершине или первым добавляем один кирпич ^;
                } else {
                    stringBuilder.append("^^"); // на этажах добавляем два  кирпича ^;
                }
            }
            for (int y = 0; y < i - 1; y++) { // цикл правых пробелов;
                stringBuilder.append(" ");
            }
            stringBuilder.append("\r\n"); // переходим на новый этаж;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1); // удаляем последний ненужный перевод строки;
        stringBuilder.deleteCharAt(stringBuilder.length() - 1); // или можно добавить в тестах еще 1 line.separator;
        completedString = stringBuilder.toString();
        return completedString;
    }
}
