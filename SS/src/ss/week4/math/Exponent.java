package ss.week4.math;

public class Exponent implements Function, Integrandable {
	
	private int exponent;
	
	public Exponent(int exp) {
		exponent = exp;
	}

	@Override
	public double apply(double argument) {
		double result = 1;
		for (int i = 0; i < exponent; i++) {
			result = result * argument;
		}
		return result;
	}

	@Override
	public Function derivative() {
		return new LinearProduct(new Constant(exponent), new Exponent(exponent - 1));
	}
	
	@Override
	public String toString() {
		return "x^" + exponent;
	}
	
	@Override
	public Function integrand() {
		return new LinearProduct(new Constant(1.0 / (exponent + 1)), new Exponent(exponent + 1));
	}

}
