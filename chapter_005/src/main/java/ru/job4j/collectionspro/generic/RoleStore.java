package ru.job4j.collectionspro.generic;

/**
 * Хранилище ролей.
 */
public class RoleStore extends AbstractStore<Role> {

    /**
     * Конструктор, устанавливаем размер хранилища roles при создании RoleStore.
     * @param size размер
     */
    public RoleStore(int size) {
        super(size);
    }
}
