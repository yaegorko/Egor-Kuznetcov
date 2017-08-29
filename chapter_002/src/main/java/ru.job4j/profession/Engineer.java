package ru.job4j.profession;

/**
 * Класс Инженер наследуется от Профессий.
 * @author - Egor K.
 * @since - 29.08.17
 */
public class Engineer extends Profession {
    /**
     * Специализация инженеров.
     */
    private String engineerSpecialization;

    /**
     * Геттр Специализации.
     * @return Специализацию
     */
    public String getEngineerSpecialization() {
        return engineerSpecialization;
    }

    /**
     * Сеттр Специализаций.
     * @param engineerSpecialization устанавливает Специализацию.
     */
    public void setEngineerSpecialization(String engineerSpecialization) {
        this.engineerSpecialization = engineerSpecialization;
    }

    /**
     * Метод проверяет может ли инжинер разработать проект дома для клиента.
     * @param person клиент.
     * @param college ВУЗ.
     * @param engineerSpecialization Специализация.
     * @return Может или нет или хочет ли клиет проект дома.
     */
    public String makeHouseProjectsForPerson(Person person, String college, String engineerSpecialization) {
        if (person.getWishes().equals("хочет проект дома") && college.equals("АИСИ") && engineerSpecialization.equals("проектировщик")) {
            return "Инженер " + this.getName() + " может сделать проект дома для " + person.getName();
        } else if (person.getWishes().equals("хочет проект дома") || !college.equals("АИСИ") || !engineerSpecialization.equals("проектировщик")) {
            return "Инженер " + this.getName() + " не может сделать проект дома для " + person.getName();
        } else if (!person.getWishes().equals("хочет проект дома")) {
            return person.getName() + " не хочет проект дома";
        } else {
            return "что-то не то";
        }
    }

    /**
     * Метод проверки готовности инженера к пенсии.
     * @param age возраст.
     * @return готов или нет.
     */
    public String readyForPencion(int age) {
        if (age > 60) {
            return this.getName() + " готов для пенсии";
        } else {
            return this.getName() + " не готов для пенсии";
        }
    }
}
