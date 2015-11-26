package ss.week3.hotel;

import ss.week3.pw.*;

public class Safe {
	
	private boolean open;
	private boolean active;
	private Password pass;
	
	//@ private invariant pass != null;
	
	// ----- Constructor: -----
	
	/**
	 * Makes a new inactive and closed safe initialised
	 * 							 with Password.INITIAL as password.
	 */
	/*
	 	ensures this.getPassword() != null;
	 	ensures !this.isActive();
	 	ensures !this.isOpen();
	 */
	public Safe() {
		this.pass = new Password();
		this.active = false;
		this.open = false;
		assert this.getPassword() != null && !this.isActive() && !this.isOpen();
	}

	// ----- Queries: -----
	
	/**
	 * Returns if the safe is active or not.
	 * @return true if active, false if inactive
	 */
	/*@ pure */ public Boolean isActive() {
		assert pass != null;
		return active;
	}
	
	/**
	 * Returns if the safe is open or not.
	 * @return true if open, false if inactive
	 */
	/*@ pure */ public boolean isOpen() {
		assert pass != null;
		return open;
	}
	
	/**
	 * Returns the password object associated with the class.
	 * @return the password object
	 */
	/*@ pure */ public Password getPassword() {
		assert pass != null;
		return pass;
	}
	
	// ----- Commands: -----
	
	/**
	 * Activates the safe if the given password is correct
	 * @param password is the password entered
	 */
	/*@
	  requires Password.acceptable(password);
	  ensures getPassword().testWord(password) ==> this.isActive();
	 */
	public void activate(String password) {
		assert pass != null;
		assert Password.acceptable(password);
		if (pass.testWord(password)) {
			active = true;
			assert this.isActive();
		}
	}
	
	/**
	 * Deactivates the safe.
	 */
	/*@
	  ensures !this.isActive();
	 */
	public void deactivate() {
		assert pass != null;
		active = false;
		assert !this.isActive();
	}
	
	/**
	 * Opens the safe if the given password is correct and the safe is active.
	 * @param password is the password entered
	 */
	/*@
	 	requires Password.acceptable(password);
	 	ensures getPassword().testWord(password) && this.isActive() ==>
	 	 															this.isOpen();
	 */
	public void open(String password) {
		assert pass != null;
		assert Password.acceptable(password);
		if (pass.testWord(password) && active) {
			open = true;
			assert this.isOpen();
		}
	}
	
	/**
	 * Closes the safe.
	 */
	/*@
	 	ensures !this.isOpen();
	 	ensures this.isActive() == \old(isActive());
	 */
	public void close() {
		assert pass != null;
		open = false;
		assert !this.isOpen();
	}
	
	public static void main(String[] args) {
		Safe safe0 = new Safe();
		safe0.activate("hoi allemaal");
		System.out.println(safe0.isActive());
	}
}
