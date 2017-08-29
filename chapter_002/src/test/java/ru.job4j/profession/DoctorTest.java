package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класс Доктор.
 * @author - Egor K.
 * @since - 29.08.17
 */

public class DoctorTest {
    /**
     * Создаем болезнь.
     */
    private final Disease diseaseEyes = new Disease("глаза");
    /**
     * Создаем врача.
     */
    private final Doctor doctor = new Doctor();
    /**
     * Создаем пациента.
     */
    private final Person pacient = new Person("Ник", diseaseEyes);

    /**
     * Может ли доктор лечить детей.
     */

    @Test
    public void whenDoctorCanHealChildren() {
        doctor.setName("Хаус");
        doctor.setCollege("АГМА");
        doctor.setDoctorSpecialization("педиатр");
        String result = doctor.canHealChildren(doctor.getCollege(), doctor.getDoctorSpecialization());
        String expected = "Доктор Хаус - педиатр, может лечить детей";
        assertThat(result, is(expected));
    }

    /**
     * Может ли доктор вылечить глаза данному пациенту.
     */
    @Test
    public void whenDoctorCanHealEyesPerson() {
        doctor.setName("Хаус");
        doctor.setCollege("АГМА");
        doctor.setDoctorSpecialization("окулист");
        pacient.setName("Ник");
        String result = doctor.canHealEyesThisPerson(pacient, diseaseEyes, doctor.getCollege(), doctor.getDoctorSpecialization());
        String expected = "Доктор Хаус может вылечить глаза пациенту Ник";
        assertThat(result, is(expected));
    }
}