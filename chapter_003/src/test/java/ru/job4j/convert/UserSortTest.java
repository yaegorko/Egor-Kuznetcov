package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты сортировки юзеров.
 */
public class UserSortTest {

    /**
     * Генерируем ЮзерЛист из уникальных юзеров.
     * @return лист юзеров.
     */
    private List<User> generateUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User("User name" + i, 30 - i));
        }
        return userList;
    }

    /**
     * Тест для сорта списка Юзеров по возрастанию возоаста.
     * Сначала проверяем длинну сортированного множества = исходному листу.
     * Затем последовательно сравниваем возраст юзеров. Если все ок, то последний возраст будет 30лет.
     * (Первый (нулевой) из usersList)
     */
    @Test
    public void whenGenerated10UsersListWithAgeFrom30to21ThanSortAscending() {
        UserSort userSort = new UserSort();
        List<User> usersList = generateUserList();
        Set<User> usersSortSet = userSort.sort(usersList);
        assertThat(usersSortSet.size(), is(usersList.size()));
        int lastAge = 0;
        for (User user: usersSortSet) {
            if (user.getAge() >= lastAge) {
                lastAge = user.getAge();
            }
        }
        assertThat(lastAge, is(usersList.get(0).getAge()));
    }
}
