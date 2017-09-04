package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Тесты класса ArrayDuplicate.
 * @author - Egor K.
 * @since - 24.08.17
 */
    public class ArrayDuplicateTest {
    /**
     * Тест метода remove.
     */
    @Test
        public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
            //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
            ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
            String[] initial = {"Привет", "Мир", "Привет", "Привет", "Мир", "Мир", "Супер", "Мир"};
            String[] expected = {"Привет", "Мир", "Супер"};
            String[] result = arrayDuplicate.remove(initial);
            assertThat(result, is(expected));
        }

    /**
     * Тест проверяющий удаление дубликатов строк из массива строк.
     */
    @Test
    public void whenArrayAllDuplicateThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] initial = {"1", "1", "1", "1", "1"};
        String[] expected = {"1"};
        assertThat(arrayDuplicate.remove(initial), is(expected));
    }
    }

