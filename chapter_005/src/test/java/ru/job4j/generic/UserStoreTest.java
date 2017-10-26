package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    UserStore userStore = new UserStore(50);

    @Test
    public void test1() {
        userStore.add(new User("1"));
        userStore.add(new User("2"));
        userStore.add(new User("3"));
        assertThat(userStore.delete("2"), is(true));

    }

    @Test
    public void test2() {
        assertThat(userStore.delete("2"), is(false));
    }

    @Test
    public void test3() {
        User userOne = new User("1", "body1");
        userStore.add(userOne);
        assertThat(userStore.getUsers().get(0), is(userOne));
        User userOneUpdate = new User("1", "body11");
        userStore.update(userOneUpdate);
        assertThat(userStore.getUsers().get(0), is(userOneUpdate));
    }

}