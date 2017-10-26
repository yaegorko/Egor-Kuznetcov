package ru.job4j.generic;

public class NoOneElementsInStoreWithSameIDException extends RuntimeException {

    public NoOneElementsInStoreWithSameIDException() {
        super("No one element with same Id");
    }
}
