package ru.job4j.listspeed;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов класса Speed.
 */
public class SpeedTest {
    /**
     * Объект класса Speed.
     */
    private final Speed test = new Speed();
    /**
     * Стартовый размер коллекций.
     */
    private final int collectionSize = 200000;
    /**
     * Количество добавляемых или удаляемых эл-тов.
     */
    private final int amount = 50000;

//    /** Мешает при сборке из-за долгого тестирования.
//     * Тестируем добавление эл-тов в коллекции.
//     * При стартовом размере коллекции 1000000 при добавлении более 280000 эл-тов тест проваливается.
//     * Т.е. LinkedList быстрее до 280000.
//     */
//    @Test
//    public void whenAddNewElementsToCollectionsThanCompareTime() {
//
//        test.generateLists(collectionSize);
//        long arrT = test.add(test.getArrayList(), amount);
//        System.out.println(String.format("Add to ArrayList size %s, %s new elements in %s ", collectionSize, amount, arrT));
//        long linT = test.add(test.getLinkedList(), amount);
//        System.out.println(String.format("Add to LinkedList size %s, %s new elements in %s ", collectionSize, amount, linT));
//        long treT = test.add(test.getTreeSet(), amount);
//        System.out.println(String.format("Add to TreeSet size %s, %s new elements in %s ", collectionSize, amount, treT));
//        assertThat(linT < arrT, is(false));
//        assertThat(arrT < treT, is(false));
//
//    }

    /**
     * Тестируем удаление.
     */
    @Test
    public void whenDeleteNElementsFromCollectionsThanCompareTime() {

        test.generateLists(collectionSize);
        long arrT = test.delete(test.getArrayList(), amount);
        System.out.println(String.format("Remove from ArrayList size %s, %s first elements in %s ", collectionSize, amount, arrT));
        long linT = test.delete(test.getLinkedList(), amount);
        System.out.println(String.format("Remove from LinkedList size %s, %s first elements in %s ", collectionSize, amount, linT));
        long treT = test.delete(test.getTreeSet(), amount);
        System.out.println(String.format("Remove from TreeSet size %s, %s first elements in %s ", collectionSize, amount, treT));
        assertThat(linT < treT, is(true));
        assertThat(treT < arrT, is(true));
    }
}
