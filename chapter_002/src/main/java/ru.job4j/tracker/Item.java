package ru.job4j.tracker;


public class Item {

    private String name;
    private String description;
    private long dateOfCreation;
    private String[] arrayOfComments;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item() {

    }

    public Item(String name, String description, long dateOfCreation) {
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
    }

}
