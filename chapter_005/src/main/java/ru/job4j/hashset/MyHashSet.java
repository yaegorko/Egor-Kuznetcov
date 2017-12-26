package ru.job4j.hashset;

import java.util.Arrays;

/**
 * Класс множества на основе хэш таблицы.
 * @param <T> объекты из дженерика.
 */
public class MyHashSet<T> {
    /**
     * массив для множества.
     */
    private Object[] arrayForHashSet = new Object[128];

    /**
     * Геттр для теста.
     * @return массив.
     */
    public Object[] getArrayForHashSet() {
        return arrayForHashSet;
    }

    /**
     * Вычисляем хэш. Требует переопределения hashCode при использовании множества.
     * @param t объект из дженерика.
     * @return хэшкод.
     */
    private int calculateHash(T t) {
        int myHash = t.hashCode() & (arrayForHashSet.length - 1);
        return myHash;
    }

    /**
     * Добавляем в множество.
     * @param t объект из дженерика.
     * @return true если объект добавлен.
     */
    public boolean add(T t) {
        int index = calculateHash(t);
        if (contains(t)) {
            return false;
        }
        if (!isInRange(index)) {
            increaseLength(arrayForHashSet.length * 2);
        }
           arrayForHashSet[index] = t;
           return true;
    }

    /**
     * Проверка на вхождение в размер массива.
     * @param index индекс в массиве.
     * @return true если индекс попадает в размер.
     */
    private boolean isInRange(int index) {
        return index < arrayForHashSet.length;
    }

    /**
     * Увеличиваем размер массива до попадания в него индекса.
     * @param newLength индекс по хешкоду - новый размер.
     */
    private void increaseLength(int newLength) {
        arrayForHashSet = Arrays.copyOf(arrayForHashSet, newLength + 1);
    }

    /**
     * Проверяем содержится ли элемент в множестве.
     * @param t объект.
     * @return true если объект содержится в множестве
     */
    public boolean contains(T t) {
        int index = calculateHash(t);
        return isInRange(index) && arrayForHashSet[index] != null && t.equals(arrayForHashSet[index]);
    }

    /**
     * Удаляем элемент из множества.
     * @param t объект
     * @return true если объект успешно удален.
     */
    public boolean remove(T t) {
        int index = calculateHash(t);
        if (isInRange(index) && arrayForHashSet[index] != null) {
            arrayForHashSet[index] = null;
            return true;
        } else {
            return false;
        }
    }
}
