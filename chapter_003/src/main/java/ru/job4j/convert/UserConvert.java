package ru.job4j.convert;

import java.util.HashMap;
import java.util.List;

/**
 * Класс UserConvert.
 */
public class UserConvert {
    /**
     * Метод который принимает в себя список пользователей и конвертирует его в Map.
     * с ключом Integer id и соответствующим ему User.
     * @param list лист юзеров.
     * @return Map<ID, USER>.
     */
    public HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> result = new HashMap<>();

        for (User user: list) {
            result.put(user.getId(), user);
        }

        return result;
    }
}
