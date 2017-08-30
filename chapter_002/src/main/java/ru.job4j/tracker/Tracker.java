package ru.job4j.tracker;

public class Tracker {

    private Item[] items = new Item[100];


    public Item add(Item item){
        return item;
    }

    public void update(Item item) {

    }

    public void delete(Item item){

    }
    public Item[] findAll(){
        return this.items;
    }

    public Item[] findByName(String key){
        return items;
    }

    public Item findById(String id) {
        return new Item();
    }
}
