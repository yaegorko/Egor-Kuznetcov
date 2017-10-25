package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void syntheticTest1() {
        SimpleArray simpleArray =new SimpleArray(2);
        simpleArray.add(1);
        simpleArray.add("www");
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is("www"));

    }

    @Test
    public void syntheticTest2() {
        SimpleArray simpleArray =new SimpleArray(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.delete(3);
        assertThat(simpleArray.get(3), is(5));
        assertThat(simpleArray.get(4), is(0));

    }

}