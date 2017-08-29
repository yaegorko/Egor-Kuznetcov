package ru.job4j.profession;

/**
 * Класс Doctor наследуется от Profession.
 * @author - Egor K.
 * @since - 29.08.17
 */


public class Doctor extends Profession {
    /**
     * Специализация докторов.
     */
    private String doctorSpecialization;

    /**
     * Геттер специализаций.
     * @return специализацию.
     */

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    /**
     * Сеттер специализаций.
     * @param doctorSpecialization устанавливает специализацию.
     */
    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    /**
     * Метод проверяет может ли врач лечить детей.
     * @param colege законченный ВУЗ.
     * @param doctorSpecialization специализация врача.
     * @return строку может лечить или нет.
     */
    public String canHealChildren(String colege, String doctorSpecialization) {
        if (colege.equals("АГМА") && doctorSpecialization.equals("педиатр")) {
            return "Доктор " + this.getName() + " - " + doctorSpecialization + ", может лечить детей";
        } else {
            return "Доктор " + this.getName() + "не педиатр";
        }
    }

    /**
     * Метод проверяет может ли вылечить врач глаза у данного пациента.
     * @param person пациент.
     * @param disease болезнь, в данной проверки болезнь глаз.
     * @param colege ВУЗ
     * @param doctorSpecialization специализация.
     * @return строку может вылечить или нет.
     */
    public String canHealEyesThisPerson(Person person, Disease disease, String colege, String doctorSpecialization) {
        person.setDisease(disease);
        if (colege.equals("АГМА") && doctorSpecialization.equals("окулист") && person.getDisease().getDisease().equals("глаза")) {
            return "Доктор " + this.getName() + " может вылечить " + disease.getDisease() + " пациенту " + person.getName();
        } else {
            return "Доктор " + this.getName() + " не может вылечить " + disease.getDisease() + " пациенту " + person.getName();
        }

    }

}
