package ru.job4j.generic;

/**
 * Класс реализации SimpleArray.
 * @param <T> дженерик
 */

public class SimpleArray<T> {

    /**
     * Массив объектов.
     */
    private Object[] objects;
    /**
     * Индекс массива.
     */
    private int index = 0;

    /**
     * В конструкторе задаем размер массива.
     * @param size размер
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Добавляем элемент в массив.
     * @param value значение элемента.
     */
    public void add(T value) {
        this.objects[this.index++] = value;
    }

    /**
     * Замена элемента в массиве.
     * @param position номер элемента.
     * @param newValue новое значение.
     */
    public void update(int position, T newValue) {
        this.objects[position] = newValue;
    }

    /**
     * Удаление элемента из массива.
     * @param position номер элемента.
     */
    public void delete(int position) {
        if (this.objects[position] != null) {
            System.arraycopy(this.objects, position + 1, this.objects, position, this.index - position - 1);
            this.objects[this.objects.length - 1] = 0;
            this.index--;
        }
    }

    /**
     * Получить элемент.
     * @param position номер элемента.
     * @return элемент.
     */
    public T get(int position) {

        return (T) this.objects[position];
    }
}
