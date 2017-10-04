package ru.job4j.testtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Banking {

    private Map<User, List<Account>> usersBankAccounts = new HashMap<>();

    public void addUser(User user) {
        this.usersBankAccounts.put(user, new ArrayList<>(asList(user.getAccount())));
    }

    public void deleteUser(User user) {
        this.usersBankAccounts.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        this.usersBankAccounts.containsKey(user);
    }
}
