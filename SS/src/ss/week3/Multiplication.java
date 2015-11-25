package ss.week3;

public class Multiplication implements OperatorWithIdentity {

	public static final int NEUTRAL_IDENTITY_MULTIPLICATION = 1;
	private int identity;
	
	public Multiplication() {
		identity = NEUTRAL_IDENTITY_MULTIPLICATION;
	}
	@Override
	public int operate(int left, int right) {
		return left * right;
	}

	@Override
	public int identity() {
		return identity;
	}

}
