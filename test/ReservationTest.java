import org.junit.jupiter.api.Test;
import sample.models.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationTest {

    @Test
    void calculateCost() {
        Hotel hotel = new Hotel();
        Room room = new Room(true, false, hotel);
        Guest guest = new Guest("Aad","Haanstra","AadHaanstra@gmail.com","abc123", 20);
        Reservation reservation = new Reservation(guest, room, false, 5);
        assertEquals(25,reservation.calculateCost());
        room.setSeaView(true);
        assertEquals( 40, reservation.calculateCost());
        room.setSeaView(false);
        reservation.setWithBreakfast(true);
        assertEquals(40, reservation.calculateCost());
    }

    @Test
    void calculateStayDiscount(){
        Hotel hotel = new Hotel();
        Room room = new Room(true, false, hotel);
        Guest guest = new Guest("Aad","Haanstra","AadHaanstra@gmail.com", "abc123",20);
        Reservation reservation = new Reservation(guest, room, false, 3);
        assertEquals(0, reservation.calculateStayDiscount(), 0.00001);
        reservation.setStayingLength(4);
        assertEquals(0.95, reservation.calculateStayDiscount(), 0.00001);
        reservation.setStayingLength(5);
        assertEquals(0.95, reservation.calculateStayDiscount(), 0.00001);
        reservation.setStayingLength(6);
        assertEquals(0.9, reservation.calculateStayDiscount(), 0.00001);
        reservation.setStayingLength(8);
        assertEquals(0.9, reservation.calculateStayDiscount(), 0.00001);
        reservation.setStayingLength(9);
        assertEquals(0.8, reservation.calculateStayDiscount(), 0.00001);
    }

    @Test
    void calculateTotal()
    {
        Hotel hotel = new Hotel();
        Room room = new Room(true, false, hotel);
        Guest guest = new Guest("Aad","Haanstra","AadHaanstra@gmail.com", "abc123",17);
        Reservation reservation = new Reservation(guest, room, true, 4);
        assertEquals(34.0, reservation.calculateTotal(), 0.00001);
        room.setLuxeRoom(false);
        assertEquals(20.0, reservation.calculateTotal(), 0.00001);
        guest.setAge(70);
        assertEquals(19.0, reservation.calculateTotal(), 0.00001);
        reservation.setStayingLength(6);
        guest.setAge(17);
        room.setLuxeRoom(true);
        assertEquals(32.0, reservation.calculateTotal(), 0.00001);
        reservation.setWithBreakfast(false);
        assertEquals(19.0, reservation.calculateTotal(), 0.00001);
        guest.setAge(70);
        assertEquals(18.0, reservation.calculateTotal(), 0.00001);
        reservation.setStayingLength(9);
        guest.setAge(17);
        reservation.setWithBreakfast(true);
        assertEquals(28.0, reservation.calculateTotal(), 0.00001);
        room.setLuxeRoom(false);
        assertEquals(18.0, reservation.calculateTotal(), 0.00001);
        guest.setAge(70);
        assertEquals(17.0, reservation.calculateTotal(), 0.00001);
    }
}
