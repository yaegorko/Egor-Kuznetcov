package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {

    @Override
    public abstract T add(T model);

    @Override
    public abstract T update(T model);

    @Override
    public abstract boolean delete(String id);

    public int checkPositionByID(SimpleArray simpleArray, String id) {
        int position = 0;
        while (simpleArray.getIndex() > 0 && simpleArray.getIndex() > position) {
            if ((((Base) simpleArray.get(position)).getId()).equals(id)) {
                return position;
            }
            position++;
        }
        return -1;
    }

}
