package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {

	private double safePrice;
	
	// ----- Constructors: -----
	
	/**
	 * Creates a new <code>PricedSafe</code> with the given price.
	 * @param price the price
	 */
	public PricedSafe(double price) {
		super();
		safePrice = price;
	}
	
	// ----- Queries: ------
	
	/**
	 * Gives the price of the <code>PricedSafe</code>.
	 */
	/*@ pure */ public double getAmount() {
		return safePrice;
	}
	
	/**
	 * Gives a textual representation of the price of this <code>PricedSafe</code>.
	 */
	public String toString() {
		return "Price: " + safePrice;
	}
}
