package ss.week3.hotel;

import ss.week3.pw.*;
import java.io.PrintStream;

public class Hotel {

	//@ private invariant name != null;
	//@ private invariant password != null;
	// Name of the <code>Hotel</code>
	private String name;
	// The password object associated with the <code>Hotel</code
	private Password password;
	//@ private invariant k101 != null;
	//@ private invariant k102 != null;
	// The <code>Room</code>s of the <code>Hotel</code>
	private Room k101;
	private Room k102;
	
	
	// ----- Constructor: -----
	/**
	 * Creates a new <code>Hotel</code> with the given name
	 * @param name is the name given to the hotel
	 */
	/*@
	 	requires name != null;
	 	ensures this.getName() != null;
	 */
	public Hotel(String name) {
		assert name != null;
		this.name = name;
		password = new Password();
		k101 = new Room(101);
		k102 = new Room(102);
		assert this.getName() != null && this.getPassword() != null;
	}
	
	// ----- Queries: -----
	
	/**
	 * Returns the name of this <code>Hotel</code>.
	 * @return the name
	 */
	/*@ pure */ public String getName() {
		assert this.getName() != null && this.getPassword() != null;
		return name;
	}
	
	/**
	 * Returns an empty <code>Room</code> or null if no <code>Room</code> is available.
	 * @return an empty <code>Room</code> or null
	 */
	/*@
	  	ensures \result != null && \result.getGuest() == null ||
	  			\result == null;
	 */
	/*@ pure */public Room getFreeRoom() {
		assert this.getName() != null && this.getPassword() != null;
		Room result = null;
		if (k101.getGuest() == null) {
			result = k101;
		} else if (k102.getGuest() == null) {
			result = k102;
		}
		assert result == null ||
				(result == k101 && k101.getGuest() == null) ||
				(result == k102 && k102.getGuest() == null);
		return result;
	}
	
	/**
	 * Returns the <code>Room</code> associated with the given <code>Guest</code> name,
	 * 			or null if the <code>Guest</code> has no room.
	 * @param guestname
	 * @return The <code>Room</code> belonging to the guestname or null if he's not checked in.
	 */
	/*@
	 	ensures \result != null && \result.getGuest().getName().equals(guestname) ||
	 			\result == null;
	 */
	/*@ pure */public Room getRoom(String guestname) {
		assert this.getName() != null && this.getPassword() != null;
		Room result = null;
		if (k101.getGuest() != null && k101.getGuest().getName().equals(guestname)) {
			result = k101;
		} else if (k102.getGuest() != null &&
						k101.getGuest().getName().equals(guestname)) {
			result = k102;
		}
		assert result == null ||
				(result == k101 && k101.getGuest().getName().equals(guestname)) ||
				(result == k102 && k102.getGuest().getName().equals(guestname));
		return result;
	}
	
	/**
	 * Returns the <code>Password</code> object associated with this <code>Hotel</code>.
	 * @return the <code>Password</code> object
	 */
	/*@
	 	ensures \result != null;
	 */
	/*@ pure */public Password getPassword() {
		assert this.getName() != null && this.getPassword() != null;
		return password;
	}
	
	/**
	 * Returns a textual desctiption of all <code>Room</code>s in the <code>Hotel</code>,
	 * 		with the name of the <code>Guest</code> checked in to the <code>Room</code> and
	 * 			the state of the <code>Safe</code> associated with the <code>Room</code>.
	 */
	/*@ pure */public String toString() {
		assert this.getName() != null && this.getPassword() != null;
		String result = "Hotel " + getName() + "\n";
		result += "Room " + k101.getNumber() + ":";
		if (k101.getGuest() != null) {
			result += " is occupied by " + k101.getGuest().getName();
		}
		result += " and the safe is ";
		if (k101.getSafe().isActive()) {
			result += " active and";
		} else {
			result += " inactive and";
		}
		if (k101.getSafe().isOpen()) {
			result += " open. \n";
		} else {
			result += " closed. \n";
		}
		result += "Room " + k102.getNumber() + ":";
		if (k102.getGuest() != null) {
			result += " is occupied by " + k102.getGuest().getName();
		}
		result += " and the safe is ";
		if (k102.getSafe().isActive()) {
			result += " active and";
		} else {
			result += " inactive and";
		}
		if (k102.getSafe().isOpen()) {
			result += " open. \n";
		} else {
			result += " closed. \n";
		}
		return result;
	}
	
	// ----- Commands: -----
	
	
	/**
	 * If the given password is correct,
	 * this method returns a <code>Room</code> object with the <code>Guest</code> of the given name
	 * 		checked in.
	 * If the check in is successful the safe is activated.
	 * Returns null if the given password is incorrect or if the <code>Hotel</code> is full. 
	 * @param password is the given password
	 * @param guestname is the name of the <code>Guest</code> whishing to check in.
	 * @return a <code>Room</code> object or null.
	 */
	/*@
	 	requires Password.acceptable(pass);
	 	ensures \result != null ==> \result.getGuest().getName().equals(guestname);
	 	ensures \result == null ==> !this.getPassword().testWord(pass) ||
	 	 							this.getFreeRoom() == null ||
	 	 							getRoom(guestname) != null;
	 */
	public Room checkIn(String pass, String guestname) {
		assert this.getName() != null && this.getPassword() != null;
		Room result = null;
		if (getRoom(guestname) == null) {
			Guest guest = new Guest(guestname);
			if (this.getPassword().testWord(pass)) {
				result = this.getFreeRoom();
				guest.checkin(result);
			}
		}
		assert result == null && (!this.getPassword().testWord(pass) ||
									this.getFreeRoom() == null ||
									getRoom(guestname) != null) ||
				(result == k101 && k101.getGuest().getName().equals(guestname)) ||
				(result == k102 && k102.getClass().getName().equals(guestname));
		return result;
	}
	
	/**
	 * Checks the <code>Guest</code> with the given guestname out of it's room.
	 * The safe in the room is deactivated.
	 * If there is no guest with this name nothing happens
	 * @param guestname is name of the guest wishing to checkout
	 */
	/*@
	 	ensures \old(getRoom(guestname)).getGuest() == null;
	 	ensures !\old(getRoom(guestname).getSafe().isActive());
	 */
	public void checkOut(String guestname) {
		assert this.getName() != null && this.getPassword() != null;
		Room result = getRoom(guestname);
		if (result != null) {
			result.getGuest().checkout();
			result.getSafe().deactivate();
		}
		assert getRoom(guestname) == null && ((result != null && 
									result.getGuest() == null && !result.getSafe().isActive())
				||	result == null);
	}
	
	/**
	 * Prints a <code>Bill</code> for the number of nights the <code>Guest</code>
	 * 		stayed in the room and for the activation of the <code>Safe</code>
	 * 			if it is a PricedSafe.
	 * @param guestname the name of the <code>Guest</code>
	 * 						 for whom the <code>Bill</code> is printed.
	 * @param nights the amount of nights the <code>Guest</code> stayed.
	 * @param outStream the <code>PrintStream</code> where the <code>Bill</code> should be printed.
	 * @return the <code>Bill</code> or null if there is no <code>Guest</code> with the given name
	 * 			or the <code>Guest</code> stayed in a free room.
	 */
	public Bill getBill(String guestname, int nights, PrintStream outStream) {
		Bill result = null;
		Room kamer = getRoom(guestname);
		if (kamer != null && kamer instanceof PricedRoom) {
			result = new Bill(outStream);
			for (int i = 0; i < nights; i++) {
				result.newItem((PricedRoom) kamer);
			}
			Safe safe = kamer.getSafe();
			if (safe instanceof PricedSafe && safe.isActive()) {
				result.newItem((PricedSafe) safe);
			}	
		}
		return result;
	}
	
}
