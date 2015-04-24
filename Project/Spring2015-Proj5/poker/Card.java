package poker;


/**
 * An immutable class representing a playing card from a standard deck.
 * Each card has a value and a suit.
 * 
 * @author Fawzi Emad (c) 2008 with modifications by Evan Golub 2013-2015
 */
public class Card {

	private final int suit;   // 0, 1, 2, 3, 4 represent Spades, Hearts, Clubs, 
	// Diamonds, Stars respectively

	private final int value;  // 1 through 9 (1 is Ace)


	/* Strings for use in toString method and also for identifying card
	 * images */
	private final static String[] suitNames = {"s", "h", "c", "d", "r"};
	private final static String[] valueNames = {"Unused", "A", "2", "3", "4", 
		"5", "6", "7", "8", "9"};

	/**
	 * Standard constructor.
	 * @param value 1 through 9; 1 represents Ace, 2 through 9 for numerical cards
	 * @param suit 0 through 4; represents Spades, Hearts, Clubs, Diamonds, or Stars
	 */
	public Card(int value, int suit) {
		if (value < 1 || value > 9) {
			throw new RuntimeException("Illegal card value attempted.  The " +
					"acceptible range is 1 to 9.  You tried " + value);
		}
		if (suit < 0 || suit > 4) {
			throw new RuntimeException("Illegal suit attempted.  The  " + 
					"acceptible range is 0 to 4.  You tried " + suit);
		}
		this.suit = suit;
		this.value = value;
	}

	/** 
	 * "Getter" for value of Card.
	 * @return value of card (1-9; 1 for Ace, 2-9 for numerical cards
	 */
	public int getValue() {
		return value;
	}

	/**
	 * "Getter" for suit of Card.
	 * @return suit of card (0-4; 0 for Spades, 1 for Hearts, 2 for Clubs,
	 * 3 for Diamonds, 4 for Stars)
	 */
	public int getSuit() {
		return suit;
	}

	/** Returns the name of the card as a String.  For example, the 2 of Hearts
	 * would be "2 of h", and the 9 of Spades would be "9 of s".
	 * @return string that looks like:  value "of" suit
	 */
	public String toString() {
		return valueNames[value] + " of " + suitNames[suit];
	}

	/**
	 * [STUDENTS SHOULD NOT BE CALLING THIS METHOD!]
	 * Used for finding the image corresponding to this Card.
	 * @return path of image file corresponding to this Card.
	 */
	public String getImageFileName() {
		return "images/" + suitNames[suit] + value + ".gif";	
	}

	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			Card casted = (Card)other;
			return 
					this.getSuit() == casted.getSuit() 
					&& 
					this.getValue() == casted.getValue();
		}
	}
}