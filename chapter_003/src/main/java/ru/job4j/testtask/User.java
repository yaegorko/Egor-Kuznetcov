package ru.job4j.testtask;

public class User {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (name != null) {
                if (!name.equals(user.name)) {
                    return false;
                }
            } else {
                if (user.name != null) {
                    return false;
                }
            }
            if (passport != null) {
                if (passport.equals(user.passport)) {
                    return true;
                } else return false;
            } else {
                if (user.passport == null) {
                    return true;
                } else return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
