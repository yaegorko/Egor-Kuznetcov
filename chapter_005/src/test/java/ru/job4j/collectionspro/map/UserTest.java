package ru.job4j.collectionspro.map;

import org.junit.Test;
import ru.job4j.collectionspro.map.User;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    User user1 = new User("Masha", 1, new GregorianCalendar(1975, GregorianCalendar.DECEMBER, 31));
    User user2 = new User("Masha", 1, new GregorianCalendar(1975, GregorianCalendar.DECEMBER, 31));

    Map<User, Object> map = new HashMap();

    @Test
    public void whenAddTwoUsersToTheMapWithEquals() {
        int hash1 = user1.hashCode();
        int hash2 = user2.hashCode();
        assertThat(hash1 == hash2, is(true));
        map.put(user1, "Manager");
        map.put(user2, "Worker");
        System.out.println(map);
    }
}