package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Hotel.*;


public class SafeTest {
	
	private Safe safe1;
	private Safe safe2;
	private Safe safe3;
	private Safe safe4;
	private String incorrect = "incorrect";
	

	@Before
	public void setUp() throws Exception {
		safe1 = new Safe(); //inactive & closed
		safe2 = new Safe(); //active & closed
		safe3 = new Safe(); //active & open
		safe4 = new Safe(); //inactive & open
		safe2.activate(Password.INITIAL);
		safe3.activate(Password.INITIAL);
		safe3.open(Password.INITIAL);
		safe4.activate(Password.INITIAL);
		safe4.open(Password.INITIAL);
		safe4.deactivate();
	}

	@Test
	public void testActivateCorrectPassword() {
		assertFalse(safe1.isActive());
		safe1.activate(Password.INITIAL);
		assertTrue(safe1.isActive());
	}
	
	@Test
	public void testActivateIncorrectPassword() {
		assertFalse(safe1.isActive());
		safe1.activate(incorrect);
		assertFalse(safe1.isActive());
	}
	
	@Test
	public void testActivateActiveCorrectPassword() {
		assertTrue(safe2.isActive());
		safe2.activate(Password.INITIAL);
		assertTrue(safe2.isActive());
	}
	
	@Test
	public void testActivateActiveIncorrectPassword() {
		assertTrue(safe2.isActive());
		safe2.activate(incorrect);
		assertTrue(safe2.isActive());
	}
	
	@Test
	public void testOpenDeactivatedSafeCorrect() {
		assertFalse(safe1.isActive());
		safe1.open(Password.INITIAL);
		assertFalse(safe1.isOpen());
	}
	
	@Test
	public void testOpenDeactivatedSafeIncorrect() {
		assertFalse(safe1.isActive());
		safe1.open(Password.INITIAL);
		assertFalse(safe1.isOpen());
	}
	
	@Test
	public void testOpenActiveSafeCorrect() {
		assertTrue(safe2.isActive());
		assertFalse(safe2.isOpen());
		safe2.open(Password.INITIAL);
		assertTrue(safe2.isOpen());
	}
	
	@Test
	public void testOpenActiveSafeIncorrect() {
		assertTrue(safe2.isActive());
		assertFalse(safe2.isOpen());
		safe2.open(incorrect);
		assertFalse(safe2.isOpen());
	}
	
	@Test
	public void testDeactivateActiveSafe() {
		assertTrue(safe2.isActive());
		safe2.deactivate();
		assertFalse(safe2.isActive());
	}
	
	@Test
	public void testDeactivateInactiveSafe() {
		assertFalse(safe1.isActive());
		safe1.deactivate();
		assertFalse(safe1.isActive());
	}
	
	@Test
	public void testCloseActiveOpenSafe() {
		assertTrue(safe3.isActive());
		assertTrue(safe3.isOpen());
		safe3.close();
		assertFalse(safe3.isOpen());
	}
	
	@Test
	public void testCloseActiveClosedSafe() {
		assertTrue(safe2.isActive());
		assertFalse(safe2.isOpen());
		safe2.close();
		assertFalse(safe2.isOpen());
	}
	
	@Test
	public void testCloseInactiveOpenSafe() {
		assertTrue(safe4.isOpen());
		assertFalse(safe4.isActive());
		safe4.close();
		assertFalse(safe4.isOpen());
		assertFalse(safe4.isActive());
	}
	
	@Test
	public void testCloseInactiveClosedSafe() {
		assertFalse(safe1.isActive());
		assertFalse(safe1.isOpen());
		safe1.close();
		assertFalse(safe1.isActive());
		assertFalse(safe1.isOpen());
	}
	
	/**
	openDeactivatedSafeCorrect V
	openDeactivatedSafeIncorrect V
	activateDeactivatedSafeCorrect V
	activateDeactivatedSafeIncorrect V
	activateActiveSafeCorrect V
	activateActiveSafeIncorrect V
	openActiveSafeCorrect V
	openActiveSafeIncorrect V
	deactivateActiveSafe V
	deactivadeInactiveSafe V
	closeActiveOpenSafe V
	closeActiveClosedSafe V
	closeInactiveOpenSafe V
	closeInactiveClosedSafe V
	*/
}

