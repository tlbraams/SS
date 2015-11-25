package ss.week2.Hotel;

/**
 * Hotel room with number and possibly a guest.
 * @author Arend Rensink
 * @version $Revision: 1.2 $
 */
public class Room {
    // ------------------ Instance variables ----------------

    private int number;
    private Guest guest;
    private Safe safe;

    // ------------------ Constructor ------------------------

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param no number of the new <code>Room</code>
     */
    public Room(int no) {
    	number = no;
    	safe = new Safe();
    }

    // ------------------ Queries --------------------------

    /**
     * Returns the number of this <code>Room</code>.
     */
    /*@ pure */public int getNumber() {
    	return number;
    }

    /**
     * Returns the current guest living in this <code>Room</code>.
     * @return the guest of this <code>Room</code>;
     *         <code>null</code> if this <code>Room</code> 
     *         is not currently rented
     */
    /*@ pure */public Guest getGuest() {
    	return guest;
    }
    
    /**
     * Returns the <code>Safe</code> associated with this <code>Room</code>.
     */
    /*@ pure */public Safe getSafe() {
    	return safe;
    }

    
    // ------------------ Commands --------------------------

    /**
     * Assigns a <code>Guest</code> to this <code>Room</code>.
     * @param g the next guest renting this <code>Room</code>;
     *        if <code>null</code> is passed, this <code>Room</code>
     *        is empty afterwards
     */
    public void setGuest(Guest g) {
    	guest = g;
    }
    
    /**
     * Gives a textual description of this room.
     */
    public String toString() {
    	return "Room " + this.getNumber();
    }
}
