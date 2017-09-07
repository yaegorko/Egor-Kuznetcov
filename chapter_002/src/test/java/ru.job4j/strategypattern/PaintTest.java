package ru.job4j.strategypattern;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов для мметода Paint.
 * @author - Egor K.
 * @since - 07.09.17
 */
public class PaintTest {
    /**
     * Перенос строки.
     */
    private final  String line = System.getProperty("line.separator");
    /**
     * Пейнт.
     */
    private final  Paint paint = new Paint();
    /**
     * Квадрат.
     */
    private final  Shape square = new Square();
    /**
     * Треугольник.
     */
    private final  Shape triangle = new Triangle();

    /**
     * Тестим квадрат.
     */
    @Test
    public void whenPaintDrawSquareThanCheck() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(square);
        assertThat(out.toString(), is(String.format("++++%s"
                                                  + "+  +%s"
                                                  + "+  +%s"
                                                  + "++++", line, line, line)));
    }

    /**
     * Тестим треугольник.
     */
    @Test
    public void whenPaintDrawTriangleThanCheck() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        paint.draw(triangle);
        assertThat(out.toString(), is(String.format("   +%s"
                                                  + "  + +%s"
                                                  + " +   +%s"
                                                  + "+++++++", line, line, line)));
    }
}
