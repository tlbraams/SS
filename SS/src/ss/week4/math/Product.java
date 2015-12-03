package ss.week4.math;

public class Product implements Function {
	
	protected Function one;
	protected Function two;
	
	public Product(Function fone, Function ftwo) {
		one = fone;
		two = ftwo;
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
