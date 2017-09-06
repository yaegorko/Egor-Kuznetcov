package ru.job4j.tracker;

public class StubInput implements Input {

    private String[] strings;
    private Tracker tracker;


    public void start() {

    }

    public void setTracker(Tracker tracker) {

    }

    public StubInput(String[] strings) {
        this.strings = strings;
    }

    public StubInput(String[] strings, Tracker tracker){
        this.strings = strings;
        this.tracker = tracker;
    }

    public void forTest(String[] strings) {
        if (this.strings[0].equals("0")) {
            tracker.add(new Item(this.strings[1], this.strings[2]));
        }
    }


}
