package ru.job4j.controltusk;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса ControlTusk для задания "Проверка, что одно слово находится в другом слове".
 * @author - Egor K.
 * @since - 25.08.17
 */

public class ControlTuskTest {

    /**
     * Базовый тест вхождения строки без условий.
     */

    @Test
    public void whenStringContainsSubstringThanTrue() {
        ControlTusk controlTusk = new ControlTusk();
        String initialString = "Привет";
        String initialSubstring = "рив";
        boolean expected = true;
        assertThat(controlTusk.contains(initialString, initialSubstring), is(expected));
    }

    /**
     * Повторяющиеся точки вхождения подстроки в исходной строке.
     */

    @Test
    public void whenStringAndSubstringContainsDuplicatedSymbolsAndStringContainsSubstringThanTrue() {
        ControlTusk controlTusk = new ControlTusk();
        String initialString = "пппривет";
        String initialSubstring = "при";
        boolean expected = true;
        assertThat(controlTusk.contains(initialString, initialSubstring), is(expected));
    }

    /**
     * Основная строка состоит из множества частей подстроки.
     */

    @Test
    public void whenStringContainsManyOfPartsSubstringAndContainsFullSubstringThenTrue() {
        ControlTusk controlTusk = new ControlTusk();
        String initialString = "ппрпрприпривет";
        String initialSubstring = "при";
        boolean expected = true;
        assertThat(controlTusk.contains(initialString, initialSubstring), is(expected));
    }

    /**
     * Подстрока состоит из одного символа.
     */

    @Test
    public void whenSubstringLengthIsOneAndStringContainsSubstringThanTrue() {
        ControlTusk controlTusk = new ControlTusk();
        String initialString = "Привет";
        String initialSubstring = "е";
        boolean expected = true;
        assertThat(controlTusk.contains(initialString, initialSubstring), is(expected));
    }

    /**
     * Подстрока не входит в исходную строку.
     */

    @Test
    public void whenStringDoNotContainsSubstringThanFalse() {
        ControlTusk controlTusk = new ControlTusk();
        String initialString = "Привет";
        String initialSubstring = "Нет";
        boolean expected = false;
        assertThat(controlTusk.contains(initialString, initialSubstring), is(expected));
    }

    /**
     * Теоретическая точка вхождения находится ближе к концу исходной строки, чем длина подстроки.
     */

    @Test
    public void whenStringDoNotContainsSubstringAndWrongEnterPointThanFalse() {
        ControlTusk controlTusk = new ControlTusk();
        String initialString = "Привет";
        String initialSubstring = "ету";
        boolean expected = false;
        assertThat(controlTusk.contains(initialString, initialSubstring), is(expected));
    }

}
