package ss.week4.math;

public class Constant implements Function, Integrandable {
	
	private double constant;

	/**
	 * Creates a new Constant Function with the given value.
	 * @param constant
	 */
	public Constant(double value) {
		this.constant = value;
	}
	
	@Override
	public double apply(double argument) {
		return constant;

	}

	@Override
	public Function derivative() {
		return new Constant(0);
	}
	
	public String toString() {
		return "Value: " + constant;
	}

	@Override
	public Function integrand() {
		return new LinearProduct(this, new Exponent(1));
	}

}
