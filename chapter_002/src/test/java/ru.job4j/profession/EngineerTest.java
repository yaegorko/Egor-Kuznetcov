package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса Инженер.
 */

public class EngineerTest {
    /**
     * Создаем инженера.
     */
    private final Engineer engineer = new Engineer();
    /**
     * Создаем клиента.
     */
    private final Person person = new Person("Ник", "хочет проект дома");

    /**
     * Клиент хочет проект, может ли инженер его сделать.
     */
    @Test
    public void whenPersonWhantProjektAndEngineerCanDoIt() {
        engineer.setName("Василий");
        engineer.setCollege("АИСИ");
        engineer.setEngineerSpecialization("проектировщик");
        String result = engineer.makeHouseProjectsForPerson(person, engineer.getCollege(), engineer.getEngineerSpecialization());
        String expected = "Инженер Василий может сделать проект дома для Ник";
        assertThat(result, is(expected));
    }

    /**
     * Клиент хочет проект, может ли инженер его сделать, специализация инженера не та!
     */
    @Test
    public void whenPersonWhantProjektAndEngineerHaveAnotherSpecialization() {
        engineer.setName("Василий");
        engineer.setCollege("АИСИ");
        engineer.setEngineerSpecialization("берегоукрепление");
        String result = engineer.makeHouseProjectsForPerson(person, engineer.getCollege(), engineer.getEngineerSpecialization());
        String expected = "Инженер Василий не может сделать проект дома для Ник";
        assertThat(result, is(expected));
    }

    /**
     * Клиент не хочет прект.
     */

    @Test
    public void whenPersonDoNotWhantProjektButEngineerCanDoIt() {
        engineer.setName("Василий");
        engineer.setCollege("АИСИ");
        engineer.setEngineerSpecialization("проектировщик");
        person.setWishes("не хочет проект дома");
        String result = engineer.makeHouseProjectsForPerson(person, engineer.getCollege(), engineer.getEngineerSpecialization());
        String expected = "Ник не хочет проект дома";
        assertThat(result, is(expected));
    }

    /**
     * Готов ли инжинер для пенсии.
     */
    @Test
    public void whenEngeenerIsReadyForPencion() {
        engineer.setName("Василий");
        engineer.setAge(61);
        String result = engineer.readyForPencion(engineer.getAge());
        String expected = "Василий готов для пенсии";
        assertThat(result, is(expected));
    }

}
