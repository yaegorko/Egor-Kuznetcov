package ru.job4j.list;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DynamicListTest {

    private DynamicList dynamicList = new DynamicList();

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

    @Test
    public void whenAddDifferentObjectsInContainerThanGetEmByMethodAndCheck() {
        dynamicList.add(1);
        dynamicList.add("2");
        dynamicList.add('3');
        assertThat(dynamicList.get(0), is(1));
        assertThat(dynamicList.get(1), is("2"));
        assertThat(dynamicList.get(2), is('3'));
    }



}