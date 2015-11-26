package ss.week3.hotel;

import java.io.PrintStream;
import ss.week3.Format;

public class Bill {

	// ------- Nested Interface: ------
	
	public static interface Item {
		public double getAmount();
	}
	
	// ------- Variables: ------
	
	private PrintStream outStream;
	private double sum;

		
	// ------ Constructor: -----
	
	/**
	 * 
	 */
	public Bill(PrintStream theOutStream) {
		if (theOutStream != null) {
			outStream = theOutStream;
		}
	}
	
	// ------ Queries: ------
	
	/**
	 * Returns the sum of the <code>Bill</code>.
	 * @return the sum
	 */
	/*@ pure */ public double getSum() {
		return sum;
	}
	
	// ------ Commands: ------
	
	/**
	 * add an item to the Bill, if there is an output, it will be printed on the output. 
	 * @param item is the item to be added
	 */
	public void newItem(Bill.Item item) {
		sum += item.getAmount();
		if (outStream != null) {
			outStream.println(Format.printLine(item.toString(), item.getAmount()));
		}
	}
	
	/**
	 * Print the sum of the bill on the output.
	 */
	public void close() {
		if (outStream != null) {
			outStream.println(Format.printLine("Total sum: ", getSum()));
		}
	}
}
