package ss.week3.pw;

public interface Checker {

	/**
	 * Tests whether a string is an acceptable password.
	 * @param s the string to be tested
	 * @return true if the given string is acceptable
	 */
	public boolean acceptable(String s);
	
	/**
	 * Gives a String that is an acceptable password.
	 * @return the acceptable string
	 */
	public String generatePassword();
}
