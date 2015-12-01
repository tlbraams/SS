package ss.week4.math;

public class Sum implements Function {
	
	private Function one;
	private Function two;

	public Sum(Function first, Function second) {
		one = first;
		two = second;
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

}
