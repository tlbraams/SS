package ss.week1;

public class ThreeWayLamp {

	//constante voor de verschillende statusen van de Lamp.
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MED = 2;
	public static final int HIGH = 3;
	//Huidige status van de lamp.
	private int status;
	
	/**
	 * constructor, intialiseer Lamp op OFF.
	 */
	public ThreeWayLamp() {
		status = OFF;
	}
	
	// Queries:
	
	/**
	 * query om huidige status op te vragen.
	 * @return huidige status
	 */
	public String getStatus() {
		String result;
		if (status == HIGH) {
			result = "HIGH";
		} else if (status == MED) {
			result = "MEDIUM";
		} else if (status == LOW) {
			result = "LOW";
		} else {
			result = "OFF";
		}
		return result;
	}
	
	// Commands:
	
	/**
	 * command om setting te veranderen.
	 */
	public void switchSetting() {
		status = (status + 1) % 4;
	}
}
