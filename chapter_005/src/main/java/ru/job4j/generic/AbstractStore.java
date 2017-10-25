package ru.job4j.generic;

public abstract class AbstractStore implements Store {



    @Override
    public Base add(Base model) {
        return null;
    }

    @Override
    public Base update(Base model) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
