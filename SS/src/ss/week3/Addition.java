package ss.week3;

public class Addition implements OperatorWithIdentity {

	public static final int NEUTRAL_ELEMENT_ADDITION = 0;
	private int identity;
	
	public Addition() {
		identity = NEUTRAL_ELEMENT_ADDITION;
	}
	
	@Override
	public int operate(int left, int right) {
		return left + right;
	}

	@Override
	public int identity() {
		return identity;
	}

}
