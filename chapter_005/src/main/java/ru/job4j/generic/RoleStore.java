package ru.job4j.generic;

public class RoleStore extends AbstractStore {

    private SimpleArray roles;

    public SimpleArray getRoles() {
        return this.roles;
    }

    public RoleStore(int size) {
        this.roles = new SimpleArray(size);
    }

    @Override
    public Base add(Base model) {
        this.roles.add(model);
        return (Base) this.roles.get(this.roles.getIndex());
    }

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
