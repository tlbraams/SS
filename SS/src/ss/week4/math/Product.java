package ss.week4.math;

public class Product implements Function {
	
	private Function one;
	private Function two;
	
	public Product(Function first, Function second) {
		one = first;
		two = second;
	}

	@Override
	public double apply(double argument) {
		return one.apply(argument) * two.apply(argument);
	}

	@Override
	public Function derivative() {
		return new Sum(new Product(one.derivative(), two), new Product(two.derivative(), one));
	}

}
