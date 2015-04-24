package studentCode;

import java.awt.Color;
import cmsc131_GridTools.MyGrid;


public class FlagMaker {

	/*This drawExample method provided colors the grid for a flag 
	 * (one that is not the flag of any country - not any I know of anyway).
	 * The code provided here is also not a correct error flag - it is just
	 * provided to help you see how you can color in the flag you are given by
	 * the driver.
	 */
	private static void drawExample(MyGrid grid){
		grid.setColor(0, 0, Color.BLUE);
		grid.setColor(0, grid.getWd()-1, Color.BLUE);

		grid.setColor(1, 1, Color.RED);
		grid.setColor(1, grid.getWd()-2, Color.RED);

		grid.setColor(grid.getHt()-1, 0, Color.GREEN);
		grid.setColor(grid.getHt()-1, grid.getWd()-1, Color.GREEN);

		grid.setColor(grid.getHt()-2, 1, Color.YELLOW);
		grid.setColor(grid.getHt()-2, grid.getWd()-2, Color.YELLOW);
	}

	
	

	/*
	 * The following helper method is provided as an example of the ones
	 * that you will be writing.  This one specifically draws the star that
	 * is needed by the flags of Somalia and Vietnam and Senegal.  
	 * 
	 * For starters, just use it.  However, later in your project work tracing
	 * this code to see how it works might be very useful before attempting to
	 * write your own code for anything involving diagonal lines.
	 */
	private static void helperCenterStar(MyGrid grid, Color theColor) {
		int middleX = grid.getWd()/2;
		int middleY = grid.getHt()/2;
		
		//Do the left side of things
		for (int radius=0; radius<middleY-3; radius++) {
			//The left leg
			grid.setColor(middleY+radius, middleX-radius-1, theColor);
			grid.setColor(middleY+radius, middleX-radius, theColor);
			
			//The right leg
			grid.setColor(middleY+radius, middleX+radius-1, theColor);
			grid.setColor(middleY+radius, middleX+radius, theColor);
			
			//The arms
			grid.setColor(middleY, middleX+radius, theColor);
			grid.setColor(middleY, middleX-radius-1, theColor);
			
			//The head
			grid.setColor(middleY-radius, middleX-1, theColor);
			grid.setColor(middleY-radius, middleX, theColor);
		} 
	}
	
	
	
	
	/*
	 * As you start the project, you'll need to implement the following 
	 * helper method.  It needs to set the color of every position in
	 * the grid to the color passed in as the parameter.
	 */
	private static void helperSolid(MyGrid grid, Color theColor) {
		//You'll need to add code here...
		for(int i=0;i<grid.getHt();i++)
		{
			for (int j=0;j<grid.getWd();j++)
			{
				grid.setColor(i, j, theColor);
			}
		}
		
	}
	//colors the top half of the flag one color
	private static void helperUpperHalfSolid(MyGrid grid, Color theColor){
		for(int i=0; i<grid.getHt()/2;i++){
			for(int j=0; j<grid.getWd();j++){
				grid.setColor(i, j, theColor);
			}
		}
	}

	//colors the bottom half of the flag one color
	private static void helperBottomHalfSolid(MyGrid grid, Color theColor){
		for(int i=grid.getHt()/2; i<grid.getHt();i++){
			for(int j=0; j<grid.getWd();j++){
				grid.setColor(i, j, theColor);
			}
		}
	}
	
	//colors the middle of the flag one color
	private static void helperMiddleSolid(MyGrid grid, Color theColor){
		for(int i=grid.getHt()/3; i<grid.getHt()/3*2;i++){
			for(int j=0; j<grid.getWd(); j++){
				grid.setColor(i,j,theColor);
			}
		}
	}
	
	private static void helperLeftSolid(MyGrid grid, Color theColor){
		for(int i=0;i<grid.getHt();i++){
			for(int j=0;j<grid.getWd()/3;j++){
				grid.setColor(i, j, theColor);
			}
		}
	}
	private static void helperMiddleSolid2(MyGrid grid, Color theColor){
		for(int i=0;i<grid.getHt();i++){
			for(int j=grid.getWd()/3;j<grid.getWd()/3*2;j++){
				grid.setColor(i, j, theColor);
			}
		}
	}
	private static void helperRightSolid(MyGrid grid, Color theColor){
		for(int i=0;i<grid.getHt();i++){
			for(int j=grid.getWd()/3*2;j<grid.getWd();j++){
				grid.setColor(i, j, theColor);
			}
		}
	}
	private static void helperTriangle(MyGrid grid, Color theColor){
		for (int j=0; j<=grid.getHt()/2;j++){
			for(int i=j; i<grid.getHt()-j;i++){
				grid.setColor(i, j, theColor);
			}
		}
	}
	private static void helperRays(MyGrid grid, Color theColor){
		for(int i=0; i<grid.getWd(); i++){
			grid.setColor(i/2, i, theColor);
			grid.setColor(grid.getHt()-i/2-1, i, theColor);
			grid.setColor(grid.getHt()/2, i, theColor);
		}
		
		for (int j=0; j<grid.getHt(); j++) {
			grid.setColor(j, grid.getWd()/2-1, theColor);
			grid.setColor(j, grid.getWd()/2, theColor);
		}
	}
	
	private static void helperError(MyGrid grid, Color theColor) {

		grid.setColor(0, grid.getWd()-1, theColor);
		grid.setColor(grid.getHt()-1, grid.getWd()-1, theColor);
		grid.setColor(grid.getHt()-1, 0, theColor);
		grid.setColor(0, 0, theColor);
	}

	
	/*
	 * This is an example of what the draw method for a particular flag 
	 * will tend to look like.  For this example to work, you need to 
	 * implement the body of the helperSolid method above.
	 */
	private static void drawSomalia(MyGrid grid) {
		helperSolid(grid, Color.BLUE);
		helperCenterStar(grid, Color.WHITE);		
	}
	
	private static void drawVietnam(MyGrid grid){
		helperSolid(grid, Color.RED);
		helperCenterStar(grid,Color.YELLOW);
	}
	private static void drawIndonesia(MyGrid grid){
		helperUpperHalfSolid(grid, Color.RED);
		helperBottomHalfSolid(grid,Color.WHITE);
	}
	private static void drawPoland(MyGrid grid){
		helperUpperHalfSolid(grid, Color.WHITE);
		helperBottomHalfSolid(grid,Color.RED);
	}
	private static void drawEstonia(MyGrid grid){
		helperUpperHalfSolid(grid, Color.BLUE);
		helperBottomHalfSolid(grid,Color.WHITE);
		helperMiddleSolid(grid,Color.BLACK);
	}
	private static void drawBolivia(MyGrid grid){
		helperUpperHalfSolid(grid, Color.RED);
		helperBottomHalfSolid(grid,Color.GREEN);
		helperMiddleSolid(grid,Color.YELLOW);
	}
	private static void drawFrance(MyGrid grid){
		helperLeftSolid(grid, Color.BLUE);
		helperMiddleSolid2(grid,Color.WHITE);
		helperRightSolid(grid,Color.RED);
	}
	private static void drawSenegal(MyGrid grid){
		helperLeftSolid(grid, Color.GREEN);
		helperMiddleSolid2(grid,Color.YELLOW);
		helperRightSolid(grid,Color.RED);
		helperCenterStar(grid, Color.GREEN);
	}
	private static void drawBahamas(MyGrid grid){
		helperSolid(grid, Color.CYAN);
		helperMiddleSolid(grid, Color.YELLOW);
		helperTriangle(grid,Color.BLACK);
	}
	private static void drawMacedonia(MyGrid grid){
		helperSolid(grid, Color.RED);
		helperRays(grid, Color.YELLOW);
		
	}
	private static void drawError(MyGrid grid) {
		helperSolid(grid, Color.WHITE);
		helperError(grid, Color.RED);
	}
	
	
	/* The skeleton given here just calls an example flag to be put into the 
	 * grid passed as the first parameter. (note: In its current form it is
	 * ignoring the second parameter.)
	 * 
	 * You need to modify this method so that the correct flag (the one that
	 * corresponds to the country code passed as the second parameter) 
	 * is colored correctly in the grid passed in as the first parameter.
	 * Note: you can assume the grid is already created an waiting for you
	 * to put the correct colors into the correct squares.  You can also 
	 * assume that the method that calls the one you are writing here will
	 * take care of actually displaying the flag - you do not need to do 
	 * anything about that.
	 */
	public static void drawFlag(MyGrid grid, int countryCode) {
		if (countryCode==1 && grid.getHt()%2==1 && grid.getHt()>=9){
			drawSomalia(grid);
		}
		else if(countryCode==2 && grid.getHt()%2==1 && grid.getHt()>=9) {
			drawVietnam(grid);
		}
		else if(countryCode==3 && grid.getHt()%2==0){
			drawIndonesia(grid);
		}
		else if(countryCode==4 && grid.getHt()%2==0){
			drawPoland(grid);
		}
		else if(countryCode==5 && grid.getHt()%3==0){
			drawEstonia(grid);
		}
		else if(countryCode==6 && grid.getHt()%3==0){
			drawBolivia(grid);
		}
		else if(countryCode==7 && grid.getWd()%3==0){
			drawFrance(grid);
		}
		else if(countryCode==8 && grid.getWd()%3==0 && grid.getHt()%2==1 && grid.getHt()>=9){
			drawSenegal(grid);
		}
		else if(countryCode==9 && grid.getWd()%3==0){
			drawBahamas(grid);
		}
		else if(countryCode==10 && grid.getHt()%2==1 && grid.getHt()>= 8){
			drawMacedonia(grid);
		}
		else drawError(grid);
	}
}
