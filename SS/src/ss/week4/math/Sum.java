package ss.week4.math;

public class Sum implements Function, Integrandable {
	
	private Function one;
	private Function two;

	public Sum(Function fone, Function ftwo) {
		one = fone;
		two = ftwo;
	}
	
	@Override
	public double apply(double argument) {
		return one.apply(argument) + two.apply(argument);
	}

	@Override
	public Function derivative() {
		return new Sum(one.derivative(), two.derivative());
	}
	
	@Override
	public String toString() {
		return one.toString() + two.toString();
	}
	
	@Override
	public Function integrand() {
		Sum result = null;
		if (one instanceof Integrandable && two instanceof Integrandable) {
			result = new Sum((Function) (((Integrandable) one).integrand()),
							(Function) (((Integrandable) two).integrand()));
		}
		return result;
	}

}
