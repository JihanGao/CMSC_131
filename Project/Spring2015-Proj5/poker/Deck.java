package poker;

public class Deck {

	private Card[] cards;
	//create a constructor for the deck
	public Deck() {
		this.cards=new Card[45];
		int i=0;
		for(int suit=0;suit<5;suit++){
			for(int value=1;value<=9;value++){
				this.cards[i]=new Card(value,suit);
				i++;
			}
		}
			
	
	}
	//create a copy constructor
	public Deck(Deck other) {
		this.cards = new Card[other.cards.length];
		for(int i=0;i<other.cards.length;i++){
			this.cards[i]=other.cards[i];
		}
	}

	//get card at its position
	public Card getCardAt(int position) {
		return this.cards[position];
	}
	//get the number of card
	public int getNumCards() {
		return cards.length;
	}

	//return an array of a specific number of cards and create a new array of the rest cards
	public Card[] deal(int numCards) {
		Card[] smaller=new Card[cards.length-numCards];	//create new array for rest cards
		Card[] returnCard=new Card[numCards];   // create new return card array
		for(int i=0;i<cards.length-numCards;i++){
			smaller[i]=cards[i+numCards]; 
			
		}
		for(int j=0;j<numCards;j++){
			returnCard[j]=cards[j];
		}
		cards=smaller;
		return returnCard;
	}
 
	public void cut(int position) {
		Card[] cuter=new Card[cards.length];
		for(int i=0;i<cards.length;i++){
			if(i<cards.length-position){
				cuter[i]=cards[i+position];	//create a new array which starts at the cutting point
			}
			else{
				cuter[i]=cards[i+position-cards.length];	//get the reversed part of the cutting deck
			}
		}
		cards=cuter;
	}
	

	
	public void shuffle() {
		//I there are not at least 3 cards, don't do anything.
		
		//If there are at least 3 cards...
		/*
		 * The easiest thing is likely to create a new array into which 
		 * the cards will be shuffled.
		 * 
		 * Work out the following four values for each of the three possible
		 * scenarios of dividing the size of the deck by 3 (remainder: 0,1,2).
		 *   - the size of the smallest (top) sub-deck you'll need
		 *   - the size of the other two (middle, bottom) sub-decks you'll need
		 *   - the "breakpoint" where the middle sub-deck starts
		 *   - the "breakpoint" where the bottom sub-deck starts
		 *   
		 * Once you have those things determined, start to assemble the
		 *   shuffled order into the new array.  This should be done in two
		 *   phases; interleaving cards from all three sub-decks until the top
		 *   one is empty, and then interleaving the last few cards from the
		 *   middle and bottom sub-decks after that.  
		 *   
		 * At the very end, you can have the cards field point to the newly
		 *   created array.
		 *   
		 *   
		 * Think of some simple scenarios first, to work through the idea.
		 * Some good starter decks to try to shuffle would be:
		 *    1,2,3,4,5,6,7,8,9 which would shuffle into 7,4,1,8,5,2,9,6,3
		 *    2,3,4,5,6,7,8,9 which would shuffle into 7,4,2,8,5,3,9,6
		 *    3,4,5,6,7,8,9 which would shuffle into 7,4,3,8,5,9,6
		 * I wouldn't start writing any code until the above examples make
		 *   sense given the rules of how to shuffle.
		 */
		/*int a=0;
		int b=0;
		int afterShuffle=0;
		int count=0;
		Card[] bottomstack = new Card[cards.length / 3];
		Card[] middlestack = new Card[cards.length / 3];
		Card[] topstack = new Card[cards.length / 3];
		
		//create three stacks and store the value, each represent 1/3 of the whole deck
        if(cards.length%3==0){
        	for(int i=0;i<cards.length/3;i++){
        		topstack[i]=cards[i];
        	}
        	for(int j=cards.length/3;j<2*cards.length/3;j++){
        		middlestack[a]=cards[j];
           		a++;
        	}
        	for(int k=2*cards.length/3;k<cards.length;k++){
        		bottomstack[b]=cards[k];
        		b++;
        	}
        	//combine the three stack into a new deck
        	for(afterShuffle=0;afterShuffle<cards.length/3;afterShuffle++){
        		cards[count]=bottomstack[afterShuffle];
        		count++;
        		cards[count]=middlestack[afterShuffle];
        		count++;
        		cards[count]=topstack[afterShuffle];
        		count++;
        	}
        }
	}*/
			Card[] shuffled = new Card[cards.length];

			Card[] bottomstack = new Card[(cards.length + 2) / 3];
			Card[] middlestack = new Card[(cards.length + 2) / 3];
			Card[] topstack = new Card[cards.length - bottomstack.length
					- middlestack.length];
			Card[][] stacks = { bottomstack, middlestack, topstack };

			// allocate into stacks
			for (int i = 0; i < topstack.length; i++)
				topstack[i] = cards[i];
			for (int i = 0; i < middlestack.length; i++)
				middlestack[i] = cards[i + topstack.length];
			for (int i = 0; i < bottomstack.length; i++)
				bottomstack[i] = cards[i + topstack.length
						+ middlestack.length];

			// deal cards
			int[] positions = { 0, 0, 0 };
			for (int i = 0, pilenumber = 0; i < cards.length; i++, pilenumber++) {

				if (positions[pilenumber % 3] == stacks[pilenumber % 3].length)
					pilenumber++;
				shuffled[i] = stacks[pilenumber % 3][positions[pilenumber % 3]];
				positions[pilenumber % 3]++;
			}

			cards = shuffled;
		}
 }

	
	

