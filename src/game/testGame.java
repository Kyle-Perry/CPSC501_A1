package game;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;

public class testGame {
	static Player p1; 
	static Player p2;
	static Random roller;
	
	@BeforeClass
	public static void createObjects()
	{
		p1 = new Player(3, true);
		p2 = new Player(3, true);
		roller = new Random();
	}
	
	@Test
	public void testCompareHands()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(5);
		p1.determineHand();
		
		assertEquals(2, p1.getRank());
		assertEquals(5, p1.getPairValue());
		assertEquals(0, p1.getHighestSingle());
		
		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(5);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 5, 5} and {5, 5, 5}, expecting x == 0 (game is a draw).", (p1.compareHands(p2) == 0));
	
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(5);
		p1.determineHand();
		
		p2.getADice(0).setValue(4);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(4);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 5, 5} and {4, 4, 4}, expecting x > 0. (player 1 wins).", p1.compareHands(p2) > 0);
		
		p1.getADice(0).setValue(4);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(4);
		p1.determineHand();
		
		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(5);
		p2.determineHand();
		
		assertTrue("Testing two Players with {4, 4, 4} and {5, 5, 5}, expecting x <= -1(player 2 wins).",  p1.compareHands(p2) < 0);
		
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(6);
		p1.determineHand();
		
		assertEquals(1, p1.getRank());
		assertEquals(5, p1.getPairValue());
		assertEquals(6, p1.getHighestSingle());
		
		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(6);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 5, 6} and {5, 5, 6}, expecting x == 0(draw).", p1.compareHands(p2) == 0);
	
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(6);
		p1.determineHand();
		
		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(4);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 5, 6} and {5, 5, 4}, expecting x >= 1(player 1 wins).", 1 <= p1.compareHands(p2));
		
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(4);
		p1.determineHand();
		
		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(6);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 5, 4} and {5, 5, 6}, expecting x <= -1(player 2 wins).", -1 >= p1.compareHands(p2));
		
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(6);
		p1.determineHand();
		
		p2.getADice(0).setValue(4);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(6);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 5, 6} and {4, 4, 6}, expecting x >= 1(player 1 wins).", 1 <= p1.compareHands(p2));
	
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(6);
		p1.determineHand();
		
		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(6);
		p2.getADice(2).setValue(4);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 5, 6} and {6, 6, 4}, expecting x <= -1(player 2 wins).", -1 >= p1.compareHands(p2));
	
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		
		assertEquals(0, p1.getRank());
		assertEquals(0, p1.getPairValue());
		assertEquals(6, p1.getHighestSingle());
		
		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 4, 2} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		
		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 4, 2} and {5, 4, 2}, expecting x >= 1(player 1 wins).", 1 <= p1.compareHands(p2));
		
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		
		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();
		
		assertTrue("Testing two Players with {5, 4, 2} and {6, 4, 2}, expecting x <= -1(player 2 wins).", -1 >= p1.compareHands(p2));
	
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(1);
		p1.determineHand();
		
		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 4, 1} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));

		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(3);
		p1.determineHand();
		
		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 4, 3} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));

		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(3);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		
		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 3, 2} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));

		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		
		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 5, 2} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		
		p2.getADice(0).setValue(2);
		p2.getADice(1).setValue(6);
		p2.getADice(2).setValue(4);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 4, 2} and {2, 6, 4}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		
		p2.getADice(0).setValue(2);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(6);
		p2.determineHand();
		
		assertTrue("Testing two Players with {6, 4, 2} and {2, 6, 4}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	}
	
		@Test
		public void testRoll() {
			Dice dice = p1.getADice(0);
			dice.setValue(0);
			
			for(int x = 0; x < 1000; x++) {
				p1.rollDice(roller);
				assertTrue("Testing rolled die is within range of 1 to 6", !(dice.getValue() > 6 || dice.getValue() < 1));
			}
		}
		
		@Test
		public void testLock() {
			Dice dice = p1.getADice(0);
			dice.setValue(0);
			p1.setLock(0, true);
			p1.rollDice(roller);
			
			for(int x = 0; x < 1000; x++) {
				assertTrue("Testing if locked die value is the same", (dice.getValue() == 0));
			}
			p1.setLock(0, false);
		}
		
}
