package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week4.math.Polynomial;
import ss.week4.math.Sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {
	
	private static final double DELTA = 1e-15;
	private Polynomial test;
	
	@Before
	public void setUp() {
		test = new Polynomial(new double[]{2, 2, 1, 1, 5, 0});
	}
	
	@Test
	public void testApply() {
		assertEquals(5, test.apply(0), DELTA);
		assertEquals(8, test.apply(1), DELTA);
		assertEquals(15, test.apply(2), DELTA);
	}
	
	@Test
	public void testDerivative() {
		assertTrue(test.derivative() instanceof Sum);
		assertEquals(1, test.derivative().apply(0), DELTA);
	}
	
	@Test
	public void testIntegrand() {
		assertTrue(test.integrand() instanceof Sum);
		assertEquals(0, test.integrand().apply(0), DELTA);
	}
	

}
