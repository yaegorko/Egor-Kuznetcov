package ru.job4j.generic;

public class UserStore extends AbstractStore {

    SimpleArray[] users = new SimpleArray[10];

    public Base addUser(Base newUser) {

        return newUser;
    }
}
