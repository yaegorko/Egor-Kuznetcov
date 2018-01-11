package ru.job4j.hashmap;

/**
 * Класс Мар.
 * @param <K> дженерик для ключей.
 * @param <V> Дженерик значений.
 */
public class MyHashMap<K, V> {

    /**
     * Массив для хранения значений.
     */
    private Object[] arrayForHashMap = new Object[16];
    /**
     * Счетчик добавленных элементов.
     */
    private int addedElementsCounter = 0;
    /**
     * Степень заполнения массива при которой происходит удвоение массива.
     */
    private static final double occupancyRate = 0.75;

    /**
     * Вычисляем позицию в массиве arrayForHashMap логическим умножением для предотвращения выхода за пределы массива.
     * @param k объект из дженерика.
     * @return хэшкод.
     */
    public int calculateHash(K k, Object[] array) {
        int position = k.hashCode() & (array.length - 1);
        return position;
    }

    boolean insert(K key, V value) {
        return true;
    }
//    V get(K key) {
//
//    }

    boolean delete(K key) {
        return true;
    }
}
