package ru.job4j.profession;

/**
 * Класс болезни для поля Disease класса Person.
 * попробовал ввести когда понял, что не получится использовать конструктор Person с двумя String и для Doctor и для Teacher
 * упаковал String в Disease, вроде получилось. Потом понравилось передавать еще один объект в метод и заданию соответствует.
 * @author - Egor K.
 * @since - 29.08.17
 */
public class Disease {
    /**
     * Переменная disease.
     */
    private String disease;

    /**
     * Коструктор.
     * @param disease Переменная disease.
     */
    public Disease(String disease) {
        this.disease = disease;
    }

    /**
     * Геттер.
     * @return Переменная disease.
     */
    public String getDisease() {
        return disease;
    }

    /**
     * Сеттер.
     * @param disease устанавливает Переменная disease.
     */
    public void setDisease(String disease) {
        this.disease = disease;
    }


}
