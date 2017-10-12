package ru.job4j.testtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * Класс для операций с счетами и пользователями.
 */
public class Banking {
    /**
     * Map для хранения информации о пользователях и банковских счетах.
     */
    private Map<User, List<Account>> usersBankAccounts = new HashMap<>();

    /**
     * Получить Мапу. Использую только в тестах.
     * @return usersBankAccounts
     */
    public Map<User, List<Account>> getUsersBankAccounts() {
        return usersBankAccounts;
    }

    /**
     * Проверяем наличие или отсутствие регистрации пользователя в системе.
     * @param user пользователь
     * @return registration (true если пользователь уже есть в хранилище)
     */
    public boolean checkUser(User user) {
        boolean registration = false;
        if (this.usersBankAccounts.containsKey(user)) {
            registration = true;
        }
        return registration;
    }

    /**
     * Проверяем существование счета у всех пользователей.
     * @param account номер счета.
     * @return true если счета с таким номером еще не существут.
     */
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

    /**
     * Проверяем принадлежность счета конкретному пользователю.
     * @param user пользователь.
     * @param account номер счета.
     * @return true если счет принадлежит пользователю.
     */
    public boolean checkAccount(User user, Account account) {
        List<Account> accounts = usersBankAccounts.get(user);
        for (Account userAccounts : accounts) {
            if (account.getRequisites() == userAccounts.getRequisites()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяем достаточность денег на счету.
     * @param account номер счета для проверки.
     * @param amount необходимое количество денег для операции.
     * @return true если денег достаточно.
     */
    public boolean checkValue(Account account, double amount) {
        return account.getValue() >= amount ? true : false;
    }

    /**
     * Автоматически генерируем номер счета при создании пользователя.
     * @return готовый аккаунт с номером счета и нулевым балансом.
     */
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

    /**
     * Добавляем пользователя в систему.
     * @param user пользователь для добавления.
     */
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

    /**
     * Удаляем пользователя из системы.
     * @param user пользователь для удаления.
     */
    public void deleteUser(User user) {
        if (checkUser(user)) {
            this.usersBankAccounts.remove(user);
        } else {
            System.out.println("Пользователя с такими данными нет в системе!");
        }
    }

    /**
     * Добавляем пользователю в системе новый счет.
     * @param user пользователь в системе.
     * @param account новый счет.
     */
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

    /**
     * Удаляем счет пользователя.
     * @param user пользователь в системе у которого нужно удалить счет.
     * @param account счет для удаления.
     */
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

    /**
     * Получаем все счета пользователя.
     * @param user пользователь в системе.
     * @return ArrayList со всеми счетами пользователя.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> userAccounts = new ArrayList<>();
        if (checkUser(user)) {
            userAccounts = this.usersBankAccounts.get(user);
        } else {
            System.out.println("Пользователя с такими данными нет в системе!");
        }
        return userAccounts;
    }

    /**
     * Метод для перевода денег с одного счета на другой.
     * @param srcUser пользователь с чьего счета переводим деньги.
     * @param srcAccount счет с которого переводим деньги.
     * @param dstUser пользователь на чей счет переводим деньги.
     * @param dstAccount счет на который переводим деньги.
     * @param amount количество денег для перевода.
     * @return true если перевод успешно произведен.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {

        boolean transfer = false;

        if (!checkUser(srcUser)) {
            System.out.println(String.format("Пользователя %s нет в системе!", srcUser.getName()));
        } else if (!checkUser(dstUser)) {
            System.out.println(String.format("Пользователя %s нет в системе!", dstUser.getName()));
        } else if (!checkAccount(srcUser, srcAccount)) {
            System.out.println(String.format("У пользователя %s нет счета %s", srcUser.getName(), srcAccount.getRequisites()));
        } else if (!checkAccount(dstUser, dstAccount)) {
            System.out.println(String.format("У пользователя %s нет счета %s", dstUser.getName(), dstAccount.getRequisites()));
        } else if (!checkValue(srcAccount, amount)) {
            System.out.println(String.format("У пользователя %s на счету %s недостаточно средств", srcUser.getName(), srcAccount.getRequisites()));
        } else {
            srcAccount.setValue(srcAccount.getValue() - amount);
            dstAccount.setValue(dstAccount.getValue() + amount);
            System.out.println(String.format("На счет %s переведено %s", dstAccount.getRequisites(), amount));
            transfer = true;
        }
        return transfer;
    }
}
