package ss.week4.math;

public class Homework {

	public static void main(String[] args) {
		Constant c1 = new Constant(2);
		Exponent e1 = new Exponent(2);
		Exponent e2 = new Exponent(1);
		Sum s1 = new Sum(c1, e1);
		LinearProduct l1 = new LinearProduct(c1, e1);
		Product p1 = new Product(l1, e2);
		Polynomial po1 = new Polynomial(new double[]{2, 2, 1, 1, 5, 0});
		Function dc1 = c1.derivative();
		Function de1 = e1.derivative();
		Function ds1 = s1.derivative();
		Function dl1 = l1.derivative();
		Function dp1 = p1.derivative();
		Function dpo1 = po1.derivative();
		Function ic1 = c1.integrand();
		Function ie1 = e1.integrand();
		Function is1 = s1.integrand();
		Function il1 = l1.integrand();
		Function ipo1 = po1.integrand();
		
	}
}
