package ru.job4j.loop;

        import org.junit.Test;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

/**
 * Тесты класса Board.
 * @author - Egor K.
 * @since - 21.08.17
 */
public class BoardTest {
    /**
     * Тест  метода paint, проверяющий правильность доски  шириной 3 и длинной 3.
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String line = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }
    /**
     * Тест  метода paint, проверяющий правильность доски шириной 5 и длинной 4.
     */

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {

        Board board = new Board();
        String result = board.paint(5, 4);
        final String line = System.getProperty("line.separator");
        /*
        Для доски 5 на 4 вид:
         x x x\r\n
          x	x \r\n
         x x x\r\n
          x	x \r\n
        */
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line, line);
        assertThat(result, is(expected));
    }
}