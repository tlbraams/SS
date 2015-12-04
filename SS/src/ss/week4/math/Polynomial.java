package ss.week4.math;

public class Polynomial implements Function, Integrandable {

	private LinearProduct[] polynomial;
	
	public Polynomial(double[] parts) {
		polynomial = new LinearProduct[parts.length / 2];
		for (int i = 0; i < (parts.length / 2); i++) {
			polynomial[i] = new LinearProduct(new Constant(parts[i * 2]),
					new Exponent((int) parts[(i * 2) + 1]));
		}
	}

	
	@Override
	public double apply(double argument) {
		double result = 0;
		for (int i = 0; i < polynomial.length; i++) {
			result += polynomial[i].apply(argument);
		}
		return result;
	}

	@Override
	public Function derivative() {
		Sum result = new Sum(polynomial[0].derivative(), polynomial[1].derivative());
		for (int i = 2; i < polynomial.length; i++) {
			result = new Sum(result, polynomial[i].derivative());
		}
		return result;
	}
	
	@Override
	public Function integrand() {
		Sum result = new Sum(polynomial[0].integrand(), polynomial[1].integrand());
		for (int i = 2; i < polynomial.length; i++) {
			result = new Sum(result, polynomial[i].integrand());
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = polynomial[0].toString();
		for (int i = 1; i < polynomial.length; i++) {
			result += " + " + polynomial[i].toString();
		}
		return result;
	}

}
