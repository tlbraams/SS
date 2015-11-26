package ss.week3;

public class Format {

	/**
	 * Formats a line such that first the text is written and then the amount,
	 * 				 which is aligned at the decimal dot. 
	 * @param text the text to be printed
	 * @param amount the amount to be printed
	 */
	public static String printLine(String text, double amount) {
		return String.format("%1$-10s %2$10.2f", text, amount);
	}
	
	/**
	 * Main to test the format method.
	 */
	public static void main(String[] args) {
		System.out.println(Format.printLine("text", 1));
		System.out.println(Format.printLine("other text", -12.12));
		System.out.println(Format.printLine("something", 0.2));
	}
}
