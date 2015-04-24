package cmsc131PhotoLibrary;

import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A photograph to be used in a photo editing application.
 * 
 * @author (c)2007, Fawzi Emad
 *
 */
public class Photograph {

	private BufferedImage img;

	/**
	 * Create a blank photo of a specified size.
	 * 
	 * @param width width of photo to be created
	 * @param height height of photo to be created
	 */
	public Photograph(int width, int height) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				setPixel(i, j, new Pixel(100, 0, 0));
			}
		}
	}

	protected Photograph(String imageLocation) {

		try {
			img = loadImage(imageLocation);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	BufferedImage getImage() {
		return img;
	}
	
	/**
	 * Access width of photo.
	 * @return width (in pixels)
	 */
	public int getWd() {
		return img.getWidth();
	}
	
	/**
	 * Access height of photo.
	 * @return height (in pixels)
	 */
	public int getHt() {
		return img.getHeight();
	}
	
	/**
	 * Access one of the Pixels in the photo. 
	 * @param x x-coordinate of desired pixel
	 * @param y y-coordinate of desired pixel
	 * @return Pixel at position (x, y) in the photograph.  Note that the origin (0, 0) is
	 * located at the upper left corner of the photo.
	 */
	public Pixel getPixel(int x, int y) {
		return new Pixel(img.getRGB(x, y));
	}

	/**
	 * Set one of the Pixels in the photo.
	 * @param x x-coordinate of the desired pixel
	 * @param y y-coordinate of the desired pixel
	 * @param p pixel to be placed at position (x, y) of the photograph.  Note that the
	 * origin (0, 0) is located at the upper left corner of the photo.
	 */
	public void setPixel(int x, int y, Pixel p) {
		img.setRGB(x, y, p.getData());
	}
	
	/**
	 * Standard equals method.
	 * 
	 * @return true if the parameter is a photograph and each of the pixels in the parameter
	 * is equal to the corresponding pixel in the current object.
	 */
	public boolean equals(Object p) {
		if (p == null)
			return false;
		if (p.getClass() != this.getClass())
			return false;
		Photograph x = (Photograph)p;
		if (x.getWd() != getWd() || x.getHt() != getHt())
			return false;
		for (int i = 0; i < x.getWd(); i++) {
			for (int j = 0; j < x.getHt(); j++) {
				if (!x.getPixel(i, j).equals(getPixel(i, j))) {
						return false;
				}
			}
		}
		return true;
	}
	

	/**
	 * Loads the specified image. The new image will replace any previous
	 * image.
	 * 
	 * @param imageName Can be either a local filename or a URL 
	 * of a GIF, JPG, or PNG image.
	 */
	private static BufferedImage loadImage(String imageName) {
		java.awt.Image origImage = null;
		BufferedImage img = null;

		if (imageName.startsWith("http://")) {
			URL imageURL;
			try {
				imageURL = new URL(imageName);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
				throw new RuntimeException(e1);
			}
			origImage = Toolkit.getDefaultToolkit().getImage(imageURL);

		} else {
			origImage = Toolkit.getDefaultToolkit().getImage(imageName);
		}

		// Java normally loads images in a background thread.
		// This waits for the image to finish loading.
		try {
			MediaTracker tracker = new MediaTracker(new Panel());
			tracker.addImage(origImage, 0);
			tracker.waitForID(0);
			if (tracker.statusID(0,true) != MediaTracker.COMPLETE) { 
				throw new RuntimeException("Unable to load " + imageName);
			}
		} catch(InterruptedException e) {
			// won't be interrupted
		}


		// If image loaded, then create a BufferedImage which is modifiable
		int imageWidth = origImage.getWidth(null);
		int imageHeight = origImage.getHeight(null);
		if ((imageWidth > 0) && (imageHeight > 0)) {
			img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			g.drawImage(origImage, 0, 0, null);
		}

		return img;
	}


	
}
