package ru.job4j.set;

import java.util.Arrays;
import java.util.Iterator;

/**
 *Реализация Set на основе массива.
 * @param <T> объекты из дженерика.
 */
public class MySet<T> implements SimpleSet<T> {

    private Object[] arrayForSet = new Object[10];

    public Object[] getArrayForSet() {
        return arrayForSet;
    }

    private int numbersOfElements = 0;

    /**
     * Добавляем в Set. Если уже имеется в множестве, то не добавляем.
     * @param t объекты из дженерика.
     */
    @Override
    public void add(T t) {
        if (hasDuplicate(t)) {
            return;
        }
        if (!isContainerFilled()) {
            increaseContainerSize();
        }
        this.arrayForSet[this.numbersOfElements++] = t;
    }

    /**
     * Метод проверяющий вхождение элемента в множество.
     * при использовании MySet требуется переопределение equals.
     * @param t объекты из дженерика.
     * @return true если объект уже есть в множестве.
     */
    private boolean hasDuplicate(T t) {
        for (int i = 0; i < numbersOfElements; i++) {
            if (t.equals(arrayForSet[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверка размера массива при добавлении элемента.
     * @return true если есть место.
     */
    private boolean isContainerFilled() {
        return this.numbersOfElements < this.arrayForSet.length;
    }

    /**
     * Увеличение размера при окончании свободных ячеек.
     */
    private void increaseContainerSize() {
        this.arrayForSet = Arrays.copyOf(this.arrayForSet, this.arrayForSet.length * 2);
    }

    /**
     * Итератор контейнера.
     * @return итератор.
     */
    @Override
    public Iterator<T> iterator() {
        return new MySetIterator(this.arrayForSet);
    }
}
