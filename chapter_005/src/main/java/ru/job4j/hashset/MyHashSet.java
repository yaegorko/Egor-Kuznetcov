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
    private Object[] arrayForHashSet = new Object[4];

    /**
     * Геттр для теста.
     * @return массив.
     */
    public Object[] getArrayForHashSet() {
        return arrayForHashSet;
    }

    /**
     * Вычисляем хэш логическим умножением для предотвращения выхода за пределы массива.
     * @param t объект из дженерика.
     * @return хэшкод.
     */
    public int calculateHash(T t, Object[] array) {
        int myHash = t.hashCode() & (array.length - 1);
        return myHash;
    }

    /**
     * Добавляем в множество.
     * @param t объект из дженерика.
     * @return true если объект добавлен.
     */
    public boolean add(T t) {
        int index = calculateHash(t, arrayForHashSet);
        if (contains(t)) {
            return false;
        }
        if (arrayIsFull()) {
            increaseLength();
            index = calculateHash(t, arrayForHashSet);
        }
           arrayForHashSet[index] = t;
           return true;
    }

    /**
     * Проверка заполнения массива.
     * @return true если массив еще не полон.
     */
    private boolean arrayIsFull() {
        for (Object obj: arrayForHashSet) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Увеличиваем размер массива при его переполнении.
     * Пересчитываем хэши уже содержащихся элементов.
     */
    public void increaseLength() {
        Object[] newArrayForHashSet = new Object[arrayForHashSet.length * 2];
        for (Object obj: arrayForHashSet) {
            if (obj != null) {
                newArrayForHashSet[calculateHash((T) obj, newArrayForHashSet)] = obj;
            }
        }
        arrayForHashSet = Arrays.copyOf(newArrayForHashSet, newArrayForHashSet.length);
    }

    /**
     * Проверяем содержится ли элемент в множестве.
     * @param t объект.
     * @return true если объект содержится в множестве
     */
    public boolean contains(T t) {
        int index = calculateHash(t, arrayForHashSet);
        return arrayForHashSet[index] != null && t.equals(arrayForHashSet[index]);
    }

    /**
     * Удаляем элемент из множества.
     * @param t объект
     * @return true если объект успешно удален.
     */
    public boolean remove(T t) {
        int index = calculateHash(t, arrayForHashSet);
        if (arrayForHashSet[index] != null) {
            arrayForHashSet[index] = null;
            return true;
        } else {
            return false;
        }
    }
}
