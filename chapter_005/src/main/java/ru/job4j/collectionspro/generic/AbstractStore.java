package ru.job4j.collectionspro.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * 
     */
    private SimpleArray models;

    public SimpleArray getModels() {
        return models;
    }

    AbstractStore(int size) {
        this.models = new SimpleArray(size);
    }

    /**
     * Добавить объект в хранилище.
     * @param model объект.
     * @return добавленный объект.
     */
    @Override
    public T add(T model) {
        this.models.add(model);
        return (T) models.get(checkPositionByID(models, model.getId()));
    }

    /**
     * Обновить элемент в хранилище.
     * @param model новый объект со старым Id.
     * @return обновленный объект.
     */
    @Override
    public T update(T model) {

        int position = checkPositionByID(this.models, model.getId());
        if (position >= 0) {
            this.models.update(position, model);
            return (T) this.models.get(position);
        } else {
            throw new NoOneElementsInStoreWithSameIDException();
        }
    }

    /**
     * Удалить элемент из хранилища.
     * @param id Id объекта для удаления.
     * @return true если объект удален.
     */
    @Override
    public boolean delete(String id) {
        int position = checkPositionByID(this.models, id);
        if (position >= 0) {
            this.models.delete(position);
            return true;
        } else {
            return false;
        }
    }

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
