package ru.job4j.hashmap;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyHashMapTest {

    private MyHashMap myHashMap = new MyHashMap();

    @Test
    public void whenAddElementsToMyHashMapThenGetEmByGetter() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");

        Object key;
        int positionByKey;
        Object[] testArray = myHashMap.getArrayForHashMap();

        key = 1;
        positionByKey = key.hashCode() & (testArray.length - 1);
        MyHashMap.Entry entry1 = (MyHashMap.Entry) testArray[positionByKey];
        assertThat(entry1.getValue(), is("Masha"));

        key = 2;
        positionByKey = key.hashCode() & (testArray.length - 1);
        MyHashMap.Entry entry2 = (MyHashMap.Entry) testArray[positionByKey];
        assertThat(entry2.getValue(), is("Dasha"));
    }

    @Test
    public void whenAddElementWithSameKeyThanGetFalse() {
        assertThat(myHashMap.insert(1, "Masha"), is(true));
        assertThat(myHashMap.insert(1, "Misha"), is(false));
    }

    @Test
    public void whenAddMoreElementsWhenContainerCanHoldThenIncreaseLength() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");
        myHashMap.insert(3, "Misha");
        myHashMap.insert(4, "Grisha");

        Object[] testArray = myHashMap.getArrayForHashMap();

        assertThat(testArray.length, is(4));

        myHashMap.insert(5, "Glasha");

        testArray = myHashMap.getArrayForHashMap();
        assertThat(testArray.length, is(8));
    }

    @Test
    public void whenTryGetElementFromMyHashMapAndGetIt() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");
        assertThat(myHashMap.get(1), is("Masha"));
        assertThat(myHashMap.get(2), is("Dasha"));
    }

    @Test (expected = RuntimeException.class)
    public void whenTryGetElementFromMyHashMapButElementNotInMapThenGetNull() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");
        assertThat(myHashMap.get(3), is(5));
    }
}