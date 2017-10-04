package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты сортировки юзеров.
 */
public class UserSortTest {
    /**
     * userSort.
     */
    private UserSort userSort = new UserSort();
    /**
     * usersList.
     */
    private List<User> usersList = generateUserList();

    /**
     * Генерируем ЮзерЛист из уникальных юзеров.
     * @return лист юзеров.
     */
    private List<User> generateUserList() {

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                userList.add(new User("Name" + i, 60 - i));
            } else {
                userList.add(new User("Name" + (i * i), 55 - i));
            }
        }
        return userList;
    }

    /**
     * Тест для сорта списка Юзеров по возрастанию возраста.
     * Сначала проверяем длинну сортированного множества = исходному листу.
     * Затем последовательно сравниваем возраст юзеров. Если все ок, то последний возраст будет 60лет.
     * (Первый (нулевой) из usersList)
     */
    @Test
    public void whenGenerated50UsersListWithAgeFrom60to6ThanSortAscending() {
        Set<User> usersSortSet = this.userSort.sort(this.usersList);
        assertThat(usersSortSet.size(), is(this.usersList.size()));
        int lastAge = 0;
        for (User user: usersSortSet) {
            if (user.getAge() >= lastAge) {
                lastAge = user.getAge();
            }
        }
        assertThat(lastAge, is(this.usersList.get(0).getAge()));
    }

    /**
     * Тест метода sortNameLength.
     * Сортируем список юзеров по длинне имени.
     */
    @Test
    public void whenGenerated50UsersListWithNameLengthFrom5to8ThanSortByNameLength() {

        List<User> sortedList = this.userSort.sortNameLength(this.usersList);
        int previousNameLength = 0;
        boolean marker = false;
        assertThat(sortedList.size(), is(this.usersList.size()));
        for (User user: sortedList) {
            if (user.getName().length() >= previousNameLength) {
                marker = true;
                previousNameLength = user.getName().length();
            } else {
                marker = false;
                break;
            }
        }
        assertThat(marker, is(true));
    }

    /**
     * Тест метода sortByAllFields.
     * Сортируем список юзеров сначала по имени, при равном имени по возрасту.
     */
    @Test
    public void whenGetUserListThanSortByNameAndLength() {
        ArrayList<User> unsortedList = new ArrayList<>(asList(new User("Сергей", 25),
                                                              new User("Артем", 30),
                                                              new User("Сергей", 25),
                                                              new User("Иван", 25),
                                                              new User("Иван", 20),
                                                              new User("Артем", 18)));
        List<User> sortedList = userSort.sortByAllFields(unsortedList);
        assertThat(sortedList.size(), is(unsortedList.size()));
        boolean marker = false;
        for (int i = 0; i < sortedList.size(); i++) {
            if (i % 2 == 0 || i == 0) {
                if (unsortedList.get(i).getName().equals(unsortedList.get(i + 1).getName())
                        && unsortedList.get(i).getAge() <= unsortedList.get(i + 1).getAge()) {
                    marker = true;
                } else {
                    marker = false;
                }
            }
        }
        assertThat(marker, is(true));
    }
}
