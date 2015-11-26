package ss.week3.hotel;

public class Item implements Bill.Item {

	private double amount;
	private String name;
	
	public Item(String text, double amount) {
		this.name = text;
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String toString() {
		return name;
	}
}
