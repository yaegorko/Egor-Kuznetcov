package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    @Override
    public T add(T model) {
        return null;
    }

    @Override
    public T update(T model) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
