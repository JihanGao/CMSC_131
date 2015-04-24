package studentCode;

import java.util.Scanner;

import cmsc131_GridTools.MyGrid;
/**
 *  THIS CLASS IS PROVDED FOR YOU - YOU SHOULDN'T NEED TO MAKE
 *  ANY CHANGES TO THIS FILE AT ALL.  YOU CAN USE IT TO TEST 
 *  THE drawFlag METHOD THAT YOU ARE WRITING.
 *   
 *  This driver relies on the "drawFlag" method of the "FlagMaker"
 *  class.  It prompts the user to enter information about what flag
 *  he/she would like to see and in what size.  
 *  Then it creates a MyGrid (of the appropriate size), and calls
 *  the drawFrag method of the FlagMaker class to actually draw
 *  the flag.
 */
public class ExampleDriver {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/* Get input from user about what flag to draw */
		System.out.println("Type the number corresponding to the name:  ");
		System.out.println("1 Somalia");
		System.out.println("2 Vietnam");
		System.out.println("3 Indonesia");
		System.out.println("4 Poland");
		System.out.println("5 Estonia");
		System.out.println("6 Bolivia");
		System.out.println("7 France");
		System.out.println("8 Senegal");
		System.out.println("9 Bahamas");
		System.out.println("10 Macedonia");
		System.out.print("Your choice here:");
		int choice = scanner.nextInt();
		System.out.print("Choose a size (4 or larger): ");
		int size = scanner.nextInt();
		if (size < 4 || size >30){
			size = 4;
			choice = 99;
		}
		
		/* Create drawing grid of the height requested */
		MyGrid grid = new MyGrid(size);

		/* Draw the letter on the grid */
		FlagMaker.drawFlag(grid, choice);
		scanner.close();
	}
}
