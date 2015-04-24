
public class NumberList {

	public int[] values;  
	
	//Constructor for an empty list (provided for you)
	public NumberList() {
		values = new int[0];
	}
	
	//Constructor passed in an array - don't just copy the reference!
	public NumberList(int[] a) {

		values=new int[a.length];
		for(int iterator=0;iterator<a.length;iterator++){
			values[iterator]=a[iterator];
		}
		
		
		
	}
	
	//Copy constructor
	//  (code provided for you but uses your array-based constructor)
		public NumberList(NumberList original) {
			this(original.values);
			

	}
	
	//Size getter
	public int getSize() {

		return values.length;
		
		
	}
	
	//Single-value getter
	public int getAt(int index) {

		//YOUR CODE HERE
			if(index<0 || index>= values.length){
				throw new IndexOutOfBoundsException("Index out of bounds");
			}
			return values[index];
	}
	
	//Process the values to get the sum
	public long getSum() {
		
		//YOUR CODE HERE
		long Sum=0;
		for(int i=0;i<values.length;i++){
			Sum+=values[i];
		}
		return Sum;
	}
	
	//See if the given value is anywhere within the array
	public boolean contains(int searchVal) {
		boolean found = false; //HINT PART 1!!!
		for (int i=0; i<values.length;i++){
			if(values[i]==searchVal){
				found=true;
			}
		}
		
		return found; //HINT PART 2!!!
	}
	
	//Add a new element at the end of the list - the array must "grow" somehow first!
	public void add(int newValue) {
		int[] newBiggerArray = new int[values.length + 1];
		//YOUR CODE HERE - THINK ABOUT HOW TO USE THE ARRAY CREATED ABOVE
		int i;
		for(i=0;i<newBiggerArray.length-1;i++){
		
			newBiggerArray[i]=values[i];
		}
		newBiggerArray[i]= newValue;
		values = newBiggerArray;
	}
}

	
	
