package ru.job4j.tracker;

/**
 * Класс Итем - заявка в Трекере.
 * @author - Egor K.
 * @since - 04.09.17
 */

public class Item {
    /**
     * Имя заявки.
     */
    private String name;
    /**
     * Описание.
     */
    private String description;
    /**
     * Дата создания.
     */
    private long dateOfCreation;
    /**
     * комментарии.
     */
    private String[] arrayOfComments;
    /**
     * Айди заявки - генерится при создании.
     */
    private String id;

    /**
     * геттр.
     * @return Айди.
     */

    public String getId() {
        return id;
    }

    /**
     * Сетрр айди.
     * @param id айди.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Геттр имени.
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттр имени.
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Сеттер дискрипшена.
     * @param description дескрипшн
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Геттр дискрипшена.
     * @return дескрипшн
     */
    public String getDescription() {
        return description;
    }

    /**
     * Конструктор по умолчанию.
     */
    public Item() {

    }

    /**
     * Конструктор с.
     * @param name имя
     * @param description описание
     * @param dateOfCreation дата
     */
    public Item(String name, String description, long dateOfCreation) {
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
    }

    /**
     * Конструктор.
     * @param name имя
     * @param description описание
     */

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
