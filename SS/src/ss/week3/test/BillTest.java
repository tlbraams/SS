package ss.week3.test;

import ss.week3.hotel.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BillTest {

	private Bill item;
	private Bill bill;
	private Item item1;
	private static final double ITEM_PRICE = 0.75;
	
	@Before
	public void setUp() {
		item = new Bill(System.out);
		item1 = new Item("appel", ITEM_PRICE);
		bill = new Bill(null);
	}
	
	@Test
	public void testNewItem() {
		assertTrue(item.getSum() == 0);
		item.newItem(item1);
		assertTrue(item.getSum() == ITEM_PRICE);
	}
	
	@Test
	public void testSum() {
		item.newItem(item1);
		item.newItem(new Item("Peer", 1.25));
		assertTrue(item.getSum() == 2.0);
	}
	
	@Test
	public void testNewItemWithoutStream() {
		assertTrue(bill.getSum() == 0);
		bill.newItem(item1);
		assertTrue(bill.getSum() == ITEM_PRICE);
	}
	
	
}
