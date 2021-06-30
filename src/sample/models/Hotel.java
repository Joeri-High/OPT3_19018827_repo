package sample.models;

public class Hotel {
    private int hotelId;
    private static int lastNumber;

    public Hotel()
    {
        this.hotelId = ++lastNumber;
    }

    public int getId()
    {
        return this.hotelId;
    }
}
