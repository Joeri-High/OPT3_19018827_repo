package sample.models;

public class Hotel {
    private int id;
    private String naam;
    private static int lastNumber;

    public Hotel()
    {
        this.id = ++lastNumber;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
