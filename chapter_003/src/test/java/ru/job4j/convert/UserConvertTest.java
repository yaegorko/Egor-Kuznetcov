package ru.job4j.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов класса UserConvert.
 */
public class UserConvertTest {
    /**
     * Генерируем ЮзерЛист из уникальных юзеров.
     * @return лист юзеров.
     */
    private List<User> generateUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new User(i, "User name" + i, "City" + i));
        }
        return userList;
    }

    /**
     * Тест метода process.
     */
    @Test
    public void processTest() {
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> result = userConvert.process(generateUserList());
        for (int i = 1; i < 10; i++) {
            assertThat(result.get(i).getName(), is("User name" + i));
            assertThat(result.get(i).getCity(), is("City" + i));
        }
    }
}
