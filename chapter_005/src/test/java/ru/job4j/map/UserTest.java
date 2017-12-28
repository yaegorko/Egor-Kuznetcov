package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {

    User user1 = new User("Masha", 1, new GregorianCalendar(1975, GregorianCalendar.DECEMBER, 31));
    User user2 = new User("Masha", 1, new GregorianCalendar(1975, GregorianCalendar.DECEMBER, 31));

    Map<User, Object> map = new HashMap();

    @Test
    public void whenAddTwoUsersToTheMapWithEquals() {
        map.put(user1, "Manager");
        map.put(user2, "Worker");
        System.out.println(map);
    }
}