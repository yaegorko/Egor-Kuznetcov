package ru.job4j.list;


import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов методов класса DynamicList.
 */
public class DynamicListTest {
    /**
     * DynamicList.
     */
    private DynamicList dynamicList = new DynamicList();

    /**
     * Тест метода add, используем getContainer().
     */
    @Test
    public void whenAddDifferentObjectsInContainerThanCheck() {
        dynamicList.add(1);
        dynamicList.add("2");
        dynamicList.add('3');
        Object[] arrayForTests = dynamicList.getContainer();
        assertThat(arrayForTests[0], is(1));
        assertThat(arrayForTests[1], is("2"));
        assertThat(arrayForTests[2], is('3'));
    }

    /**
     * Тест метода get.
     */
    @Test
    public void whenAddDifferentObjectsInContainerThanGetEmByMethodAndCheck() {
        dynamicList.add(1);
        dynamicList.add("2");
        dynamicList.add('3');
        assertThat(dynamicList.get(0), is(1));
        assertThat(dynamicList.get(1), is("2"));
        assertThat(dynamicList.get(2), is('3'));
    }

    /**
     * Тест метода get с индексом большим чем количество элементов в списке.
     */
    @Test (expected = IndexMoreThenNumberOfElementsException.class)
    public void whenTryToGetElementWithIndexMoreThanNumberOfElementsInListThenGetIMTNOEE() {
        dynamicList.add(1);
        dynamicList.add("2");
        dynamicList.add('3');
        assertThat(dynamicList.get(0), is(1));
        assertThat(dynamicList.get(1), is("2"));
        assertThat(dynamicList.get(2), is('3'));
        assertThat(dynamicList.get(3), is(3));
    }

    /**
     * Тест динамического расширения списка.
     */
    @Test
    public void whenAddMoreObjectsThanDefaultCapacityThanCheckNewLength() {
       for (int i = 0; i < 10; i++) {
           dynamicList.add(i);
       }
       assertThat(dynamicList.get(9), is(9));
       assertThat(dynamicList.getContainer().length, is(10));
       dynamicList.add(10);
       assertThat(dynamicList.get(10), is(10));
       assertThat(dynamicList.getContainer().length, is(20));
    }

    /**
     * Тест Итератора на int.
     */
    @Test
    public void whenAddThenIntThanCheckAllWithIterator() {
        for (int i = 0; i < 10; i++) {
            dynamicList.add(i);
        }
        int i = 0;
        Iterator iterator = dynamicList.iterator();
        while (iterator.hasNext()) {
            assertThat(iterator.next(), is(i));
            i++;
        }
        assertThat(iterator.hasNext(), is(false));
    }

    /**
     * Тест итератора на различных объектах.
     */
    @Test
    public void whenAddThreeDifferentObjectsThanCheckAllWithIterator() {
        dynamicList.add(1);
        dynamicList.add("2");
        dynamicList.add('3');
        Iterator iterator = dynamicList.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is('3'));
        assertThat(iterator.hasNext(), is(false));
    }
}