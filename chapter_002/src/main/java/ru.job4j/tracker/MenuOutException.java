package ru.job4j.tracker;

/**
 * Класс исключений меню. не требует проброса тк от RuntimeException (Unchecked)
 */
public class MenuOutException extends RuntimeException {
    /**
     * Метод исключений.
     * @param msg сообщение.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
