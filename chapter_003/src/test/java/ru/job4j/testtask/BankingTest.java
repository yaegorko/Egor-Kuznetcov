package ru.job4j.testtask;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.OutputTest;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов методов класса Banking.
 */
public class BankingTest extends OutputTest {
    /**
     * Объект класса banking.
     */
    private Banking banking = new Banking();
    /**
     * Тестовый счет 1.
     */
    private Account accountOne = new Account(25000000, 2023456789);
    /**
     * Тестовый счет 2.
     */
    private Account accountTwo = new Account(0, 2023456788);
    /**
     * Тестовый пользователь 1.
     */
    private User userOne = new User("One", "1201456789");
    /**
     * Тестовый пользователь 2.
     */
    private User userTwo = new User("Two", "1201456710");

    final String line = System.getProperty("line.separator");

    /**
     * Тест метода checkUser.
     * проверяем наличие пользователей c одинаковыми паспортами.
     */
    @Test
    public void testCheckUser() {
        User userOneInMap = new User("One1", "1201456789");
        banking.addUser(userOne);
        banking.addUser(userOneInMap);
        String expected = String.format("Пользователь с паспортом %s уже зарегестрирован в системе.%s", userOne.getPassport(), line);
        Assert.assertEquals(expected, getOutput().toString());
        assertThat(banking.checkUser(userOne), is(true));
        assertThat(banking.checkUser(userOneInMap), is(false));
    }

    /**
     * Тест checkAccount.
     * Проверяем невозможность создания 2х одинаковых счетов.
     */
    @Test
    public void testCheckAccount() {
        banking.addUser(userOne);
        banking.addUser(userTwo);
        banking.addAccountToUser(userOne, accountOne);
        banking.addAccountToUser(userTwo, accountOne);
        String expected = String.format("%s счет уже используется в системе!%s", accountOne.getRequisites(), line);
        Assert.assertEquals(expected, getOutput().toString());
    }

    /**
     * Test addUser.
     * проверяем добавление уникальных пользователей.
     */
    @Test
    public void testAddUser() {
        banking.addUser(userOne);
        banking.addUser(userTwo);
        assertThat(banking.checkUser(userOne), is(true));
        assertThat(banking.checkUser(userTwo), is(true));
    }

    /**
     * Тест deleteUser.
     */
    @Test
    public void testDeleteUser() {
        banking.addUser(userOne);
        banking.addUser(userTwo);
        assertThat(banking.checkUser(userOne), is(true));
        banking.deleteUser(userOne);
        banking.deleteUser(userOne);
        Assert.assertEquals("Пользователя с такими данными нет в системе!" + line, getOutput().toString());
        assertThat(banking.checkUser(userOne), is(false));
        assertThat(banking.checkUser(userTwo), is(true));
    }

    /**
     * Тест addAccountToUser.
     */
    @Test
    public void testAddAccountToUser() {
        banking.addUser(userOne);
        banking.addAccountToUser(userOne, accountOne);
        Map map = banking.getUsersBankAccounts();
        List list = (List) map.get(userOne);
        assertThat(list.size(), is(2));
        Account expected = (Account) list.get(1);
        assertThat(expected.getRequisites(), is(2023456789));
    }

    /**
     * Тест deleteAccountFromUser.
     */
    @Test
    public void testDeleteAccountFromUser() {
        banking.addUser(userOne);
        banking.addAccountToUser(userOne, accountOne);
        banking.addAccountToUser(userOne, accountTwo);
        banking.deleteAccountFromUser(userOne, accountOne);
        Map map = banking.getUsersBankAccounts();
        List list = (List) map.get(userOne);
        assertThat(list.size(), is(2));
        banking.deleteAccountFromUser(userOne, accountOne);
        String expected = String.format("У пользователя нет счета %s%s", accountOne.getRequisites(), line);
        Assert.assertEquals(expected, getOutput().toString());
        banking.deleteAccountFromUser(userOne, accountTwo);
        map = banking.getUsersBankAccounts();
        list = (List) map.get(userOne);
        assertThat(list.size(), is(1));
    }

    /**
     * Тест getUserAccounts.
     */
    @Test
    public void testGetUserAccounts() {
        banking.addUser(userOne);
        banking.addAccountToUser(userOne, accountOne);
        banking.addAccountToUser(userOne, accountTwo);
        List expected = banking.getUserAccounts(userOne);
        assertThat(expected.size(), is(3));
        Account account1 = (Account) expected.get(1);
        assertThat(account1.getRequisites(), is(2023456789));
        Account account2 = (Account) expected.get(2);
        assertThat(account2.getRequisites(), is(2023456788));
    }

    /**
     * Тест перевода денег.
     */
    @Test
    public void testTransferMoney() {
        banking.addUser(userOne);
        banking.addAccountToUser(userOne, accountOne);
        banking.addUser(userTwo);
        banking.addAccountToUser(userTwo, accountTwo);
        banking.transferMoney(userOne, accountOne, userTwo, accountTwo, 20000000);
        assertThat(accountOne.getValue(), is(5000000d));
        assertThat(accountTwo.getValue(), is(20000000d));
        banking.transferMoney(userOne, accountOne, userTwo, accountTwo, 20000000);
        String expected = String.format("На счет %s переведено 2.0E7%s"
                                        + "У пользователя %s на счету %s недостаточно средств%s",
                                        accountTwo.getRequisites(), line, userOne.getName(), accountOne.getRequisites(), line);
        Assert.assertEquals(expected, getOutput().toString());
    }
}
