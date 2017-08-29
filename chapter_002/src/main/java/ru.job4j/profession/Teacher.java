package ru.job4j.profession;

/**
 * Класс Учитель наследуется от Профессий.
 * @author - Egor K.
 * @since - 29.08.17
 */

public class Teacher extends Profession {
    /**
     * специализация учителей.
     */
    private String teacherSpecialization;

    /**
     * геттр специализаций.
     * @return специализацию.
     */
    public String getTeacherSpecialization() {
        return teacherSpecialization;
    }

    /**
     * сеттр специализаций.
     * @param teacherSpecialization специализацию.
     */
    public void setTeacherSpecialization(String teacherSpecialization) {
        this.teacherSpecialization = teacherSpecialization;
    }

    /**
     * Метод может ли учитель учить даннго ребенка.
     * @param person ученик.
     * @param colege ВУЗ
     * @return строку может или нет.
     */
    public String canTeachCildren(Person person, String colege) {
        if (person.getAge() < 16 && colege.equals("АГПУ")) {
            return "Учитель " + this.getName() + " может учить ребенка " + person.getName();
        } else if (person.getAge() > 16) {
            return "Ребенок " + person.getName() + " старше 16 лет";
        } else if (!colege.equals("АГПУ")) {
            return "Учитель " + this.getName() + " закончил " + colege + " а не АГПУ";
        } else {
            return "тут что-то не то";
        }

    }

    /**
     * Может ли учитель обучать математике.
     * @param colege ВУЗ
     * @param teacherSpecialization Специализация.
     * @return тру ор фолс.
     */

    public Boolean canTeachMathematics(String colege, String teacherSpecialization) {
       return colege.equals("АГПУ") && teacherSpecialization.equals("учитель математики") ? true : false;

    }
}
