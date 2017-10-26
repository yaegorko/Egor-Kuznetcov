package ru.job4j.generic;

/**
 * Хранилище ролей.
 */
public class RoleStore extends AbstractStore {
    /**
     * Хранилище SimpleArray для ролей.
     */
    private SimpleArray roles;

    /**
     * Получить хранилище ролей.
     * @return roles
     */
    public SimpleArray getRoles() {
        return this.roles;
    }

    /**
     * Конструктор, устанавливаем размер хранилища roles при создании RoleStore.
     * @param size размер
     */
    public RoleStore(int size) {
        this.roles = new SimpleArray(size);
    }

    /**
     * Добавить Role в хранилище roles.
     * @param model объект.
     * @return добавленную роль.
     */
    @Override
    public Base add(Base model) {
        this.roles.add(model);
        return (Base) this.roles.get(this.roles.getIndex());
    }

    /**
     * Обновить Role в хранилище.
     * @param model новый объект со старым Id.
     * @return обновленный Role.
     */
    @Override
    public Base update(Base model) {
        int position = checkPositionByID(this.roles, model.getId());
        if (position >= 0) {
            this.roles.update(position, model);
            return (Base) this.roles.get(position);
        } else {
            throw new NoOneElementsInStoreWithSameIDException();
        }
    }

    /**
     * Удалить Role из хранилища.
     * @param id Id объекта для удаления.
     * @return true если Role удален, false если не найден.
     */
    @Override
    public boolean delete(String id) {
        int position = checkPositionByID(this.roles, id);
        if (position >= 0) {
            this.roles.delete(position);
            return true;
        } else {
            return false;
        }
    }
}
