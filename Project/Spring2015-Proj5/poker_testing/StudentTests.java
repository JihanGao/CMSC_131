package poker_testing;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import poker.Card;
import poker.Deck;
import poker.PokerHandEvaluator;

public class StudentTests {

	@Test
	public void testExampleTest_SinglePairTest() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,1);
		testHand[1] = new Card(2,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(4,1);
		testHand[4] = new Card(5,1);
		assertFalse(PokerHandEvaluator.hasPair(testHand));
	}
	
	
	//You will add many other tests here for pair and the other hands
	
	@Test
	public void TwoPairTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,2);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(3,4);
		testHand[4] = new Card(3,1);
		assertFalse(PokerHandEvaluator.hasTwoPair(testHand));
	}
	@Test
	public void TwoPairTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,2);
		testHand[1] = new Card(3,1);
		testHand[2] = new Card(4,1);
		testHand[3] = new Card(4,2);
		testHand[4] = new Card(2,4);
		assertTrue(PokerHandEvaluator.hasTwoPair(testHand));
	}
	@Test
	public void ThreeOfAKindTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,2);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(4,3);
		testHand[4] = new Card(4,1);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(testHand));
	}
	@Test
	public void testExampleTest_ThreeOfAKindTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,2);
		testHand[2] = new Card(2,1);
		testHand[3] = new Card(2,2);
		testHand[4] = new Card(1,1);
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(testHand));
	}
	@Test
	public void testExampleTest_FourOfAKindTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,2);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(3,4);
		testHand[4] = new Card(1,1);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(testHand));
	}
	@Test
	public void testExampleTest_FourOfAKindTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,2);
		testHand[1] = new Card(4,1);
		testHand[2] = new Card(4,2);
		testHand[3] = new Card(3,1);
		testHand[4] = new Card(1,2);
		assertFalse(PokerHandEvaluator.hasFourOfAKind(testHand));
	}
	@Test
	public void testExampleTest_FiveOfAKindTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,4);
		testHand[1] = new Card(3,4);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(3,2);
		testHand[4] = new Card(3,1);
		assertTrue(PokerHandEvaluator.hasFiveOfAKind(testHand));
	}
	@Test
	public void testExampleTest_StraightTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(1,4);
		testHand[1] = new Card(2,4);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(4,2);
		testHand[4] = new Card(5,1);
		assertTrue(PokerHandEvaluator.hasStraight(testHand));
	}
	@Test
	public void testExampleTest_Straight2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(9,4);
		testHand[1] = new Card(1,4);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(2,2);
		testHand[4] = new Card(4,1);
		assertFalse(PokerHandEvaluator.hasStraight(testHand));
	}
	@Test
	public void testExampleTest_Straight3() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(6,4);
		testHand[1] = new Card(8,4);
		testHand[2] = new Card(1,3);
		testHand[3] = new Card(9,2);
		testHand[4] = new Card(7,1);
		assertTrue(PokerHandEvaluator.hasStraight(testHand));
	}
	@Test
	public void testExampleTest_Straight4() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(8,4);
		testHand[1] = new Card(1,4);
		testHand[2] = new Card(2,3);
		testHand[3] = new Card(9,2);
		testHand[4] = new Card(7,1);
		assertFalse(PokerHandEvaluator.hasStraight(testHand));
	}
	@Test
	public void testExampleTest_RainbowTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,2);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(3,4);
		testHand[4] = new Card(1,0);
		assertTrue(PokerHandEvaluator.hasRainbow(testHand));
	}
	@Test
	public void RainbowTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,2);
		testHand[2] = new Card(3,3);
		testHand[3] = new Card(3,4);
		testHand[4] = new Card(1,4);
		assertFalse(PokerHandEvaluator.hasRainbow(testHand));
	}

	@Test
	public void FlushTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,1);
		testHand[2] = new Card(3,1);
		testHand[3] = new Card(3,1);
		testHand[4] = new Card(1,1);
		assertTrue(PokerHandEvaluator.hasFlush(testHand));
	}
	@Test
	public void FlushTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(3,2);
		testHand[2] = new Card(3,4);
		testHand[3] = new Card(3,2);
		testHand[4] = new Card(1,1);
		assertFalse(PokerHandEvaluator.hasFlush(testHand));
	}
	@Test
	public void StraightRainbowTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(4,2);
		testHand[2] = new Card(1,4);
		testHand[3] = new Card(2,3);
		testHand[4] = new Card(5,0);
		assertTrue(PokerHandEvaluator.hasStraightRainbow(testHand));
	}
	@Test
	public void StraightRainbowTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(8,1);
		testHand[1] = new Card(9,2);
		testHand[2] = new Card(1,4);
		testHand[3] = new Card(2,3);
		testHand[4] = new Card(3,0);
		assertFalse(PokerHandEvaluator.hasStraightRainbow(testHand));
	}
	@Test
	public void StraightRainbowTest3() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(6,1);
		testHand[1] = new Card(7,2);
		testHand[2] = new Card(8,4);
		testHand[3] = new Card(9,3);
		testHand[4] = new Card(1,0);
		assertTrue(PokerHandEvaluator.hasStraightRainbow(testHand));
	}
	@Test
	public void StraightFlushTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(3,1);
		testHand[1] = new Card(4,1);
		testHand[2] = new Card(1,1);
		testHand[3] = new Card(2,1);
		testHand[4] = new Card(5,1);
		assertTrue(PokerHandEvaluator.hasStraightFlush(testHand));
	}
	@Test
	public void StraightFlushTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(6,2);
		testHand[1] = new Card(7,2);
		testHand[2] = new Card(8,2);
		testHand[3] = new Card(9,2);
		testHand[4] = new Card(1,2);
		assertTrue(PokerHandEvaluator.hasStraightFlush(testHand));
	}
	@Test
	public void FullHouseTest1() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(6,2);
		testHand[1] = new Card(6,2);
		testHand[2] = new Card(6,2);
		testHand[3] = new Card(3,2);
		testHand[4] = new Card(3,2);
		assertTrue(PokerHandEvaluator.hasFullHouse(testHand));
	}
	@Test
	public void FullHouseTest2() {
		Card[] testHand = new Card[5];
		testHand[0] = new Card(6,2);
		testHand[1] = new Card(6,2);
		testHand[2] = new Card(6,2);
		testHand[3] = new Card(6,2);
		testHand[4] = new Card(3,2);
		assertFalse(PokerHandEvaluator.hasFullHouse(testHand));
	}
	@Test
	public void testExampleTest_SmallShuffle() {
		Deck testDeck = new Deck();
		
		testDeck.deal(45-8); //get rid off all but 8 cards
		testDeck.shuffle();  //shuffle the remaining cards
		Card[] testCards = testDeck.deal(8); //deal the remaining 8 cards to me
		//This should give me 2, 3,    4, 5, 6,    7, 8, 9 of Stars
		
		
		//Now check the actual cards against what I expect...
		int[] shouldBe = { 7,4,2,8,5,3,9,6 };
		for (int i=0; i<8; i++) {
			assertEquals(shouldBe[i], testCards[i].getValue());
			assertEquals(4, testCards[i].getSuit());
		}
	}

}
