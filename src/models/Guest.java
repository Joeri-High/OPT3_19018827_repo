package models;

public class Guest {
    private int id;
    private int age;
    private static int lastNumber;

    private Room room;

    public Guest(int age)
    {
        this.id = ++lastNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
