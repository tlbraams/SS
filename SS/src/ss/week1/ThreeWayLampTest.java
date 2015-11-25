package ss.week1;

public class ThreeWayLampTest {

	private ThreeWayLamp lamp;
	
	public ThreeWayLampTest() {
		lamp = new ThreeWayLamp();
	}
	
	public void runTest() {
		testInitialState();
		testChange();
	}
	
	private void testInitialState() {
		System.out.println("testInitialState:");
		System.out.println("Initial state: " + lamp.getStatus());
	}
	
	private void testChange() {
		System.out.println("testChange:");
		System.out.println("Initial state: " + lamp.getStatus());
		lamp.switchSetting();
		System.out.println("After 1st change: " + lamp.getStatus());
		lamp.switchSetting();
		System.out.println("After 2nd change: " + lamp.getStatus());
		lamp.switchSetting();
		System.out.println("After 3rd change: " + lamp.getStatus());
		lamp.switchSetting();
		System.out.println("After 4th change: " + lamp.getStatus());
	}

}
