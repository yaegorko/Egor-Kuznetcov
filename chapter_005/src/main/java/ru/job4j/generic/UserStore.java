package ru.job4j.generic;

/**
 * Хранилище Юзеров.
 */
public class UserStore extends AbstractStore {
//    /**
//     * Хранилище SimpleArray для пользователей.
//     */
//    private SimpleArray users;
//
//    /**
//     * Получить users.
//     * @return users.
//     */
//    public SimpleArray getUsers() {
//        return this.users;
//    }
//
//    /**
//     * Конструктор, устанавливаем размер хранилища users при создании UserStore.
//     * @param size размер
//     */
    public UserStore(int size) {
        super(size);
    }
//
//    /**
//     * Добавить User в хранилище users.
//     * @param model объект.
//     * @return добавленного пользователя.
//     */
//    @Override
//    public Base add(Base model) {
//        this.users.add(model);
//        return (Base) this.users.get(this.users.getIndex());
//    }
//
//    /**
//     * Обновить User в хранилище.
//     * @param model новый объект со старым Id.
//     * @return обновленный User.
//     */
//    @Override
//    public Base update(Base model) {
//        int position = checkPositionByID(this.users, model.getId());
//        if (position >= 0) {
//            this.users.update(position, model);
//            return (Base) this.users.get(position);
//        } else {
//            throw new NoOneElementsInStoreWithSameIDException();
//        }
//    }
//
//    /**
//     * Удалить User из хранилища.
//     * @param id Id объекта для удаления.
//     * @return true если User удален, false если не найден.
//     */
//    @Override
//    public boolean delete(String id) {
//        int position = checkPositionByID(this.users, id);
//        if (position >= 0) {
//            this.users.delete(position);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
