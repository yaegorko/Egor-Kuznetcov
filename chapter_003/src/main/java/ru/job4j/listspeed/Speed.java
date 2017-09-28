package ru.job4j.listspeed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс для сравнения скорости добавления и удаления э-тов в коллекции.
 * @author - Egor K.
 * @since - 28.09.17
 */
public class Speed {
    /**
     * Аррай лист.
     */
    private List<String> arrayList;
    /**
     * ЛинкедЛист.
     */
    private List<String> linkedList;
    /**
     * ТриСет.
     */
    private Set<String> treeSet;

    /**
     * Геттр для тестов.
     * @return arrayList
     */
    public List<String> getArrayList() {
        return arrayList;
    }

    /**
     * Геттр для тестов.
     * @return linkedList
     */
    public List<String> getLinkedList() {
        return linkedList;
    }

    /**
     * Геттр для тестов.
     * @return treeSet
     */
    public Set<String> getTreeSet() {
        return treeSet;
    }

    /**
     * Генерируем ArrayList с уникальными(скорее всего) строками и копируем его значения в.
     * LinkedList и TreeSet.
     * @param length размер коллекций.
     */
    public void generateLists(int length) {

        arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arrayList.add(String.valueOf(System.currentTimeMillis() + new Random().nextInt()));
        }

        linkedList = new LinkedList<>();
        linkedList.addAll(arrayList);

        treeSet = new TreeSet<>();
        treeSet.addAll(arrayList);
    }

    /**
     * Метод для подсчета времени добавления эл-тов в коллекции.
     * Эл-ты добавляем в конец коллекций.
     * @param collection коллекция.
     * @param amount кол-во добавляемых эл-тов.
     * @return время процесса.
     */
    public long add(Collection<String> collection, int amount) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(System.currentTimeMillis() + new Random().nextInt()));
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }
    /**
     * Метод для подсчета времени удаления эл-тов из коллекции.
     * Эл-ты удаляем сначала коллекций.
     * @param collection коллекция.
     * @param amount кол-во удаляемых эл-тов.
     * @return время процесса.
     */
    public long delete(Collection<String> collection, int amount) {

        int count = 0;
        long start = System.currentTimeMillis();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (count < amount) {
                iterator.next();
                iterator.remove();
                count++;
            } else {
                break;
            }

        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}
