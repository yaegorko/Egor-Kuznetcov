package ru.job4j.collectionspro.hashmap;

import org.junit.Test;
import ru.job4j.collectionspro.hashmap.MyHashMap;

import java.util.Objects;

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

    @Test
    public void whenTryDeleteElementFromMyHashMapAndThanGetTrue() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");
        assertThat(myHashMap.delete(1), is(true));
    }

    @Test
    public void whenTryDeleteElementFromMyHashMapButCantThanGetFalse() {
        myHashMap.insert(1, "Masha");
        myHashMap.insert(2, "Dasha");
        assertThat(myHashMap.delete(1), is(true));
        assertThat(myHashMap.delete(1), is(false));
    }

    @Test
    public void whenTryGetAndDeleteElementFromMyHashMapKeyIsNotPrimitive() {

        class Keys {

            String name;
            String surname;

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }
                Keys keys = (Keys) o;
                return Objects.equals(name, keys.name)
                        && Objects.equals(surname, keys.surname);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, surname);
            }

            public Keys(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }
        }
        Keys masha = new Keys("Masha", "Ivanova");
        Keys dasha = new Keys("Dasha", "Sidorova");
        Keys masha1 = new Keys("Masha", "Ivanova");
        assertThat(myHashMap.insert(masha, 25), is(true));
        assertThat(myHashMap.insert(dasha, 26), is(true));
        assertThat(myHashMap.insert(masha1, 27), is(false));
        assertThat(myHashMap.get(masha), is(25));
        assertThat(myHashMap.get(masha1), is(25));
        assertThat(myHashMap.get(dasha), is(26));
        assertThat(myHashMap.delete(masha), is(true));
        assertThat(myHashMap.delete(masha), is(false));
    }

}