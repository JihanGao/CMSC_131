package studentCode;


/*
 * This class is what you need to implement for this lab.
 * 
 * The Person interface has been written as have some classes that
 *   implement the interface.
 */


public class MyPersonList {
	Person[] people;
	
	
	/**
	 * Instantiates the "people" variable as a new (0-length) array of
	 * references to Person objects.
	 */
	public MyPersonList(){
		people= new Person[0];
		}
	
	
	/**
	 * A copy constructor which makes a deep copy considering that fact that
	 * a Person object is mutable.  
	 * 
	 * Also, since you don't know which of the classes that might implement 
	 * the Person interface is the type of the object being referenced in 
	 * each position, you'll want to think about how to use the copyMe() 
	 * method that the interface requires.
	 */
	public MyPersonList(MyPersonList other) {
		Person[] copyArray=new Person[other.people.length];
				for(int i=0;i<copyArray.length;i++){
					copyArray[i]=other.people[i].copyMe();
				}
				 people=copyArray;
		
	}
	
	
	/** Adds the object referenced by the parameter to the end of the list.  
	 *  You'll need to create a new array that's one space longer.  
	 *  
	 *  Note that you want to make sure that you don't just do a reference 
	 *  copy of the new-to-add Person object since it is mutable but you 
	 *  also don't want to make unnecessary copies of objects that have
	 *  already been copied into the internal list previously.
	 */
	public void addItem(Person newMember){	
		Person[] newPerson=new Person[people.length+1];
		for(int i=0;i<people.length;i++){
			newPerson[i]=people[i];
		}
		newPerson[newPerson.length-1]=newMember.copyMe();
		people=newPerson;
	}
	
	
	
	/** Gives each person in the list a raise of $1000
	 */
	public void giveRaises(){
		for(int i=0;i<people.length;i++){
			people[i].acceptRaise(1000);
		}
	}
	
	
	/** Returns the sum of the salaries of all people in the list.
	 */
	public int getTotalOfSalaries(){
		int sumOfSalary=0;
		for(int i=0;i<people.length;i++){
			sumOfSalary+=people[i].getSalary();
		}
		return sumOfSalary;
	}

	
	/** Returns the number of people in the list with a name
	 *  that matches the parameter (possibly 0 people).
	 */
	public int count(String searchName){
		int counter=0;
		for(int i=0;i<people.length;i++){
			if(people[i].getName().equals(searchName)){
				counter++;
			}
		}
		return counter;
	
	}
	
	
	
	/** Removes ALL of the people from the list whose names match the 
	 *  value referenced by the parameter (possibly more than one person).  
	 *  This should also "shrink" the array if anyone is removed but do 
	 *  so in a way that doesn't create new objects if existing ones are 
	 *  fine to use.
	 */
	public void remove(String removeName){
		Person[] aftRemove=new Person[people.length-count(removeName)];
		int counter=0;
		for(int i=0;i<people.length;i++){
			if(!(people[i].getName().equals(removeName))){
				aftRemove[counter]=people[i];
				counter++;
			}
		}
		people=aftRemove;
	}
	
}




