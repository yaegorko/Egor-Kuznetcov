package ru.job4j.convert;

/**
 * User.
 */
public class User {
    /**
     * Id.
     */
    private Integer id;
    /**
     * Name.
     */
    private String name;
    /**
     * City.
     */
    private String city;

    /**
     * Getter Id.
     * @return ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Getter Name.
     * @return NAME.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter City.
     * @return CITY
     */
    public String getCity() {
        return city;
    }

    /**
     * Конструктор.
     * @param id Ид
     * @param name Имя
     * @param city Город
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
