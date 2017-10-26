package ru.job4j.generic;

public abstract class Base {

    private String id;

    public String getBody() {
        return body;
    }

    private String body;

    public Base(String id) {
        this.id = id;
    }

    public Base(String id, String body) {
        this.id = id;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
