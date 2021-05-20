package models;

public class Hotel {
    private int id;
    private static int lastNumber;

    public Hotel()
    {
        this.id = ++lastNumber;
    }
}
