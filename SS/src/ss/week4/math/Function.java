package ss.week4.math;

public interface Function {

	/**
	 * Executes the function to the parameter.
	 * @param argument the parameter on which the function is applied
	 */
	public double apply(double argument);
	
	/**
	 * Gives the Function object that is the derivative of the current object.
	 * @return the derivative
	 */
	public Function derivative();
	
	/**
	 * Returns a nice string representation of the function.
	 * @return the string
	 */
	public String toString();
}
