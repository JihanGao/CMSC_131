package p4Student;
import p4Utilities.MyDouble;
import p4Utilities.Constants;


public class FeatureLibrary {	
	public static boolean tooBig(Complex value){
		MyDouble real=value.getReal();
		MyDouble imag=value.getImag();
		MyDouble result;
		int i;
		// get a^3
		for (i=0;i<2;i++){
			real=real.multiply(value.getReal());
		}
		//get b^7
		for (i=0;i<6;i++){
			imag=imag.multiply(value.getImag());
		}
		result=real.add(imag);
		if (result.compareTo(Constants.BOUNDARY)>0) return true;
		else return false;
	}

	
	public static int howFar(Complex startingValue) {
		int count=0;
		Complex result=startingValue;
		//satisfy two conditions
		while (!tooBig(result)&&count<=Constants.LIMIT){
			count++;
			result=result.multiply(result).add(startingValue);
		}
		if (count>Constants.LIMIT) return -1;
		else return count;
	}		
}
