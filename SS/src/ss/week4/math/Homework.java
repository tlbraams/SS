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
		
		System.out.println("Functions and applying a value: ");
		System.out.println("f(x) = " + c1 + ", f(2) = " + c1.apply(2));
		System.out.println("f(x) = " + e1 + ", f(2) = " + e1.apply(2));
		System.out.println("f(x) = " + s1 + ", f(2) = " + s1.apply(2));
		System.out.println("f(x) = " + l1 + ", f(2) = " + l1.apply(2));
		System.out.println("f(x) = " + p1 + ", f(2) = " + p1.apply(2));
		System.out.println("f(x) = " + po1 + ", f(2) = " + po1.apply(2));
		
		System.out.println("Differentials of the previous functions and applying a value:");
		System.out.println("f(x) = " + dc1 + ", f(2) = " + dc1.apply(2));
		System.out.println("f(x) = " + de1 + ", f(2) = " + de1.apply(2));
		System.out.println("f(x) = " + ds1 + ", f(2) = " + ds1.apply(2));
		System.out.println("f(x) = " + dl1 + ", f(2) = " + dl1.apply(2));
		System.out.println("f(x) = " + dp1 + ", f(2) = " + dp1.apply(2));
		System.out.println("f(x) = " + dpo1 + ", f(2) = " + dpo1.apply(2));
		
		System.out.println("Integrands of the first functions, where possible"
								+ " and applying a value:");
		System.out.println("f(x) = " + ic1 + ", f(2) = " + ic1.apply(2));
		System.out.println("f(x) = " + ie1 + ", f(2) = " + ie1.apply(2));
		System.out.println("f(x) = " + is1 + ", f(2) = " + is1.apply(2));
		System.out.println("f(x) = " + il1 + ", f(2) = " + il1.apply(2));
		System.out.println("f(x) = " + ipo1 + ", f(2) = " + ipo1.apply(2));
	}
}
