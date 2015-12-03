package ss.week4.math;

public class LinearProduct extends Product implements Integrandable {

	
	public LinearProduct(Constant fone, Function ftwo) {
		super(fone, ftwo);
	}

	@Override
	public Function derivative() {
		return new LinearProduct((Constant) one, two.derivative());
	}
	
	@Override
	public Function integrand() {
		Function result = null;
		if (two instanceof Integrandable) {
			result = new LinearProduct((Constant) one,
							(Function) (((Integrandable) two).integrand()));
		}
		return result;
	}

}
