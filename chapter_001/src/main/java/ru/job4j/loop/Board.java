package ru.job4j.loop;

/**
 * Класс Board рисуем псевдошахматную доску.
 * @author - Egor K.
 * @since - 21.08.17
 */
public class Board {
    /**
     * Метод paint рисующий доску.
     * @param width ширина доски.
     * @param height длинна доски.
     * @return конечную строку в виде доски.
     */

    public String paint(int width, int height) {
        String completedString;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= height; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j <= width; j++) {
                    if (j % 2 == 0) {
                        stringBuilder.append(" ");
                    } else {
                        stringBuilder.append("x");
                    }
                    if (j == width) {
                        stringBuilder.append("\r\n");
                    }
                }

            } else {
                for (int j = 1; j <= width; j++) {
                    if (j % 2 != 0) {
                        stringBuilder.append(" ");
                    } else {
                        stringBuilder.append("x");
                    }
                    if (j == width) {
                        stringBuilder.append("\r\n");
                    }
                }
            }
        }

        completedString = stringBuilder.toString();
        return completedString;
    }
}
