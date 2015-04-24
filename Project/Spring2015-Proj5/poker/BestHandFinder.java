package poker;
import java.util.ArrayList;


public class BestHandFinder {

	/* If 5 or more cards are in the list, this method will determine the highest 
	 * ranking 5-card subset of the list and will return the rank this highest subset.  
	 * For example, if the best 5 card subset is a Full House, the method will return 
	 * "Full House".  Note that this method relies on the evaluateFiveCardHand method.
	 */
		public static String evaluteHand(Card[] hand) {
			ArrayList<Card> cards = new ArrayList<Card>();
			for (int i = 0; i < hand.length; i++) {
				if (hand[i] != null) {
					cards.add(hand[i]);
				}
			}
			String [] rankNames = {
					"Royal Sampler", 
					"Pair", 
					"Rainbow",
					"Two Pair", 
					"Three of a Kind",
					"Straight",
					"Flush", 
					"Full House", 
					"Four of a Kind", 
					"Straight Rainbow",
					"Straight Flush", 
					"Five of a Kind"
			};
			
			if (cards.size() < 5)
				return "";
			else {
				int [] index = new int[5];
				int bestFound = 0;
				for (index[0] = 0; index[0] < cards.size() - 4; index[0]++)
					for (index[1] = index[0] + 1; index[1] < cards.size() - 3 ; index[1]++)
						for (index[2] = index[1] + 1; index[2] < cards.size() - 2; index[2]++)
							for (index[3] = index[2] + 1; index[3] < cards.size() - 1; index[3]++)
								for (index[4] = index[3] + 1; index[4] < cards.size(); index[4]++) {
									Card [] cardArray = new Card[5];
									for (int i = 0; i < 5; i++)
										cardArray[i] = (Card)cards.get(index[i]);
									int handValue = evaluateFiveCardHand(cardArray);
									if (handValue > bestFound)
										bestFound = handValue;
								}
				return rankNames[bestFound];
			}
		}
		
	/* parameter "cards" is an array of exactly 5 cards.  This method will
	 * determine the rank of the hand and will return the corresponding integer
	 * from the table below:
	 *   
	 *   Rank of Hand         Return Value
	 *   ============         ============
	 *   Five of a Kind      11  
	 *   Straight Flush      10
	 *   Straight Rainbow     9
	 *   Four of a Kind       8
	 *   Full House           7
	 *   Flush                6
	 *   Straight             5
	 *   Three of a Kind      4
	 *   Two Pair             3
	 *   Rainbow              2
	 *   Pair                 1
	 *   None of the above    0
	 *  	 
	 */
		public static int evaluateFiveCardHand(Card [] cards) {
			if (PokerHandEvaluator.hasFiveOfAKind(cards))
				return 11;
			else if (PokerHandEvaluator.hasStraightFlush(cards))
				return 10;
			else if (PokerHandEvaluator.hasStraightRainbow(cards))
				return 9;
			else if (PokerHandEvaluator.hasFourOfAKind(cards))
				return 8;
			else if (PokerHandEvaluator.hasFullHouse(cards))
				return 7;
			else if (PokerHandEvaluator.hasFlush(cards))
				return 6;
			else if (PokerHandEvaluator.hasStraight(cards))
				return 5;
			else if (PokerHandEvaluator.hasThreeOfAKind(cards))
				return 4;
			else if (PokerHandEvaluator.hasTwoPair(cards))
				return 3;
			else if (PokerHandEvaluator.hasRainbow(cards))
				return 2;
			else if (PokerHandEvaluator.hasPair(cards))
				return 1;
			else 
				return 0;
		}
}
