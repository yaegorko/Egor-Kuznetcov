package ru.job4j.collectionspro.generic;

/**
 * Юзеры.
 */
public class User extends Base {
    /**
     * Конструктор супер класса - только Id.
     * @param id Id
     */
    public User(String id) {
        super(id);
    }
    /**
     * Конструктор супер класса - Id и тело.
     * @param id Id.
     * @param body body.
     */
    public User(String id, String body) {
        super(id, body);
    }
}
