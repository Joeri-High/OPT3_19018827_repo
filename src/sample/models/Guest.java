package sample.models;

public class Guest extends Person {
    private Room room;

    public Guest(String firstName, String lastName, String emailAdres, String passWord, int age) {
        super(firstName, lastName, emailAdres, passWord, age);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
