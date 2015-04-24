package p3_student;


import cmsc131PhotoLibrary.Photograph;
import cmsc131PhotoLibrary.Pixel;

/**
 * This class will be written by the Student.  It provides various
 * static methods that take a photograph and produce a copy of it with
 * various modifications.
 * 
 * See the project description for details of method implementations.
 * 
 * @author CMSC 131 Student
 *
 */
public class PhotoTools {
 
	public static Photograph copy(Photograph photo) {

		int height=photo.getHt();
		int width=photo.getWd();
		Photograph copy=new Photograph(width,height);
		for(int i=0; i<height; i++){
			for(int j=0;j<width; j++){
				Pixel original=photo.getPixel(j, i);
				Pixel copyPixel=new Pixel(original.getRed(),original.getGreen(),original.getBlue());
				copy.setPixel(j, i, copyPixel);
			}
		}
		return copy;
	}

	
	public static Photograph makeGrayscale(Photograph photo) {

		int height=photo.getHt();
		int width=photo.getWd();
		Photograph copy=new Photograph(width,height);
		for(int i=0; i<height; i++){
			for(int j=0;j<width; j++){
				Pixel original=photo.getPixel(j, i);
				int grey= (original.getRed()+original.getBlue()+original.getGreen())/3;
				Pixel copyPixel=new Pixel(grey,grey,grey);
				copy.setPixel(j, i, copyPixel);
			}
		}
		return copy;
	}

	public static Photograph striped(Photograph photo) {
		Photograph copy=copy(photo);
		for(int i=0;i<photo.getHt();i++){
			for(int j=0;j<photo.getWd();j++){
				if((i/10)%3==1){
					Pixel whitePixel=new Pixel(255,255,255);
					copy.setPixel(j, i, whitePixel);
				}
				else if((i/10)%3==2){
					Pixel blackPixel=new Pixel(0,0,0);
					copy.setPixel(j, i, blackPixel);
				}
			}
			
		}
		return copy;
	}
	
	public static Photograph isolateColor(Photograph photo, int type) {
		int height=photo.getHt();
		int width=photo.getWd();
		int red=0, green = 0, blue = 0;
		Photograph copy=new Photograph(width,height);
		for(int i=0; i<height; i++){
			for(int j=0;j<width; j++){
				Pixel original=photo.getPixel(j, i);
				if (type == 0 ) {
					red = original.getRed();
				}
				else if (type == 1 ) {
					green = original.getGreen();
				} else if (type == 2 ) {
					blue = original.getBlue();
				}
				Pixel copyPixel=new Pixel(red,green,blue);
				copy.setPixel(j, i, copyPixel);
			}
		}
		return copy;
	}

	


	public static Photograph stretched(Photograph photo, int type) {
		
		int height=photo.getHt();
		int width=photo.getWd();
		if(type==0){
			width*=2;
		}
		else if(type==1){
			height*=2;
		}
		Photograph copy=new Photograph(width,height);
		for(int i=0; i<height; i++){
			for(int j=0;j<width; j++){
				Pixel original = new Pixel(0,0,0);
				if(type==0){
				original=photo.getPixel(j/2, i);
				}
				else {
				original=photo.getPixel(j, i/2);
				}
				Pixel copyPixel=new Pixel(original.getRed(),original.getGreen(),original.getBlue());
				copy.setPixel(j, i, copyPixel);
			}
		}
		return copy;
	}

	

	public static Photograph mirrored(Photograph photo) {

		int height=photo.getHt();
		int width=photo.getWd();
		Photograph copy=new Photograph(width,height);
		for(int i=0; i<height; i++){
			for(int j=0;j<width; j++){
				Pixel original=photo.getPixel(j, i);
				Pixel copyPixel=new Pixel(original.getRed(),original.getGreen(),original.getBlue());
				copy.setPixel(width-j-1, i, copyPixel);
			}
		}
		return copy;
	}
	
	public static Photograph rotated(Photograph photo) {
		int height=photo.getHt();
		int width=photo.getWd();
		Photograph copy=new Photograph(height,width);
		for(int i=0; i<height; i++){
			for(int j=0;j<width; j++){
				Pixel original=photo.getPixel(j, i);
				Pixel copyPixel=new Pixel(original.getRed(),original.getGreen(),original.getBlue());
				copy.setPixel(i, j, copyPixel);
			}
		}
		copy=mirrored(copy);
		return copy;
	}
	
	
	public static Photograph upsideDown(Photograph photo) {
		return rotated(rotated(photo));
	}

	public static Photograph weirdCombo(Photograph photo) {
		int height=photo.getHt();
		int width=photo.getWd();
		Photograph copy=new Photograph(width*3,height);
		for(int i=0; i<height; i++){
			for(int j=0;j<width; j++){
				Pixel original=photo.getPixel(j, i);
				
				Pixel redPixel=new Pixel(original.getRed(),0,0);
				Pixel bluePixel=new Pixel(0,0,original.getBlue());
				Pixel greenPixel=new Pixel(0,original.getGreen(),0);
				copy.setPixel(j, i, redPixel);
				copy.setPixel(width+j, i, greenPixel);
				copy.setPixel(2*width+j, i, bluePixel);
			}
		}
		return copy;
	}



}
