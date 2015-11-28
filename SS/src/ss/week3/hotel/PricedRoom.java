package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {

	private double price;
	
	// ------ Constructor: -------
	
	/**
	 * Creates a new <code>PricedRoom</code> with the given number, price and safe price.
	 * @param roomNumber the room number
	 * @param roomPrice the room price
	 * @param safePrice the safe price
	 */
	/*@
	 	ensures this.getAmount() == roomPrice;
	 	ensures this.getNumber() == roomNumber;
	 */
	public PricedRoom(int roomNumber, double roomPrice, double safePrice) {
		super(roomNumber, new PricedSafe(safePrice));
		this.price = roomPrice;
	}

	/**
	 * Gives the price of staying in this <code>PricedRoom</code> for one night.
	 */
	@Override
	/*@ pure */public double getAmount() {
		return price;
	}
	
	/**
	 * Gives a textual representation of this <code>PricedRoom</code>.
	 */
	@Override
	public String toString() {
		return "Price per night: " + price;
	}
}
