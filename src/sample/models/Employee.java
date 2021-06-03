package sample.models;

public class Employee {
    private int empNumber;
    private String firstName;
    private String lastName;

    private static int lastNumber;

    private Hotel werktBij;

    public Employee(String firstName, String lastName, Hotel hotel) {
        this.empNumber = ++lastNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.werktBij = hotel;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Hotel getWerktBij() {
        return werktBij;
    }

    public void setWerktBij(Hotel werktBij) {
        this.werktBij = werktBij;
    }
}