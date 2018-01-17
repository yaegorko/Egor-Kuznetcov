package ru.job4j.collectionspro.generic;

/**
 * Интерфейс Stpre.
 * @param <T> дженерик.
 */
public interface Store<T extends Base> {
    /**
     * Добавить объект в хранилище.
     * @param model объект.
     * @return добавленный объект.
     */
    T add(T model);

    /**
     * Обновить элемент в хранилище.
     * @param model новый объект со старым Id.
     * @return обновленный объект.
     */
    T update(T model);

    /**
     * Удалить элемент из хранилища.
     * @param id Id объекта для удаления.
     * @return true если объект удален.
     */
    boolean delete(String id);
}
