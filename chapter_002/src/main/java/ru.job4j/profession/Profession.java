package ru.job4j.profession;

/**
 * Класс Професси родительский для Доктора, Учителя, Инженера.
 * @author - Egor K.
 * @since - 29.08.17
 */

public class Profession {
    /**
     * Имя.
     */
    private String name;
    /**
     * Возраст.
     */
    private int age;
    /**
     * Пол. Не использовался.
     */
    private String sex;
    /**
     * ВУЗ.
     */
    private String college;

    /**
     * Геттр имени.
     * @return имя
     */

    public String getName() {
        return name;
    }

    /**
     * Сеттр имени.
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * геттр возраста.
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
     * Геттр ВУЗа.
     * @return ВУЗ
     */
    public String getCollege() {
        return college;
    }

    /**
     * Сеттр ВУЗа.
     * @param college ВУЗ
     */
    public void setCollege(String college) {
        this.college = college;
    }

}
