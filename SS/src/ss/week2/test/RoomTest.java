package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.Hotel.Guest;
import ss.week2.Hotel.Room;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoomTest {
    private Guest guest;
    private Room room;

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
    @Test
    public void testGetSafe() {
    	assertTrue(room.getSafe() != null);
    }
}
