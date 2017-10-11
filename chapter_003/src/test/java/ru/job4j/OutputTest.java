package ru.job4j;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Для тестов выводв в консоль.
 */
public class OutputTest {
    /**
     * Геттр.
     * @return оутпут.
     */
    public ByteArrayOutputStream getOutput() {
        return output;
    }

    /**
     * консоль.
     */
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    /**
     * Хз.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    /**
     * Хз.
     */
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
