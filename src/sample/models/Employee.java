package sample.models;

public class Employee extends Person {
    private Hotel hotel;

    public Employee(String firstName, String lastName, String emailAdres, String passWord, int age) {
        super(firstName, lastName, emailAdres, passWord, age);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}