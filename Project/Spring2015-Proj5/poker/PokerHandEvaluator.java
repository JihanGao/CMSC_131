package poker;

public class PokerHandEvaluator {
	

	//You might want to write some private helper methods...

	//compare each cards one by one,if the values equal, return true
	public static boolean hasPair(Card[] cards) {
		for(int i=0;i<cards.length-1;i++){
			for(int j=i+1;j<cards.length;j++){
				if(cards[i].getValue()==cards[j].getValue()){
					return true;
				}
			}
		}
		return false;
	}
	
	//create a new contains method to define whether the cards suit are in the deck
	public static boolean containsSuit(Card[] cards, int suit) {
		for (int i = 0; i < 5; i++) {
			if (cards[i].getSuit() == suit) {
			return true;
			}
		}
			return false;
	}

	public static boolean hasRainbow(Card[] cards) {
		if(containsSuit(cards,0)&&containsSuit(cards,1)&&containsSuit(cards,2)&&containsSuit(cards,3)&&containsSuit(cards,4)){
			return true;
		}
		else return false;
	
	}
	//find two pairs in a deck
	public static boolean hasTwoPair(Card[] cards) {
		int temp = 0;
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				// store the first pairs to temp
				if (cards[i].getValue() == cards[j].getValue()) {
					temp = cards[i].getValue();
				}
			}
		}
		if (temp != 0) {
			// traverse again to find the second pairs
			for (int m = 0; m < cards.length - 1; m++) {
				if (cards[m].getValue() == temp) {
					continue;
				} else {
					for (int n = m + 1; n < cards.length; n++) {
						if (cards[m].getValue() == cards[n].getValue()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	//Find three same cards in a deck
	public static boolean hasThreeOfAKind(Card[] cards) {
		for(int i=0;i<cards.length-2;i++){
			for(int j=i+1;j<cards.length-1;j++){
				for(int k=j+1;k<cards.length;k++){
					if(cards[i].getValue()==cards[j].getValue()&&cards[i].getValue()==cards[k].getValue()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//create a new method to find the smallest value
	public static int getSmallest(Card[] cards) {
		int smallest = 99;
			for(int i = 0; i < 5; i++) {
				smallest = cards[i].getValue()>smallest ? smallest : cards[i].getValue();
			}
		return smallest;
	}

	//create a new contains method to define whether the cards in the deck
	public static boolean contains(Card[] cards, int number) {
		for (int i = 0; i < 5; i++) {
			if (cards[i].getValue() == number) {
				return true;
			}
		}
		return false;
	}
	//by using getSmallest method and contains method, find straight one
	public static boolean hasStraight(Card [] cards) {		
		int smallest=getSmallest(cards);
		//special case when contains 1
		if(smallest==1){
			//if smallest equals to 1, the result is true when we have 6,7,8,9
			if(contains(cards,6)&&contains(cards,7)&&contains(cards,8)&&contains(cards,9)){	
				return true;
			}
			//the result comes true when we have 1,2,3,4,5
			else if(contains(cards,2)&&contains(cards,3)&&contains(cards,4)&&contains(cards,5)){	
				return true;
			}	
			//other cases are wrong
			else return false;
		}
		//normal case for straight
		else{
			if(contains(cards,smallest+1)&&contains(cards,smallest+2)&&contains(cards,smallest+3)&&contains(cards,smallest+4)){
				return true;
			}
		}
		return false;
	}
	
	
	
	//create a method which contains 5 same suits in a deck
	public static boolean hasFlush(Card[] cards) {
		if(cards[0].getSuit()==cards[1].getSuit()&&cards[0].getSuit()==cards[2].getSuit()&&cards[0].getSuit()==cards[3].getSuit()&&cards[0].getSuit()==cards[4].getSuit()){
			return true;
		}
		return false;
	}
	
	public static boolean hasFullHouse(Card[] cards) {
		if(hasThreeOfAKind(cards)==true && hasTwoPair(cards)==true){
			return true;
		}
		return false;
	}
	
	//find four same cards in a deck
	public static boolean hasFourOfAKind(Card[] cards) {
		for(int i=0;i<cards.length-3;i++){
			for(int j=i+1;j<cards.length-2;j++){
				for(int k=j+1;k<cards.length-1;k++){
					for(int p=k+1;p<cards.length;p++)
					if(cards[i].getValue()==cards[j].getValue()&&cards[i].getValue()==cards[k].getValue()&&cards[p].getValue()==cards[k].getValue()){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	//combine straight and rainbow
	public static boolean hasStraightRainbow(Card[] cards) {
		if(hasRainbow(cards)==true && hasStraight(cards)==true){
			return true;
		}
		return false;
	}
	//combine straight and flush
	public static boolean hasStraightFlush(Card[] cards) {
		if(hasFlush(cards)==true && hasStraight(cards)==true){
			return true;
		}
		return false;
	}
	
	
	
	//find five same value of cards in a deck
	public static boolean hasFiveOfAKind(Card[] cards) {
		for(int i=0;i<cards.length-4;i++){
			for(int j=i+1;j<cards.length-3;j++){
				for(int k=j+1;k<cards.length-2;k++){
					for(int p=k+1;p<cards.length-1;p++)
						for(int g=p+1;g<cards.length;g++){
							if(cards[i].getValue()==cards[j].getValue()&&cards[i].getValue()==cards[k].getValue()&&cards[p].getValue()==cards[k].getValue()&&cards[g].getValue()==cards[k].getValue()){
								return true;
						}
					}
				}
			}
		}
		return false;
	}
}

