package ru.job4j.profession;

public class Engineer extends Profession {
    private String engineerSpecialization;

    public String getEngineerSpecialization() {
        return engineerSpecialization;
    }

    public void setEngineerSpecialization(String engineerSpecialization) {
        this.engineerSpecialization = engineerSpecialization;
    }


    public String makeHouseProjectsForPerson(Person person, String college, String engineerSpecialization) {
        if (person.getWishes().equals("хочет проект дома") && this.getColledge().equals("АИСИ") && this.engineerSpecialization.equals("проектировщик")) {
            return "Инженер " + this.getName() + " может сделать проект дома для " + person.getName();
        } else if (person.getWishes().equals("хочет проект дома") || !this.getColledge().equals("АИСИ") || engineerSpecialization.equals("проектировщик")) {
            return "Инженер " + this.getName() + " не может сделать проект дома для " + person.getName();
        } else if (!person.getWishes().equals("хочет проект дома")) {
            return person.getName() + " не хочет проект дома";
        } else return "что-то не то";
    }

    public String readyForPencion(int age) {
        if (age > 60){
            return this.getName() + " готов для пенсии";
        } else return this.getName() + " не готов для пенсии";
    }
}
