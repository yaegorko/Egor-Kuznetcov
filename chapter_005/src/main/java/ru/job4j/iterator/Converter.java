package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator> it) {

        return new Iterator<Integer>() {

            Iterator<Integer> iterator = it.next();

            @Override
            public boolean hasNext() {
                if (iterator.hasNext()){
                     while (iterator.hasNext()){
                        return true;
                     }
                } else {
                    if (it.hasNext()) {
                        iterator = it.next();
                        return true;
                    }
                }
                return false;
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
