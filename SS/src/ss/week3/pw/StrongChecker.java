package ss.week3.pw;

public class StrongChecker extends BasicChecker {

	private static final String ACCEPTABLE_STRONG_PASSWORD = "banaan7";
	
	public StrongChecker() { }
	
	@Override
	public boolean acceptable(String s) {
		boolean result = super.acceptable(s);
		if (result) {
			result = Character.isLetter(s.charAt(0)) && Character.isDigit(s.charAt(s.length() - 1));
		}
		return result;
	}
	
	@Override
	public String generatePassword() {
		return ACCEPTABLE_STRONG_PASSWORD;
	}
}
