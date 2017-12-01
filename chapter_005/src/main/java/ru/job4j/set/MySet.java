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
     * Добавляем в Set.
     * @param t объекты из дженерика.
     */
    @Override
    public void add(T t) {
        for (int i = 0; i < numbersOfElements ; i++) {
            if (t.equals(arrayForSet[i])) {
                return;
            }
        }
        if (checkContainerSize()) {
            this.arrayForSet[this.numbersOfElements++] = t;
        } else {
            increaseContainerSize();
            this.arrayForSet[this.numbersOfElements++] = t;
        }
    }

    /**
     * Проверка размера массива при добавлении элемента.
     * @return
     */
    private boolean checkContainerSize() {
        return this.numbersOfElements < this.arrayForSet.length;
    }

    /**
     * Увеличение размера при окончании свободных ячеек.
     */
    private void increaseContainerSize() {
        this.arrayForSet = Arrays.copyOf(this.arrayForSet, this.arrayForSet.length * 2);
    }


    @Override
    public Iterator<T> iterator() {
        return new MySetIterator(this.arrayForSet);
    }
}
