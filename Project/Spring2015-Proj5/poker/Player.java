package poker;

public class Player {
	
	private Card[] hand;
	
	public Player(){
		hand = new Card[0];
	}
	
	/* shallow copy ok since Card is immutable */
	public Player(Player x) {
		hand = new Card[x.hand.length];
		for (int i = 0; i < x.hand.length; i++) {
			hand[i] = x.hand[i];
		}
	}
	
	public void setHand(Card[] cards) {
		hand = cards;
	}
	
	public Card[] getHand() {
		return hand;
	}
}
