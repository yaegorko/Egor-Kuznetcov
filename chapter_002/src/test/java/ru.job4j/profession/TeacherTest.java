package ru.job4j.profession;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класс Учитель.
 */

public class TeacherTest {
    /**
     * Создаем учителя.
     */

    private final Teacher teacher = new Teacher();
    /**
     * Создаем студента.
     */
    private final Person student = new Person("Ник", 10);

    /**
     * Может ли учитель учить ученика. Ученик - ребенок.
     */
    @Test
    public void whenPersonBefore16AndTeacherFineshedCollege() {
        teacher.setName("Иван");
        teacher.setCollege("АГПУ");
        String result = teacher.canTeachCildren(student, teacher.getCollege());
        String expected = "Учитель Иван может учить ребенка Ник";
        assertThat(result, is(expected));
    }

    /**
     * Может ли учитель учить ученика. Ученик - взрослый.
      */
    @Test
    public void whenPersonAfter16AndTeacherFineshedCollege() {
        teacher.setName("Иван");
        teacher.setCollege("АГПУ");
        student.setAge(18);
        String result = teacher.canTeachCildren(student, teacher.getCollege());
        String expected = "Ребенок Ник старше 16 лет";
        assertThat(result, is(expected));
    }

    /**
     * Учитель не закончил ВУЗ.
     */
    @Test
    public void whenTeacherNotFinishedColege() {
        teacher.setName("Иван");
        teacher.setCollege("АГПК");
        String result = teacher.canTeachCildren(student, teacher.getCollege());
        String expected = "Учитель Иван закончил " + teacher.getCollege() + " а не АГПУ";
        assertThat(result, is(expected));
    }

    /**
     * Может ли учитель преподавать математику.
     */

    @Test
    public void whenTeacherCanTeachMathematics() {
        teacher.setName("Иван");
        teacher.setCollege("АГПУ");
        teacher.setTeacherSpecialization("учитель математики");
        boolean result = teacher.canTeachMathematics(teacher.getCollege(), teacher.getTeacherSpecialization());
        assertThat(result, is(true));
    }

}