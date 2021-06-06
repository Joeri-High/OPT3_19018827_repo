package sample.models;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAdres;
    private String passWord;
    private int age;
    private static int lastNumber;

    public Person(String firstName, String lastName, String emailAdres, String passWord, int age)
    {
        this.id = ++lastNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdres = emailAdres;
        this.passWord = passWord;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public void setEmailAdres(String emailAdres) {
        this.emailAdres = emailAdres;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
