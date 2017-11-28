package ru.job4j.hascycle;

import ru.job4j.linkedlist.MyNode;

/**
 * Класс поиска цикла в связном списке
 */
public class HasCycle {
    /**
     * Ищем цикл.
     * @param start начальная нода
     * @return true - если есть цикл
     */
    public boolean hasCycle(MyNode start) {

        MyNode slowPath = start;
        MyNode fastPath = start;
        boolean haveCycle = false;
        
        do {
            slowPath = slowPath.getNextNode();
            fastPath = fastPath.getNextNode().getNextNode();
            if (slowPath.equals(fastPath)) {
                haveCycle = true;
                break;
            }
        } while (fastPath.getNextNode() != null);

        return haveCycle;
    }
}
