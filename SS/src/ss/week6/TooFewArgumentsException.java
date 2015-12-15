package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 160286419303419282L;
	
	public TooFewArgumentsException() { 
		super("Not enough arguments, must pass two command line arguments.");
	}

}
