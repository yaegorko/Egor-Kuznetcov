package ru.job4j.generic;

public class SimpleArray<T> {

    private Object[] objects;

    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        this.objects[this.index++] = value;
    }

    public void update(int position, T newValue) {
        this.objects[position] = newValue;
    }

    public void delete(int position) {
        if (this.objects[position] != null) {
            System.arraycopy(this.objects, position + 1, this.objects, position, this.index - position - 1);
            this.objects[this.objects.length - 1] = 0;
            this.index--;
        }
    }

    public T get(int position) {

        return (T) this.objects[position];
    }
}
