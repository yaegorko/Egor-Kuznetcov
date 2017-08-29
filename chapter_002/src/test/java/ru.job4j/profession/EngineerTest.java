package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EngineerTest {

    @Test
    public void whenPersonWhantProjektAndEngineerCanDoIt(){
        Engineer engineer = new Engineer();
        engineer.setName("Василий");
        engineer.setColledge("АИСИ");
        engineer.setEngineerSpecialization("проектировщик");
        Person person = new Person("Ник", "хочет проект дома");
        String result = engineer.makeHouseProjectsForPerson(person, engineer.getColledge(), engineer.getEngineerSpecialization());
        String expected = "Инженер Василий может сделать проект дома для Ник";
        assertThat(result, is(expected));
    }

    @Test
    public void whenPersonWhantProjektAndEngineerHaveAnotherSpecialization() {
        Engineer engineer = new Engineer();
        engineer.setName("Василий");
        engineer.setColledge("АИСИ");
        engineer.setEngineerSpecialization("берегоукрепление");
        Person person = new Person("Ник", "хочет проект дома");
        String result = engineer.makeHouseProjectsForPerson(person, engineer.getColledge(), engineer.getEngineerSpecialization());
        String expected = "Инженер Василий не может сделать проект дома для Ник";
        assertThat(result, is(expected));
    }

    @Test
    public void whenDoNotPersonWhantProjektButEngineerCanDoIt() {
        Engineer engineer = new Engineer();
        engineer.setName("Василий");
        engineer.setColledge("АИСИ");
        engineer.setEngineerSpecialization("проектировщик");
        Person person = new Person("Ник", "не хочет проект дома");
        String result = engineer.makeHouseProjectsForPerson(person, engineer.getColledge(), engineer.getEngineerSpecialization());
        String expected = "Ник не хочет проект дома";
        assertThat(result, is(expected));
    }

}
