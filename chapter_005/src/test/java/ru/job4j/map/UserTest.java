package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {

    User user1 = new User("Masha");
    User user2 = new User("Masha");

    Map<User, Object> map = new HashMap();

    @Test
    public void whenAddTwoUsersToTheMapWithEquals() {
        map.put(user1, "Girl");
        map.put(user2, "Boy");
        System.out.println(map);
    }
}