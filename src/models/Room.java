package models;

public class Room {
    private int roomNumber;
    private boolean luxeRoom;
    private boolean seaView;

    private static int lastNumber;

    private Hotel hotel;

    public Room(boolean luxeRoom, boolean seaView, Hotel hotel)
    {
        this.roomNumber = ++lastNumber;
        this.luxeRoom = luxeRoom;
        this.seaView = seaView;
        this.hotel = hotel;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isLuxeRoom() {
        return luxeRoom;
    }

    public void setLuxeRoom(boolean luxeRoom) {
        this.luxeRoom = luxeRoom;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
