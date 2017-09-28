package ru.job4j.listspeed;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpeedTest {

    private final Speed test = new Speed();
    private final int collectionSize = 100000;
    private final int amount = 50000;

    @Test
    public void addTest() {

        test.generateLists(collectionSize);
        long arrT = test.add(test.getArrayList(), amount);
        System.out.println(String.format("Добавляем в ArrayList размером %s, %s новых элементов за %s ", collectionSize, amount, arrT));
        long linT = test.add(test.getLinkedList(), amount);
        System.out.println(String.format("Добавляем в LinkedList размером %s, %s новых элементов за %s ", collectionSize, amount, linT));
        long trrT = test.add(test.getTreeSet(), amount);
        System.out.println(String.format("Добавляем в TreeSet размером %s, %s новых элементов за %s ", collectionSize, amount, trrT));

        assertThat(linT > arrT, is(false));
    }

    @Test
    public void test2() {

        test.generateLists(collectionSize);
        long arrT = test.delete(test.getArrayList(), amount);
        System.out.println(String.format("Удаляем из ArrayList размером %s, %s первых элементов за %s ", collectionSize, amount, arrT));
        long linT = test.delete(test.getLinkedList(), amount);
        System.out.println(String.format("Удаляем из LinkedList размером %s, %s первых элементов за %s ", collectionSize, amount, linT));
        long trrT = test.delete(test.getTreeSet(), amount);
        System.out.println(String.format("Удаляем из TreeSet размером %s, %s первых элементов за %s ", collectionSize, amount, trrT));
        assertThat(linT < arrT, is(true));
    }


}
