package ru.job4j.tracker;

import java.io.IOException;

/**
 * Валидный инпут.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Переопределенный Аск для валидации ввода в консоль. Добивается верного ввода до конца.
     * @param question вопрос
     * @param range дипазон допустимых значений ввода.
     * @return допустимое значение key (элемента меню действий) или исключение "Вне диапазона."
     * @throws IOException тянется от буфер ридера.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate date again. ");
                nfe.printStackTrace();
            } catch (MenuOutException moe) {
                System.out.println("Please enter key from menu.");
                moe.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (invalid);
        return value;
    }
}
