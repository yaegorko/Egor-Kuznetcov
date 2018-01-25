package ru.job4j.collectionspro.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyBinarySearchTreeTest {

    @Test
    public void testAddToMyBST() {
        MyBinarySearchTree binarySearchTree = new MyBinarySearchTree(10);
        binarySearchTree.add(3);
        binarySearchTree.add(11);
        binarySearchTree.add(7);
        binarySearchTree.add(15);
        binarySearchTree.add(12);
        Iterator iterator = binarySearchTree.iterator();
        //Node node = (Node)
        assertThat(iterator.next(), is(10));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(11));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.next(), is(15));
        assertThat(iterator.next(), is(12));
    }


}