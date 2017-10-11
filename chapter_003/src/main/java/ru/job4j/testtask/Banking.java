package ru.job4j.testtask;

import java.util.*;

import static java.util.Arrays.asList;

public class Banking {

    public Map<User, List<Account>> getUsersBankAccounts() {
        return usersBankAccounts;
    }

    private Map<User, List<Account>> usersBankAccounts = new HashMap<>();

    public boolean checkUser(User user) {
        boolean registration = false;
        if (this.usersBankAccounts.containsKey(user)) {
            registration = true;
        }
        return registration;
    }

    public boolean checkAccount(Account account) {
        for (List<Account> accounts: usersBankAccounts.values()) {
            for (Account requisitesInAccounts : accounts) {
                if (account.getRequisites() == requisitesInAccounts.getRequisites()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkAccount(User user, Account account) {
        List<Account> accounts = usersBankAccounts.get(user);
        for (Account userAccounts : accounts) {
            if (account.getRequisites() == userAccounts.getRequisites()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkValue(Account account, double amount) {
        return account.getValue() >= amount ? true : false;
    }

    public Account generateAccount() {
        Account account = new Account();
        Random random = new Random();
        StringBuilder requisitesString = new StringBuilder().append(21474).append(random.nextInt(8)).append(random.nextInt(10))
                                    .append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10));
        int requisites = Integer.parseInt(requisitesString.toString());
        account.setRequisites(requisites);
        account.setValue(0);
        if (!checkAccount(account)) {
            generateAccount();
        }
        return account;
    }

    public void addUser(User user) {
        if (!checkUser(user)) {
            for (User users: usersBankAccounts.keySet()) {
                if (user.getPassport().equals(users.getPassport())) {
                    System.out.println(String.format("Пользователь с паспортом %s уже зарегестрирован в системе.", user.getPassport()));
                    return;
                }
            }
            this.usersBankAccounts.put(user, new ArrayList<Account>(asList(generateAccount())));
        } else {
            System.out.println("Пользователь с такими данными уже есть в системе!");
        }
    }

    public void deleteUser(User user) {
        if (checkUser(user)) {
            this.usersBankAccounts.remove(user);
        } else {
            System.out.println("Пользователя с такими данными нет в системе!");
        }
    }

    public void addAccountToUser(User user, Account account) {
        if (checkUser(user)) {
            if (checkAccount(account)) {
                ArrayList<Account> userAccounts = (ArrayList<Account>) this.usersBankAccounts.get(user);
                userAccounts.add(account);
                this.usersBankAccounts.put(user, userAccounts);
            } else {
                System.out.println(String.format("%s счет уже используется в системе!", account.getRequisites()));
            }
        } else {
            System.out.println("Пользователя с такими данными нет в системе!");
        }
    }

    public void deleteAccountFromUser(User user, Account account) {
        if (checkUser(user)) {
            if (checkAccount(user, account)) {
                ArrayList<Account> userAccounts = (ArrayList<Account>) this.usersBankAccounts.get(user);
                userAccounts.remove(account);
                this.usersBankAccounts.put(user, userAccounts);
            } else {
                System.out.println(String.format("У пользователя нет счета %s", account.getRequisites()));
            }
        } else {
            System.out.println("Пользователя с такими данными нет в системе!");
        }
    }

    public List<Account> getUserAccounts(User user) {
        List<Account> userAccounts = new ArrayList<>();
        if (checkUser(user)) {
            userAccounts = this.usersBankAccounts.get(user);
        } else {
            System.out.println("Пользователя с такими данными нет в системе!");
        }
        return userAccounts;
    }

    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        if (checkUser(srcUser)) {
            if (checkUser(dstUser)) {
                if (checkAccount(srcUser, srcAccount)) {
                    if (checkAccount(dstUser, dstAccount)) {
                        if (checkValue(srcAccount, amount)) {
                            srcAccount.setValue(srcAccount.getValue() - amount);
                            dstAccount.setValue(dstAccount.getValue() + amount);
                            System.out.println(String.format("На счет %s переведено %s", dstAccount.getRequisites(), amount));
                            return true;
                        } else {
                            System.out.println(String.format("У пользователя %s на счету %s недостаточно средств", srcUser.getName(), srcAccount.getRequisites()));
                        }
                    } else {
                        System.out.println(String.format("У пользователя %s нет счета %s", dstUser.getName(), dstAccount.getRequisites()));
                    }
                } else {
                    System.out.println(String.format("У пользователя %s нет счета %s", srcUser.getName(), srcAccount.getRequisites()));
                }
            } else {
                System.out.println(String.format("Пользователя %s нет в системе!", dstUser.getName()));
            }
        } else {
            System.out.println(String.format("Пользователя %s нет в системе!", srcUser.getName()));
        }
        return false;
    }

}
