package ru.job4j.collectionspro.generic;

/**
 * Роли.
 */
public class Role extends Base {
    /**
     * Конструктор супер класса - только Id.
     * @param id Id
     */
    public Role(String id) {
        super(id);
    }
    /**
     * Конструктор супер класса - Id и тело.
     * @param id Id.
     * @param body body.
     */
    public Role(String id, String body) {
        super(id, body);
    }
}
