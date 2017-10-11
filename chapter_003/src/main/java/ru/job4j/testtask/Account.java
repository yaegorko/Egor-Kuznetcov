package ru.job4j.testtask;

/**
 * Класс для счетов пользователей.
 */
public class Account {
    /**
     * Деньги на счету.
     */
    private double value;
    /**
     * Номер счета.
     */
    private int requisites;

    /**
     * Конструктор по умолчанию.
     */
    public Account() {
    }

    /**
     * Конструктор с номером счета и деньгами.
     * @param value деньги.
     * @param requisites номер счета
     */
    public Account(int value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Получить количество денег.
     * @return деньги.
     */
    public double getValue() {
        return value;
    }

    /**
     * Установить количество денег.
     * @param value деньги.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Получить номер счета.
     * @return номер счета
     */
    public int getRequisites() {
        return requisites;
    }

    /**
     * Установить номер счета.
     * @param requisites номер счета.
     */
    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }
}
