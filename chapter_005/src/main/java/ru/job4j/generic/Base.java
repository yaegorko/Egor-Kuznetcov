package ru.job4j.generic;

/**
 * Прототип объектов хранения.
 */
public abstract class Base {
    /**
     * Id объекта.
     */
    private String id;

    /**
     * Тело объекта.
     */
    private String body;

    /**
     * Конструктор - только Id.
     * @param id Id
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Конструктор - Id и тело.
     * @param id Id.
     * @param body body.
     */
    public Base(String id, String body) {
        this.id = id;
        this.body = body;
    }

    /**
     * Получить Id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Установить Id.
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }
}
