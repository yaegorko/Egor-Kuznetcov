package ru.job4j.testtask;

/**
 * Класс пользователей.
 */
public class User {
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Паспорт пользователя. Уникальный.
     */
    private String passport;

    /**
     * Конструктор.
     * @param name имя.
     * @param passport паспорт.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Получить имя.
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя.
     * @param name имя.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить паспорт.
     * @return паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Установить паспорт.
     * @param passport паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Переопределяем equals для User.
     * Для равенства двух юзеров должны быть равны имена и паспорта.
     * @param o User для сравнения.
     * @return true при равенстве обоих параметров.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    /**
     * Переопределяем hashCode.
     * @return result
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
