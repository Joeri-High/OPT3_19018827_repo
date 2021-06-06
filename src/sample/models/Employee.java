package sample.models;

public class Employee extends Person {
    private int salary;
    private Hotel hotel;

    public Employee(String firstName, String lastName, String emailAdres, String passWord, int age, int salary) {
        super(firstName, lastName, emailAdres, passWord, age);
        this.salary = salary;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}