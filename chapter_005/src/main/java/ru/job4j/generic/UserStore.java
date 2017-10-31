package ru.job4j.generic;

/**
 * Хранилище Юзеров.
 */
public class UserStore extends AbstractStore<User> {

    /**
     * Конструктор, устанавливаем размер хранилища users при создании UserStore.
     * @param size размер
     */
    public UserStore(int size) {
        super(size);
    }

}
