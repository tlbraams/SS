package ss.week2.Hotel;

/**
 * Guest class with name and possible room.
 * @author Tycho
 * @version 1.0
 */
public class Guest {

	// ----- instance variables ------
	
	private String name;
	private Room room;
	
	// ----- constructor -------------
	
	/**
	 * Creates a <code>Guest</code> with the given name without a room.
	 * @param name name of the new <code>Guest</code>
	 */
	public Guest(String name) {
		this.name = name;
	}
	
	// ----- Query: -------
	
	/**
	 * returns the name of this <code>Guest</code>.
	 * @return the name
	 */
	/*@ pure */public String getName() {
		return name;
	}
	
	/**
	 * returns the current <code>Room</code> of this <code>Guest</code>.
	 * @return the <code>Room</code> of this <code>Guest</code>
	 * 			null if this <code>Guest</code> is currently roomless
	 */
	/*@ pure */public Room getRoom() {
		return room;
	}
	
	
	// ----- Commands: -------
	
	/**
	 * Assigns a <code>Room</code> to this <code>Guest</code>.
	 * @param r the <code>Room</code> to be assigned to this guest
	 * @return true if checkin succesfull
	 * 			false if checkin fails, for example if r is null
	 * 			or r is already asigned to a different guest
	 */
	public boolean checkin(Room r) {
		boolean result = false;
		if (r != null && r.getGuest() == null) {
			r.setGuest(this);
			this.room = r;
			result = true;
		}
		return result;
	}
	
	/**
	 * Removes this <code>Guest</code> from it's <code>Room</code>.
	 * @return true if checkout is succesfull
	 * 			false if unsuccesfull, for example if no room is asigned
	 */
	public boolean checkout() {
		boolean result = false;
		if (this.getRoom() != null) {
			room.setGuest(null);
			room = null;
			result = true;
		}
		return result;
	}
	/**
	 * Gives a textual description of this Guest.
	 */
	public String toString() {
		return "Guest " + this.getName();
	}
}
