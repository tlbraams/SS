package ss.week2;

public class Rectangle {
	private int length;
	private int width;
	
	//@ private invariant length >= 0;
	//@ private invariant width >= 0;
	
	
	// ------ Constructor ------
	/**
	 * Create a new <code>Rectangle</code> with the specified length and width.
	 * Length and width must be non-negative.
	 */
	/*@
	 	requires length >= 0;
	 	requires width >= 0;
	 	ensures this.length() == length;
	 	ensures this.width() == width;
	 */
	public Rectangle(int length, int width) {
		assert length >= 0;
		assert width >= 0;
		this.length = length;
		this.width = width;
	}
	
	// ------ Queries ------
	
	/**
	 * Gives the length of this <code>Rectangle</code>.
	 */
	/*@ pure */	public int length() {
		assert length >= 0 && width >= 0;
		return length;
	}
	
	/**
	 * Gives the width of this <code>Rectangle</code>.
	 */
	/*@ pure */	public int width() {
		assert length >= 0 && width >= 0;
		return width;
	}
	
	/**
	 * Gives the area of this <code>Rectangle</code>.
	 */
	//@ ensures \result == this.length() * this.width();
	/*@ pure */	public int area() {
		assert length >= 0 && width >= 0;
		return length() * width();
	}
	
	/**
	 * Gives the perimeter of this <code>Rectangle</code>.
	 */
	/*@ ensures \result == 2*this.length() + 2*this.width();
	 */
	/*@ pure */	public int perimeter() {
		assert length >= 0 && width >= 0;
		return 2 * length + 2 * width();
	}

}
