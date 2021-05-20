import models.*;

public class Main {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Room room = new Room(true, false, hotel);
        Guest guest = new Guest(20);
    }
}
