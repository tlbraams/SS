package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4728342917872313964L;

	public ArgumentLengthsDifferException(int length1, int length2) {
		super("length of command line arguments differs ("
				+ length1 + ", " + length2 + ")");
	}
}
