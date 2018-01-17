package ru.job4j.collectionspro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс итератор итераторов.
 */
public class Converter {
    /**
     * Метод конвертирующий объект итератор итераторов и возвращающий
     * итератор чисел.
     * @param it итератор итераторов.
     * @return итератор чсел.
     */
    public Iterator<Integer> convert(Iterator<Iterator> it) {

        return new Iterator<Integer>() {

            private Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                if (iterator.hasNext()) {
                    return true;
                } else if (it.hasNext()) {
                    iterator = it.next();
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Integer next() {
                if (iterator.hasNext()) {
                    return iterator.next();
                }
                throw new NoSuchElementException();
            }
        };
    }
}
