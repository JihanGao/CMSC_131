
public class Rational {

	//DATA FIELDS SHOULD GO UP HERE
	private int numer;
	private int denom;
	
	
	//Constructor
	public Rational(int numerIn, int denomIn) {
		numer=numerIn;
		denom=denomIn;
		
		
	}
	
	
	//Getters
	public int getNumer() {
		return numer;
	}
	
	public int getDenom() {
		return denom;
				}
	
	
	
	
	
	
	public String toString() {
		return numer +"/" +denom;
	}
	
	
	
	

	public static Rational multiply(Rational a, Rational b) {
		return new Rational(a.getNumer()*b.getNumer(),a.getDenom()*b.getDenom());
	}
	
	
	
	
	
	public Rational reciprocal() {
		return new Rational(denom , numer);
		}
	
	public Rational divide(Rational a) {
		return multiply(this,a.reciprocal());
	}
	
	public Rational add(Rational a) {
		int addNumer=(this.numer*a.denom)+(this.denom*a.numer);
		int addDenom=this.denom*a.denom;
		return new Rational(addNumer,addDenom);
	
	
	//NOTE: We are not writing an equals method for this class at this time.
	//      For this reason, do not use assertEquals to try to test whether
	//      two Rational objects are equal in value.
	}
}
