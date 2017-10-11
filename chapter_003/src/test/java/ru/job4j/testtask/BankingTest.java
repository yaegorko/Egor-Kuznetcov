package ru.job4j.testtask;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.OutputTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankingTest extends OutputTest {

    private Banking banking = new Banking();
    private Account accountOne = new Account(0, 1023456789);
    private Account accountTwo = new Account(0, 1023456789);
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
}
