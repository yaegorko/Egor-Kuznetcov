package ru.job4j.profession;

/**
 * Класс Персона, может быть клиентом, учеником или пациентом.
 * @author - Egor K.
 * @since - 29.08.17
 */

public class Person {
    /**
     * Имя.
     */
    private String name;
    /**
     * Возраст.
     */
    private int age;
    /**
     * Болезни.
     */
    private Disease disease;
    /**
     * Чему обучается. не использовал.
     */
    private String studies;
    /**
     * Желание иметь дом.
     */
    private String wishes;

    /**
     * Геттр имени.
     * @return имя
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
     * Геттр возраста.
     * @return возраст.
     */

    public int getAge() {
        return age;
    }

    /**
     * Сеттр возраста.
     * @param age возраст.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Геттр болезней.
     * @return болезнь.
     */

    public Disease getDisease() {
        return disease;
    }

    /**
     * Сеттр болезней.
     * @param disease болезнь.
     */

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    /**
     * Геттр желаний.
     * @return желание
     */

    public String getWishes() {
        return wishes;
    }

    /**
     * Сеттр желания.
     * @param wishes желание.
     */
    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    /**
     * Конструктор имя-желание для класса Инженер.
     * @param name Имя.
     * @param wishes Желание дома.
     */
    public Person(String name, String wishes) {
        this.name = name;
        this.wishes = wishes;
    }

    /**
     * Конструктор имя-возраст для класса Учитель.
     * @param name имя
     * @param age возраст
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Конструктор имя-болезни для класса Доктор.
     * @param name имя.
     * @param disease болезнь.
     */
    public Person(String name, Disease disease) {
        this.name = name;
        this.disease = disease;
    }

    /**
     * Коструктор по умолчанию.
     */
    public Person() {

    }
}
