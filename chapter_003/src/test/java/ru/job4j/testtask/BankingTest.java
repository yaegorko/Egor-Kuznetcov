package ru.job4j.testtask;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.OutputTest;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankingTest extends OutputTest {

    private Banking banking = new Banking();
    private Account accountOne = new Account(25000000, 1023456789);
    private Account accountTwo = new Account(0, 1023456788);
    private Account accountTree = new Account(0, 1023456789);
    private User userOne = new User("One", "1201456789");
    private User userTwo = new User("Two", "1201456710");

    @Test
    public void testCheckUser() {
        User userOneInMap = new User("One", "1201456789");
        banking.addUser(userOneInMap);
        assertThat(banking.checkUser(userOne), is(true));
    }

    @Test
    public void testCheckAccount() {
        banking.addUser(userOne);
        banking.addUser(userTwo);
        banking.addAccountToUser(userOne, accountOne);
        banking.addAccountToUser(userTwo, accountOne);
        Assert.assertEquals("1023456789 счет уже используется в системе!\r\n", getOutput().toString());
    }

    @Test
    public void testGenerateAccount() {
        System.out.println(banking.generateAccount().getRequisites());
    }

    @Test
    public void testAddUser() {
        banking.addUser(userOne);
        banking.addUser(userTwo);
        assertThat(banking.checkUser(userOne), is(true));
        assertThat(banking.checkUser(userTwo), is(true));
    }

    @Test
    public void testDeleteUser() {
        banking.addUser(userOne);
        banking.addUser(userTwo);
        banking.deleteUser(userOne);
        banking.deleteUser(userOne);
        Assert.assertEquals("Пользователя с такими данными нет в системе!\r\n", getOutput().toString());
        assertThat(banking.checkUser(userOne), is(false));
        assertThat(banking.checkUser(userTwo), is(true));
    }

    @Test
    public void testAddAccountToUser() {
        banking.addUser(userOne);
        banking.addAccountToUser(userOne, accountOne);
        Map map = banking.getUsersBankAccounts();
        List list = (List) map.get(userOne);
        assertThat(list.size(), is(2));
        Account expected = (Account) list.get(1);
        assertThat(expected.getRequisites(), is(1023456789));
    }

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
        String expected = String.format("У пользователя нет счета %s\r\n", accountOne.getRequisites());
        Assert.assertEquals(expected, getOutput().toString());
        banking.deleteAccountFromUser(userOne, accountTwo);
        map = banking.getUsersBankAccounts();
        list = (List) map.get(userOne);
        assertThat(list.size(), is(1));
    }

    @Test
    public void testGetUserAccounts() {
        banking.addUser(userOne);
        banking.addAccountToUser(userOne, accountOne);
        banking.addAccountToUser(userOne, accountTwo);
        List list = banking.getUserAccounts(userOne);
        assertThat(list.size(), is(3));
        Account account1 = (Account) list.get(1);
        assertThat(account1.getRequisites(), is(1023456789));
        Account account2 = (Account) list.get(2);
        assertThat(account2.getRequisites(), is(1023456788));
    }

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
        String expected = String.format("На счет %s переведено 2.0E7\r\n" +
                                        "У пользователя %s на счету %s недостаточно средств\r\n",
                                        accountTwo.getRequisites(), userOne.getName(), accountOne.getRequisites());
        Assert.assertEquals(expected, getOutput().toString());
    }
}
