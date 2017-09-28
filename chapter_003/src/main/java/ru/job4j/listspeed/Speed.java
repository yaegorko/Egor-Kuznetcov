package ru.job4j.listspeed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Speed {

    private List<String> arrayList;
    private List<String> linkedList;
    private Set<String> treeSet;

    public List<String> getArrayList() {
        return arrayList;
    }

    public List<String> getLinkedList() {
        return linkedList;
    }

    public Set<String> getTreeSet() {
        return treeSet;
    }

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


    public long add(Collection<String> collection, int amount) {

        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {

            collection.add(String.valueOf(System.currentTimeMillis() + new Random().nextInt()));
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

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
