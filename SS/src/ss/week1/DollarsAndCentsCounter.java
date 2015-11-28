package ss.week1;

public class DollarsAndCentsCounter {
	public static final int CENTS_TO_DOLLAR = 100;
	private int dollar;
	private int cent;
	
	public DollarsAndCentsCounter() {
		dollar = 0;
		cent = 0;
	}

	public int dollars() {
		return dollar;
	}
	
	public int cents() {
		return cent;
	}
	
	public void add(int dollars, int cents) {
		cent = cent + cents;
		if (cent >= CENTS_TO_DOLLAR) {
			dollar = dollar + (cent / CENTS_TO_DOLLAR);
			cent = cent % CENTS_TO_DOLLAR; 
		}
		dollar += dollars;
	}
	
	public void reset() {
		dollar = 0; cent = 0;
	}
	
	public static void main(String[] args) {
		DollarsAndCentsCounter dc = new DollarsAndCentsCounter();
		System.out.println(dc.dollars());
		dc.add(5, 60);
		System.out.println("Dollars: " + dc.dollars() + " and Cents: " + dc.cents());
		dc.add(0, 45);
		System.out.println("Dollars: " + dc.dollars() + " and Cents: " + dc.cents());
	}
	
}
