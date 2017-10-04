package ru.job4j.convert;

/**
 * User.
 */
public class User implements Comparable<User> {
    /**
     * Id.
     */
    private Integer id;
    /**
     * Name.
     */
    private String name;
    /**
     * City.
     */
    private String city;

    /**
     * Возраст.
     */
    private Integer age;

    /**
     * Getter AGE.
     * @return age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Getter Id.
     * @return ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Getter Name.
     * @return NAME.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter City.
     * @return CITY
     */
    public String getCity() {
        return city;
    }

    /**
     * Конструктор UserConvertTest.
     * @param id Ид
     * @param name Имя
     * @param city Город
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Конструктор UserSortTest.
     * @param name Имя
     * @param age Возраст.
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Переопределяем compareTo для сортировки по возрасту.
     * Если возраст у юзеров одинаков, считаем что он разный (возвращаем -1),
     * т.к в обратном случае один из нах в Set не попадет.
     * @param o предаем объект для сравнения с текущим.
     * @return отрицательное если o.age > this.age, 0 если равны, положительное если o.age < this.age
     */
    @Override
    public int compareTo(User o) {

        return this.age == o.age ? -1 : Integer.compare(this.age, o.age);
    }

//    Если хотим сортировать по имени
//    @Override
//    public int compareTo(User o) {
//        return this.name.compareTo(o.name);
//    }

    /**
     * Переопределяем туСтринг.
     * @return Имя и возраст.
     */
    @Override
    public String toString() {
        return "User{"
                + "name= '" + name + '\''
                + ", age= " + age
                + '}' + "\r\n";
    }
}
