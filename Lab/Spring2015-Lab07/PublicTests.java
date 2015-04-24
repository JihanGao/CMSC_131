import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testNullAndEmptyArraysL7() {
		int[] results = Lab07.tallyArray(null);
		for (int index=0; index<10; index++) {
			assertEquals(0,results[index]);
		}
		
		int[] arrayToSend = new int[0];
		results = Lab07.tallyArray(arrayToSend);
		for (int index=0; index<10; index++) {
			assertEquals(0,results[index]);
		}
	}

	@Test
	public void testGoodArray1L7() {
		int[] arrayToSend = new int[10];
		for (int index=0; index<10; index++) {
			arrayToSend[index] = index+1;
		}
		int[] results = Lab07.tallyArray(arrayToSend);
		for (int index=0; index<10; index++) {
			assertEquals(1,results[index]);
		}
	}
	
	@Test
	public void testBadArray1L7() {
		int[] arrayToSend = new int[10];
		for (int index=0; index<10; index++) {
			arrayToSend[index] = index;
		}
		
		try {
			int[] results = Lab07.tallyArray(arrayToSend);
			fail();
		}
		catch (RuntimeException e) {
			assertEquals("Ooops. Sorry about that.", e.getMessage());
		}
	}

}
