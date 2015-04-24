
public class Rational {
	private final int numer, denom;
	
	//Copy the code body from your Lab05
	public Rational(int numerIn, int denomIn) {
		if (denomIn == 0) {
			throw new ArithmeticException("Divide by Zero");
		}
			numer=numerIn;
			denom=denomIn;

	}
	
	//The new copy constructor for you to implement.
	public Rational(Rational other) {
		this(other.numer,other.denom);
		
		
	}
	
	//Copy the code body from your Lab05
	public int getNumer() {
		return numer;
	}
	
	//Copy the code body from your Lab05
	public int getDenom() {
		return denom;
	}
	
	//Copy the code body from your Lab05
	public String toString() {
		return numer +"/" +denom;
	}
	
	//Copy the code body from your Lab05
	public Rational reciprocal() {
		return new Rational(denom , numer);
	}
	
	//Copy the code body from your Lab05
	public static Rational multiply(Rational first, Rational second) {
		return new Rational(first.getNumer()*second.getNumer(),first.getDenom()*second.getDenom());
	}
	
	//Copy the code body from your Lab05
	public Rational divide(Rational otherRational) {
		return multiply(this,otherRational.reciprocal());
	}
	
	//Copy the code body from your Lab05
	public Rational add(Rational otherRational) {
		int newDenom=denom*otherRational.denom;
		return new Rational(this.numer*otherRational.denom+otherRational.numer*denom, newDenom);
	}
	
	//The new subtract method for you to implement.
	public Rational subtract(Rational otherRational) {
		int newDenom=denom*otherRational.denom;
		return new Rational(this.numer*otherRational.denom-otherRational.numer*denom,newDenom);
	}
}
