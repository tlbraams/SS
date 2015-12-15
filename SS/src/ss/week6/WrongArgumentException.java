package ss.week6;

public class WrongArgumentException extends Exception {
	
	/**
	 * Exception serial ID.
	 */
	private static final long serialVersionUID = 3443848876327473668L;

	public WrongArgumentException() { }
	
	public WrongArgumentException(String string) {
		super(string);
	}

}
