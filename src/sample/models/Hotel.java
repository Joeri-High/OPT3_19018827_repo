package sample.models;

public class Hotel {
    private int hotelId;
    private String naam;
    private static int lastNumber;

    public Hotel()
    {
        this.hotelId = ++lastNumber;
    }

    public int getId()
    {
        return this.hotelId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
