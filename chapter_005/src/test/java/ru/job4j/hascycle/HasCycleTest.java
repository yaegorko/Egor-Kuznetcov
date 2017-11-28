package ru.job4j.hascycle;

import org.junit.Test;
import ru.job4j.linkedlist.MyNode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса HasCycle.
 */
public class HasCycleTest {

    MyNode first = new MyNode(null, null, null);
    MyNode second = new MyNode(null, null, null);
    MyNode third = new MyNode(null, null, null);
    MyNode fourts = new MyNode(null, null, null);
    MyNode fifth = new MyNode(null, null, null);
    MyNode sixth = new MyNode(null, null, null);
    MyNode seventh = new MyNode(null, null, null);

    HasCycle hasCycle = new HasCycle();

    /**
     * Нет петель.
     */
    @Test
    public void whenNoOneLoop() {
        first.setNextNode(second);
        second.setNextNode(third);
        third.setNextNode(fourts);
        fourts.setNextNode(fifth);
        assertThat(hasCycle.hasCycle(first), is(false));
    }

    /**
     * Петля в последнем элементе.
     */
    @Test
    public void whenLoopInLastNode() {
        first.setNextNode(second);
        second.setNextNode(third);
        third.setNextNode(fourts);
        fourts.setNextNode(fifth);
        fifth.setNextNode(first);
        assertThat(hasCycle.hasCycle(first), is(true));

    }

    /**
     * Петля в середине.
     */
    @Test
    public void whenLoopInMiddleNode() {
        first.setNextNode(second);
        second.setNextNode(third);
        third.setNextNode(fourts);
        fourts.setNextNode(third);
        fifth.setNextNode(sixth);
        sixth.setNextNode(seventh);
        assertThat(hasCycle.hasCycle(first), is(true));
    }
}