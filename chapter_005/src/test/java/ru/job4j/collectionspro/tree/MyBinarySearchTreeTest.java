package ru.job4j.collectionspro.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyBinarySearchTreeTest {

    @Test
    public void testAddToMyBST() {
        MyBinarySearchTree binarySearchTree = new MyBinarySearchTree(10);
        binarySearchTree.add(3);
        binarySearchTree.add(11);
        binarySearchTree.add(7);
        binarySearchTree.add(15);
        binarySearchTree.add(12);
    }
}