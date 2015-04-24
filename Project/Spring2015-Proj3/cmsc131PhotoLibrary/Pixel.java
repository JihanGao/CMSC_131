package cmsc131PhotoLibrary;


/**
 * An immutable class representing a single pixel found in a photograph.
 * 
 * @author (c)2007, Fawzi Emad
 *
 */
public class Pixel {
	
	private int data;
	
	Pixel(int data) {
		this.data = data;
	}
	
	/**
	 * Create a new Pixel object by specifying the levels of red, green, and blue
	 * colors present.  (Each of these can be from 0 to 255).
	 * 
	 * @param red level of red (0 to 255)
	 * @param green level of green (0 to 255)
	 * @param blue level of blue (0 to 255)
	 */
	public Pixel(int red, int green, int blue) {
		data = (red << 16) | (green << 8) | blue;
	}
	
	int getData() {
		return data;
	}
	
	/**
	 * Returns the level of red seen in the Pixel
	 * @return level of red (0 to 255)
	 */
	public int getRed() {
		return (data & 0xFF0000) >> 16;
	}
	
	/**
	 * Returns the level of green seen in the Pixel
	 * @return level of green (0 to 255)
	 */
	public int getGreen() {
		return (data & 0x00FF00) >> 8;
	}
	
	/**
	 * Returns the level of blue seen in the Pixel
	 * @return level of blue (0 to 255)
	 */
	public int getBlue() {
		return (data & 0x0000FF);
	}

	/**
	 * Standard equals method.  Returns true if the parameter is a Pixel and the levels
	 * of red, green, and blue in the parameter match those of the current object.
	 * @return true if the current object is the same as the paramter
	 */
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o.getClass() != this.getClass())
			return false;
		Pixel p = (Pixel) o;
		return p.data == data;
	}
}
