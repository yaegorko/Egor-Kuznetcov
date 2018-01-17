package ru.job4j.collectionspro.generic;

/**
 * Свои исключения.
 */
public class NoOneElementsInStoreWithSameIDException extends RuntimeException {
    /**
     * Если не найден элемент с данным Id ы хранилище.
     */
    public NoOneElementsInStoreWithSameIDException() {
        super("No one element with same Id");
    }
}
