package ss.week2.test;

import ss.week2.Rectangle;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test Program for a Rectangle Class.
 * @author Tycho
 * @version 1.0
 */
public class RectangleTest {

	/** Test variabele for a <tt>Rectangle</tt>-object. */
	private Rectangle rect0;
	/** Test variabele for a <tt>Rectangle</tt>-object. */
	private Rectangle rect1;
	/** Test variabele for a <tt>Rectangle</tt>-object. */
	private Rectangle rect2;
	
	@Before
	public void setUp() {
		rect0 = new Rectangle(0, 0);
		rect1 = new Rectangle(2, 4);
		rect2 = new Rectangle(-1, -1);
	}
	
	@Test
	public void testRectangle0() {
		assertEquals(0, rect0.length());
		assertEquals(0, rect0.width());
		assertEquals(0, rect0.area());
		assertEquals(0, rect0.perimeter());
	}
	
	@Test
	public void testRectangle1() {
		assertEquals(2, rect1.length());
		assertEquals(4, rect1.width());
		assertEquals(8, rect1.area());
		assertEquals(12, rect1.perimeter());
	}
	
	@Test
	public void testRectangle2() {
		assertEquals(-1, rect2.length());
		assertEquals(-1, rect2.width());
		assertEquals(1, rect2.area());
		assertEquals(-4, rect2.perimeter());
	}
}
