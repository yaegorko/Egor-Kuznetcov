package ru.job4j.generic;

public class UserStore extends AbstractStore {

    private SimpleArray users;

    public SimpleArray getUsers() {
        return this.users;
    }

    public UserStore(int size) {
        this.users = new SimpleArray(size);
    }

    @Override
    public Base add(Base model) {
        this.users.add(model);
        return (Base) this.users.get(this.users.getIndex());
    }

    @Override
    public Base update(Base model) {
        int position = checkPositionByID(this.users, model.getId());
        if (position >= 0) {
            this.users.update(position, model);
            return (Base) this.users.get(position);
        } else {
            throw new NoOneElementsInStoreWithSameIDException();
        }
    }

    @Override
    public boolean delete(String id) {
        int position = checkPositionByID(this.users, id);
        if (position >= 0) {
            this.users.delete(position);
            return true;
        } else {
            return false;
        }
    }
}
