package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Добавить объект в хранилище.
     * @param model объект.
     * @return добавленный объект.
     */
    @Override
    public abstract T add(T model);

    /**
     * Обновить элемент в хранилище.
     * @param model новый объект со старым Id.
     * @return обновленный объект.
     */
    @Override
    public abstract T update(T model);

    /**
     * Удалить элемент из хранилища.
     * @param id Id объекта для удаления.
     * @return true если объект удален.
     */
    @Override
    public abstract boolean delete(String id);

    /**
     * Получаем позицию объекта в хранилище по его Id.
     * @param simpleArray хранилище.
     * @param id Id объекта.
     * @return позицию объекта если он есть в хранилище или -1 если такого объекта нет.
     */
    public int checkPositionByID(SimpleArray<T> simpleArray, String id) {
        int position = 0;
        while (simpleArray.getIndex() > 0 && simpleArray.getIndex() > position) {
            if (((simpleArray.get(position)).getId()).equals(id)) {
                return position;
            }
            position++;
        }
        return -1;
    }

}
