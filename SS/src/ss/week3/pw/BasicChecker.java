package ss.week3.pw;

public class BasicChecker implements Checker {
	
	private static final String ACCEPTABLE_PASSWORD = "banaan";
	
	public BasicChecker() { }
	
	@Override
	public boolean acceptable(String s) {
		return s.length() >= 6 && !s.contains(" ");
	}

	@Override
	public String generatePassword() {
		return ACCEPTABLE_PASSWORD;
	}

}
