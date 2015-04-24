package p4Student;
import p4Utilities.MyDouble;

public class Complex 	{

	//STUDENTS:  You may NOT add any further instance or static fields!
	//These two fields will be final so must be initialized by the constructors.
	private MyDouble real;
	private MyDouble imag;


	/* STUDENTS: Put your methods here, as described in the project description.
	 * 	 
	 * IMPORTANT:  You may NOT call the toString method for the MyDouble class except
	 * while you are writing the toString method for the Complex class.  You may NOT
	 * call the toString method of the Complex class ANYWHERE.  If you don't adhere
	 * to this rule, you will fail some (or possibly all) release tests. */


	public Complex (MyDouble realIn, MyDouble imagIn) {
		real=realIn;
		imag=imagIn;
		numberCreated++;
	}

	public Complex (MyDouble realIn) {

		this(realIn,new MyDouble(0));

	}

	public Complex (Complex orig) {
		this(orig.real,orig.imag);
		
	}


	public MyDouble getReal () {
		return real;
	}

	public MyDouble getImag () {
		return imag;
	}

	public Complex add (Complex param) {
		return new Complex(real.add(param.real),imag.add(param.imag));
	}

	public Complex subtract (Complex param) {
		
		return new Complex(real.subtract(param.real),imag.subtract(param.imag));
	}

	//multiply each coefficient of myDouble by the others, then sum the corresponding parts together.
	public Complex multiply (Complex param) {
		
		//a*c
		MyDouble realTimesReal = this.real.multiply(param.real);
		//b*d
		MyDouble imagTimesImag = this.imag.multiply(param.imag);
		//a*d
		MyDouble realTimesImag = this.real.multiply(param.imag);
		//b*c
		MyDouble imagTimesReal = this.imag.multiply(param.real);
		//ac-bd
		MyDouble realPart = realTimesReal.subtract(imagTimesImag);
		//bc+ad
		MyDouble imagPart = realTimesImag.add(imagTimesReal);
		
		//(a+b*i) * (c + d*i) = ac - bd + (ad + bc)*i
		return new Complex(realPart,imagPart);
	}

	public Complex divide (Complex param) {
		//a*c	
		MyDouble realTimesReal=this.real.multiply(param.real);
		//b*d
		MyDouble imagTimesImag = this.imag.multiply(param.imag);				
		//b*c
		MyDouble imagTimesReal = this.imag.multiply(param.real);
		//a*d
		MyDouble realTimesImag = this.real.multiply(param.imag);
		//c^2
		MyDouble realSquare=param.real.square();
		//d^2
		MyDouble imagSquare=param.imag.square();
		//(ac+bd)/c^2+d^2)		
		MyDouble realPart=realTimesReal.add(imagTimesImag).divide(realSquare.add(imagSquare));
		//(bc-ad)/(c^2+d^2)
		MyDouble imagPart=imagTimesReal.subtract(realTimesImag).divide(realSquare.add(imagSquare));
		
		//(a+bi)/(c+di)=[(ac+bd)/c^2+d^2)]+[(bc-ad)/(c^2+d^2)]i
		return new Complex(realPart,imagPart);
	}

	
	public int compareTo (Complex param) {
		//if the two norms are equal,return 0
		if(this.norm().compareTo(param.norm())==0){
			return 0;
		}
		//if the norm is greater than the norm of the other, return -1
		else if(this.norm().compareTo(param.norm())<0){
			return -1;
		}
		//if the norm is less than the norm of the other, return 1
		else{
			return 1;
		}
	}
	



	public String toString () {
			String tostring = "";
			if (real.compareTo(MyDouble.zero) != 0) tostring += real.toString();
			if (imag.compareTo(MyDouble.zero) != 0) {
				if (imag.compareTo(MyDouble.zero) > 0 && real.compareTo(MyDouble.zero) != 0) tostring += "+" + imag.toString();
				else tostring += imag.toString();
				tostring+= "i";
			}
			return tostring;
		}




	public MyDouble norm (){
		//a^2
		MyDouble realPart=real.square();
		//b^2
		MyDouble imagPart=imag.square();
		//sqrt(a^2+b^2)
		return realPart.add(imagPart).sqrt();
	}




	public static Complex parseComplex(String St)
		{
			MyDouble imag = new MyDouble(0);
			MyDouble real = new MyDouble(0);
			St=St.replace(" ", "");
			int index;

			// C = +/-??? +/- ???
			if (St.indexOf('-', 1) > 0
					|| St.indexOf('+') >= 0)
			{
				if (St.indexOf('+') >= 0)
				{
					// C = +/-??? + ???i
					index = St.indexOf('+', 1);

					String realstring = St.substring(0, index);
					real = MyDouble.parseDouble(realstring);

					String imaginarystring = St.substring(index + 1,
							St.indexOf('i'));

					if (imaginarystring.isEmpty()) {
						// C = ??? + i
						imag = new MyDouble(1.0);
					} else {
					imag = MyDouble.parseDouble(imaginarystring);
					}
				}
				else 
				{
					// C = +/-??? - ???i

					index = St.indexOf('-', 1);

					String realstring = St.substring(0, index);
					real = MyDouble.parseDouble(realstring);

					String imaginarystring = St.substring(St.indexOf('-', 1),
							St.indexOf('i'));

					if (imaginarystring.isEmpty()) {
						// C = ??? - i
						imag = new MyDouble(-1.0);
					} else {
						imag = MyDouble.parseDouble(imaginarystring);
					}
				}
			}
			else 
			{
				// C = ???i
				if (St.indexOf('i') >= 0) {
					index = St.indexOf('i');
					St = St.replace("i", "");

					if (St.equals("-") || St.isEmpty()) {
						// C = -i or C = i
						St += "1";
					}
					imag = MyDouble.parseDouble(St);
				} else {
					// C = ???
					real = MyDouble.parseDouble(St);
				}
			}
			return new Complex(real, imag);

		
		
		
	}

	





















	//Code below is provided.  Do not change or even look at for now...

	public static long getNumberCreated() {
		return numberCreated;
	}

	

	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			Complex casted = (Complex)other;
			return this.real.equals(casted.real)&&this.imag.equals(casted.imag);
		}
	}



	private static long numberCreated = 0;




}
