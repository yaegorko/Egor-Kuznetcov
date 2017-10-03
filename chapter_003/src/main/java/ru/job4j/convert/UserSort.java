package ru.job4j.convert;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс сортировки юзеров.
 */
public class UserSort {
    /**
     * Метод сортировки.
     * @param unsortedUsers Последовательность юзеров.
     * @return Сортированное Множество юзеров.
     */
    public Set<User> sort(List<User> unsortedUsers) {

        Set<User> sortedUsers = new TreeSet<>();
        sortedUsers.addAll(unsortedUsers);

        return sortedUsers;
    }
}
