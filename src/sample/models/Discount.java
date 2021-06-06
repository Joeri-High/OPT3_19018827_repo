package sample.models;

public abstract class Discount {

    public Discount()
    {

    }

    public abstract int calculateCost();

    public abstract double calculateStayDiscount();

    public abstract double calculateTotal();
}
