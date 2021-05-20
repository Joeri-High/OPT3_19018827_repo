package models;

public class Reservation {
    private int reservationId;
    private boolean withBreakfast;
    private static int lastNumber;
    private int stayingLength;

    private Guest guest;
    private Room room;

    public Reservation(Guest guest, Room room, boolean withBreakfast, int stayingLength)
    {
        this.reservationId = ++lastNumber;
        this.guest = guest;
        this.room = room;
        this.withBreakfast = withBreakfast;
        this.stayingLength = stayingLength;
    }

    public int calculateCost()
    {
        if (room.isSeaView() || (room.isLuxeRoom() && this.withBreakfast))
        {
            return 40;
        } else {
            return 25;
        }
    }

    public double calculateStayDiscount()
    {
        double discount = 0;
        if (this.stayingLength > 3)
        {
            discount = 0.95;
        }
        if (this.stayingLength > 5)
        {
            discount = 0.9;
        }
        if(this.stayingLength > 8)
        {
            discount = 0.8;
        }
        return discount;
    }

    public double calculateTotal()
    {
        double ageDiscount = 0;
        if (guest.getAge() < 18)
        {
            ageDiscount = 0.9;
        }
        if (guest.getAge() > 65)
        {
            ageDiscount = 0.85;
        }
        int totalCost = calculateCost();
        totalCost *= calculateStayDiscount();
        totalCost *= ageDiscount;
        return totalCost;
    }


    public int getReservationId() {
        return reservationId;
    }

    public boolean isWithBreakfast() {
        return withBreakfast;
    }

    public void setWithBreakfast(boolean withBreakfast) {
        this.withBreakfast = withBreakfast;
    }

    public int getStayingLength() {
        return stayingLength;
    }

    public void setStayingLength(int stayingLength) {
        this.stayingLength = stayingLength;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
