package p4Utilities;


/**
 * IMPORTANT:  THIS CLASS HAS BEEN WRITTEN FOR YOU.  DO NOT MODIFY IT!
 * 
 * MyDouble objects represent floating point values.
 * The MyDouble is immutable.
 * 
 * @author Fawzi Emad & Jan Plane & Ben Bederson & Evan Golub (changed equals, extending Comparable, implemented Number)
 */
public class MyDouble extends Number implements Comparable<MyDouble>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20150317L;
	
	
	
	private final double doubleValue;
	private final static double EPSILON = .0001;
	
	/* We don't want students calling toString anywhere except while writing
	 * their own Polynomial toString method.  (Otherwise, they can convert
	 * the String to type double and bypass the "fun".) */
	@SuppressWarnings("unused")
	private static boolean toStringUsed = false;  // set to true in toString.  
								//JUnit tests will make use of this to
	                            // cause failures if student is 
	                            // illegally using toString

	/**
	 * A readily available zero value of type MyDouble
	 */
	public static MyDouble zero = new MyDouble(0);
	
	/**
	 * Returns a new MyDouble initialized to the value represented by the specified String, 
	 * as performed by the valueOf method of class Double. 
	 * @param str - the string to be parsed
	 * @return the MyDouble value represented by the string argument. 
	 * @throws NumberFormatException - if the string does not contain a parsable MyDouble.
	 */
	public static MyDouble parseDouble(String str) {
		return new MyDouble(Double.parseDouble(str));
	}
	
	/**
	 * Initializes the new MyDouble object so that it represents the value of 
	 * the parameter.
	 * @param passedDouble value to be "wrapped" in the object
	 */
	public MyDouble(double passedDouble) {
		doubleValue = passedDouble;
	}
	
	/**
	 * Copy Constructor.  Initializes the new MyDouble object so that it represents
	 * the same value as that of the parameter. 
	 * @param passedMyDouble existing MyDouble object that is being copied
	 */
	public MyDouble(MyDouble passedMyDouble) {
		doubleValue = passedMyDouble.doubleValue;
	}
	
	/**
	 * Returns the sum of the current object and the parameter.
	 * Note:  This method does not modify the current object.
	 * @param passedVal the value that serves as the second operand for the addition
	 * @return a MyDouble object that represents the sum of the current object and 
	 * the parameter
	 */
	public MyDouble add(MyDouble passedVal) {
		return new MyDouble(doubleValue + passedVal.doubleValue);
	}
	
	/**
	 * Returns the difference obtained by subtracting the parameter from the current object.
	 * Note:  This method does not modify the current object.
	 * @param passedVal the value to be subtracted
	 * @return a MyDouble object that represents the current object minus the
	 * parameter
	 */
	public MyDouble subtract(MyDouble passedVal) {
		return new MyDouble(doubleValue - passedVal.doubleValue);
	}
	
	/**
	 * Returns the product of the current object and the parameter.
	 * Note:  This method does not modify the current object.
	 * @param passedVal the value that serves as the second operand for the multiplication
	 * @return the product of the current object and the parameter
	 */
	public MyDouble multiply(MyDouble passedVal) {
		return new MyDouble(doubleValue * passedVal.doubleValue);
		
	}
	
	/**
	 * Returns the quotient obtained when dividing the current object by the parameter.
	 * Note:  This method does not modify the current object. 
	 * @param passedVal the value that serves as the divisor
	 * @return the result of dividing the current object by the parameter
	 */
	public MyDouble divide(MyDouble passedVal) {
		return new MyDouble(doubleValue / passedVal.doubleValue);
	}
	
	/**
	 * Returns a MyDouble representing the square root of the current object.
	 * Note:  This method does not modify the current object.
	 * @return the square root of the current object
	 */
	public MyDouble sqrt() {
		return new MyDouble(Math.sqrt(doubleValue));
	}
	
	/**
	 * Returns a MyDouble representing the square of the current object.
	 * Note:  This method does not modify the current object.
	 * @return the square of the current object
	 */
	public MyDouble square() {
		return new MyDouble(doubleValue * doubleValue);
	}

	/**
	 * Compares the current object to the parameter.
	 * @param passedVal the object being compared with the current object
	 * @return a negative value if the current object is less than the parameter,
	 * zero if the current object equals the parameter, a positive value if the 
	 * current object is larger than the parameter.  NOTE:  Due to the lack
	 * of precision in comparing floating point values, in cases where the two
	 * values are NEARLY equal, this method will return 0.
	 */
	public int compareTo(MyDouble passedVal) {
		if (Math.abs(doubleValue - passedVal.doubleValue) < EPSILON)
			return 0;
		else if (doubleValue < passedVal.doubleValue)
			return -1;
		else
			return 1;
	}
	
	/**
	 * Checks if the current object is equal to the parameter.  
	 * 
	 * @param passedVal the object being compared for equality with the current object
	 * @return true if the current object is equal to the parameter, false
	 * otherwise.  NOTE:  Due to the lack
	 * of precision in comparing floating point values, in cases where the two
	 * values are NEARLY equal, this method will return true.
	 */
	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			MyDouble casted = (MyDouble)other;
			return Math.abs(this.doubleValue - casted.doubleValue) < EPSILON;
		}
	}

	
	/**
	 * Checks if the current object is equal to 0. 
	 * @return true if the current object is equal to 0, false
	 * otherwise.  NOTE:  Due to the lack
	 * of precision in comparing floating point values, in cases where the
	 * value is NEARLY 0, this method will return true.
	 */
	public boolean isZero() {
		return (Math.abs(doubleValue) < EPSILON);
	}

	

	/**
	 * YOU MAY NOT CALL THIS METHOD EXCEPT WHILE YOU ARE IMPLEMENTING
	 * THE toString METHOD OF THE Complex CLASS!!
	 * 
	 * Returns a String representation of the current object.
	 * If the fractional part of the string is 0, then it is converted in 
	 * integer format.
	 *    eg: the number 23.7 is converted to the string "23.7",
	 *        but the number 23.0 is converted to the string "23"
	 */
	public String toString() {
		toStringUsed = true;
		if (((int)doubleValue) == doubleValue) {
			return (new Integer((int)doubleValue)).toString();
		} else {
			return (new Double(doubleValue)).toString();
		}
	}

	@Override
	public double doubleValue() {
		return doubleValue;
	}

	@Override
	public float floatValue() {
		return (float)doubleValue;
	}

	@Override
	public int intValue() {
		return (int)doubleValue;
	}

	@Override
	public long longValue() {
		return (long)doubleValue;
	}

	
}
