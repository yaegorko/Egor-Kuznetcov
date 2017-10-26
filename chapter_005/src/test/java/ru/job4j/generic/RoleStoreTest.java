package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {

    RoleStore roleStore = new RoleStore(50);
    Role roleOne = new Role("1", "body1");
    Role roleTwo = new Role("2", "body2");
    Role roleThree = new Role("3");
    Role roleOneUpdate = new Role("1", "body11");

    @Test
    public void whenAddThreeRolesAndThanDeleteSecond() {
        roleStore.add(roleOne);
        roleStore.add(roleTwo);
        assertThat(roleStore.getRoles().get(0), is(roleOne));
        roleStore.add(roleThree);
        assertThat(roleStore.delete("2"), is(true));
        assertThat(roleStore.getRoles().get(1), is(roleThree));
    }

    @Test
    public void whenTryToDeleteNullElement() {
        assertThat(roleStore.delete("2"), is(false));
    }

    @Test
    public void whenAddRoleAndUpdateHer(){
        roleStore.add(roleOne);
        assertThat(roleStore.getRoles().get(0), is(roleOne));
        roleStore.update(roleOneUpdate);
        assertThat(roleStore.getRoles().get(0), is(roleOneUpdate));
    }
}