package ss.week3.pw;

public class TimedPassword extends Password {

	private static final long DEFAULT_TIME = 1000;
	private long validFor;
	private long validTime;
	
	
	// ------- Constructors: -------
	
	/**
	 * Creates a new <code>TimedPassword</code> which is valid for the
	 * 			given time.
	 * @param i is the given time in seconds
	 */
	/*@
	 	requires time > 0;
	 	ensures !this.isExpired();
	 */
	public TimedPassword(long time) {
		super();
		validFor = time * 1000;
		validTime = System.currentTimeMillis() + validFor;
	}
	
	/**
	 * Creates a new <code>TimedPassword</code> which is valid for the
	 * 			Default time.
	 */
	/*@
	 	ensures !this.isExpired();
	 */
	public TimedPassword() {
		this(DEFAULT_TIME);
	}
	
	
	// -------- Queries: ----------
	
	/**
	 * Returns true if the password is expired.
	 * @return true if expired.
	 */
	/*@ pure */ public boolean isExpired() {
		return System.currentTimeMillis() > validTime;
	}
	
	// -------- Commands: ---------
	
	/**
	 * Changes the password and resets the valid period.
	 */
	@Override
	public boolean setWord(String oldpass, String newpass) {
		boolean result = super.setWord(oldpass, newpass);
		if (result) {
			validTime = System.currentTimeMillis() + validFor;
		}
		return result;
	}
}
