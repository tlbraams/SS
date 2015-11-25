package ss.week2;

public class ThreeWayLampEnum {

	//enumeration values voor de lamp status
	public enum State { OFF, LOW, MED, HIGH }
	//Huidige status van de lamp.
	private State status;
	
	/**
	 * constructor, intialiseer Lamp op OFF.
	 */
	/*@
	 	ensures this.getStatus() == "OFF";
	 */
	public ThreeWayLampEnum() {
		status = State.OFF;
	}
	
	// Queries:
	
	/**
	 * query om huidige status op te vragen.
	 * @return huidige status
	 */
	/*@ ensures \result == "OFF" || \result == "LOW" || \result == "MED" || \result == "HIGH"; */
	/*@ pure */ public String getStatus() {
		String result;
		switch (status) {
			case OFF:
				result = "OFF";
				break;
			case LOW:
				result = "LOW";
				break;
			case MED:
				result = "MED";
				break;
			case HIGH:
				result = "HIGH";
				break;
			default:
				result = "OFF";
		}
		return result;
	}
	
	// Commands:
	
	/**
	 * command om setting te veranderen.
	 */
	/*@
	 	ensures \old(getStatus()) == "OFF" ==> getStatus() == "LOW";
	 	ensures \old(getStatus()) == "LOW" ==> getStatus() == "MEDIUM";
	 	ensures \old(getStatus()) == "MEDIUM" ==> getStatus() == "HIGH";
	 	ensures \old(getStatus()) == "HIGH"  ==> getStatus() == "OFF";
	 */
	public void switchSetting() {
		switch (status) {
			case OFF:
				status = State.LOW;
				break;
			case LOW:
				status = State.MED;
				break;
			case MED:
				status = State.HIGH;
				break;
			case HIGH:
				status = State.OFF;
		}
	}
}
