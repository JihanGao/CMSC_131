import java.util.Scanner;


public class Interview {

	public static void main(String[] args) {
		//Create an input scanner
		Scanner myScanner = new Scanner(System.in);

		//Prompt the user for their name and read it. Assume the name will be just ONE WORD.
		//The prompt needs to be "What is your name?" and allow the user to enter their answer
		//   on the same line as where the prompt appears.
		System.out.print("What is your name?");
		String name= myScanner.next();
		
		System.out.print("How old are you in full years?");
		int years=myScanner.nextInt();
		
		
		System.out.print("How many full months has it been since your last birthday?");
		int months=myScanner.nextInt();
		
		int totalMonths=years*12+months;
		if (totalMonths>900)
		{
		System.out.print("Greetings "+name+", your age is "+totalMonths+" months.");
		}
		else if (totalMonths<120)
		{
			System.out.print("Hello "+name+", your age is only "+totalMonths+" months.");
		}
		else
		{
			System.out.print("Howdy "+name+", you are "+totalMonths+" months old.");
		}
		
		
		
		
		

		
		
		
		

		//Prompt the user for their age in whole years and read it.
		//The prompt needs to be "How old are you in full years?" and allow the user to enter 
		//   their answer on the same line as where the prompt appears.


		
		
		

		//Ask how many full months it has been since their last birthday and read it.
		//The prompt needs to be "How many full months has it been since your last birthday?" 
		//   and allow the user to enter their answer on the same line as where the prompt 
		//   appears.

		
		
		
		

		//This closes the input scanner since you are done with it by this point.
		myScanner.close();
		
		
		//Calculate their total age in months and store this in a variable. 
	
		
		

		
		/* 
		 * Print the appropriate one of the following lines, depending on their age: 
		 *	age > 900 months, print: Greetings NAME, your age is TOTALMONTHS months. 
		 *  age < 120 months, print: Hello NAME, your age is only TOTALMONTHS months. 
		 *  any other age, print: Howdy NAME, you are TOTALMONTHS months old.
		 */

		
		
		
		
		
	}

}
