package ss.week1;

/**
 * Password class to set/test/change a password.
 * @author Tycho
 * @version $1.0
 */
public class Password {
	
	/**
	 * The standard initial password.
	 */
	public static final String INITIAL = "banaan";
	private String pass;
	
	// ----------- Constructor: ------------
	
	/**
	 * Creates a <code>Password</code> with the Initial value.
	 */
	
	public Password() {
		pass = INITIAL;
	}
	
	// ----------- Commands: ---------------
	
	/**
	 * Tests if a given String is an acceptable password.
	 * Not acceptable is a String with less than 6 characters or a String that contains a space.
	 * @param suggestion is the String to be checked
	 * @return true if it's acceptable
	 */
	public boolean acceptable(String suggestion) {
		return suggestion.length() >= 6 && !suggestion.contains(" ");
	}
	
	/**
	 * Changes the password to a new password.
	 * @param oldpass the current password
	 * @param newpass the new password
	 * @return true if oldpass is equal to current pass and newpass is acceptable
	 */
	public boolean setWord(String oldpass, String newpass) {
		boolean result = false;
		if (testWord(oldpass)) {
			if (acceptable(newpass)) {
				pass = newpass;
				result = true;
			}
		}
		return result;
	}

	/**
	 * Tests if a given word is equal to the current password.
	 * @param test is the word to be tested
	 * @return true if test is equal to the current password
	 */
	public boolean testWord(String test) {
		return pass.equals(test);
	}
}
