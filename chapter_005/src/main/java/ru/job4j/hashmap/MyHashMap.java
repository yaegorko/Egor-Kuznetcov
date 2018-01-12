package ru.job4j.hashmap;

/**
 * Класс Мар.
 * @param <K> дженерик для ключей.
 * @param <V> Дженерик значений.
 */
public class MyHashMap<K, V> {
    /**
     * Класс описывающий элементы для хранения.
     * @param <K> ключ.
     * @param <V> значение.
     */
    public class Entry<K, V> {
        private int hash;
        private Object key;
        private Object value;

        public int getHash() {
            return hash;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Массив для хранения значений.
     */
    private Entry<K, V>[] arrayForHashMap = new Entry[4];

    /**
     * Геттр для теста.
     * @return arrayForHashMap
     */
    public Entry<K, V>[] getArrayForHashMap() {
        return arrayForHashMap;
    }

    /**
     * Счетчик добавленных элементов.
     */
    private int addedElementsCounter = 0;

    private int calculateHash(K key) {
        return key.hashCode();
    }

    /**
     * Вычисляем позицию в массиве логическим умножением для предотвращения выхода за пределы массива.
     * @param key объект из дженерика.
     * @return хэшкод.
     */
    private int calculatePosition(K key, Entry[] array) {
        int position = calculateHash(key) & (array.length - 1);
        return position;
    }

    /**
     * Проверяем содержится или нет в хранилище элемент с таким же хэшем как у нашего ключа.
     * @param key ключ
     * @return true если есть такой же хэш.
     */
    private boolean isHashContains(K key) {
        for (Entry entry: arrayForHashMap) {
            if (entry != null && calculateHash(key) == entry.getHash()) {
                return true;
            }
        }
        return false;
    }
//    /**
//     * Проверяем содержится или нет в хранилище элемент с таким же ключом как у наш.
//     * @param key ключ
//     * @return true если есть такой же ключ.
//     */
//    private boolean isKeyContains(K key) {
//        for (Entry entry: arrayForHashMap) {
//            if (key == entry.getKey() || key.equals(entry.getKey())) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * Проверка заполнения массива.
     * @return true если массив еще не полон.
     */
    private boolean arrayIsFull() {
        return addedElementsCounter >= arrayForHashMap.length;
    }

    /**
     * Увеличиваем размер массива при его переполнении.
     * Пересчитываем хэши уже содержащихся элементов.
     */
    private void increaseLength() {
        Entry[] newArrayForHashMap = new Entry[arrayForHashMap.length * 2];
        for (Entry entry: arrayForHashMap) {
            if (entry.getKey() != null) {
                newArrayForHashMap[calculatePosition((K) entry.getKey(), newArrayForHashMap)] = entry;
            }
        }
        arrayForHashMap = newArrayForHashMap;
    }

    /**
     * Добавляем в хранилище новый элемент.
     * @param key ключ
     * @param value значение
     * @return true сли элемент добавлен.
     */
    public boolean insert(K key, V value) {

        if (isHashContains(key)) {
            return false;
        }

        if (arrayIsFull()) {
            increaseLength();
        }

        arrayForHashMap[calculatePosition(key, arrayForHashMap)] = new Entry<>(calculateHash(key), key, value);
        addedElementsCounter++;
        return true;
    }

    public V get(K key) {
        int hash = calculateHash(key);
        for (Entry entry: arrayForHashMap) {
            if (entry != null && hash == entry.getHash() && (key == entry.getKey() || key.equals(entry.getKey()))) {
                return  (V) entry.getValue();
            }
        }
        throw new RuntimeException();
    }

    public boolean delete(K key) {
        int hash = calculateHash(key);
        for (Entry entry : arrayForHashMap) {
            if (entry != null && hash == entry.getHash() && (key == entry.getKey() || key.equals(entry.getKey()))) {
                arrayForHashMap[calculatePosition(key, arrayForHashMap)] = null;
                addedElementsCounter--;
                return true;
            }
        }
        return false;
    }
}
