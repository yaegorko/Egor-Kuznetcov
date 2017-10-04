package ru.job4j.convert;

import java.util.Comparator;
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

    /**
     * Метод сортирующий лист User по длинне имени юзера.
     * @param listUsers начальный лист.
     * @return сортированный лист.
     */
    public List<User> sortNameLength(List<User> listUsers) {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                User u1 = (User) o1;
                User u2 = (User) o2;
                int name1 = u1.getName().length();
                int name2 = u2.getName().length();
                return Integer.compare(name1, name2);
            }
        };

        listUsers.sort(comparator);
        return listUsers;
    }

    /**
     * Метод сортирующий лист User сначала по имени, при равном имени по возрасту.
     * @param listUsers начальный лист.
     * @return сортированный лист.
     */
    public List<User> sortByAllFields(List<User> listUsers) {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                User u1 = (User) o1;
                User u2 = (User) o2;
                return u1.getName().equals(u2.getName()) ? Integer.compare(u1.getAge(), u2.getAge()) : u1.getName().compareTo(u2.getName());
            }
        };

        listUsers.sort(comparator);
        return listUsers;
    }
}
