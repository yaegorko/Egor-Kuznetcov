package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестов класса RoleStore.
 */
public class RoleStoreTest {

    private RoleStore roleStore = new RoleStore(50);
    private Role roleOne = new Role("1", "body1");
    private Role roleTwo = new Role("2", "body2");
    private Role roleThree = new Role("3");
    private Role roleOneUpdate = new Role("1", "body11");

    /**
     * Добавляем три роли и после удаляем вторую.
     */
    @Test
    public void whenAddThreeRolesAndThanDeleteSecond() {
        roleStore.add(roleOne);
        roleStore.add(roleTwo);
        assertThat(roleStore.getModels().get(1), is(roleTwo));
        roleStore.add(roleThree);
        assertThat(roleStore.delete("2"), is(true));
        assertThat(roleStore.getModels().get(1), is(roleThree));
    }

    /**
     * Пробуем удалить несуществующий элемент.
     */
    @Test
    public void whenTryToDeleteNullElement() {
        assertThat(roleStore.delete("2"), is(false));
    }

    /**
     * Заменяем элементы.
     */
    @Test
    public void whenAddRoleAndUpdateHer() {
        roleStore.add(roleOne);
        assertThat(roleStore.getModels().get(0), is(roleOne));
        roleStore.update(roleOneUpdate);
        assertThat(roleStore.getModels().get(0), is(roleOneUpdate));
    }
}