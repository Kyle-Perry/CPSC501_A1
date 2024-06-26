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
		p1 = new ComputerPlayer(3);
		p2 = new ComputerPlayer(3);
		roller = new Random();
	}

	@Test
	public void testThreeOfAKind()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(5);
		p1.determineHand();
		assertEquals("Testing hand {5,5,5}, expecting rank = Game.THREE_OF_A_KIND", Game.THREE_OF_A_KIND, p1.getRank());
		assertEquals("Testing hand {5,5,5}, expecting pair value = 5", 5, p1.getPairValue());
		assertEquals("Testing hand {5,5,5}, expecting highest single = 0", 0, p1.getHighestSingle());
	}

	@Test
	public void testPairDice1and2()
	{
		p1.getADice(0).setValue(4);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(1);
		p1.determineHand();
		assertEquals("Testing hand {4,4,1}, expecting rank = Game.PAIR", Game.PAIR, p1.getRank());
		assertEquals("Testing hand {4,4,1}, expecting pair value = 4", 4, p1.getPairValue());
		assertEquals("Testing hand {4,4,1}, expecting highest single = 4", 1, p1.getHighestSingle());
	}

	@Test
	public void testPairDice1and3()
	{
		p1.getADice(0).setValue(3);
		p1.getADice(1).setValue(6);
		p1.getADice(2).setValue(3);
		p1.determineHand();
		assertEquals("Testing hand {3,6,3}, expecting rank = Game.PAIR", Game.PAIR, p1.getRank());
		assertEquals("Testing hand {3,6,3}, expecting pair value = 3", 3, p1.getPairValue());
		assertEquals("Testing hand {3,6,3}, expecting highest single = 6", 6, p1.getHighestSingle());
	}
	
	@Test
	public void testPairDice2and3()
	{
		p1.getADice(0).setValue(2);
		p1.getADice(1).setValue(3);
		p1.getADice(2).setValue(3);
		p1.determineHand();
		assertEquals("Testing hand {2,3,3}, expecting rank = Game.PAIR", Game.PAIR, p1.getRank());
		assertEquals("Testing hand {2,3,3}, expecting pair value = 3", 3, p1.getPairValue());
		assertEquals("Testing hand {2,3,3}, expecting highest single = 2", 2, p1.getHighestSingle());
	}
	
	@Test
	public void testSingle123()
	{
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();
		assertEquals("Testing hand {6,4,2}, expecting rank = Game.SINGLE", Game.SINGLE, p1.getRank());
		assertEquals("Testing hand {6,4,2}, expecting pair value = 0", 0, p1.getPairValue());
		assertEquals("Testing hand {6,4,2}, expecting highest single = 6", 6, p1.getHighestSingle());
	}	

	@Test
	public void testSingle132()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(1);
		p1.getADice(2).setValue(3);
		p1.determineHand();
		assertEquals("Testing hand {5,1,3}, expecting rank = Game.SINGLE", Game.SINGLE, p1.getRank());
		assertEquals("Testing hand {5,1,3}, expecting pair value = 0", 0, p1.getPairValue());
		assertEquals("Testing hand {5,1,3}, expecting highest single = 5", 5, p1.getHighestSingle());
	}

	@Test
	public void testSingle213()
	{
		p1.getADice(0).setValue(4);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(3);
		p1.determineHand();
		assertEquals("Testing hand {4,5,3}, expecting rank = Game.SINGLE", Game.SINGLE, p1.getRank());
		assertEquals("Testing hand {4,5,3}, expecting pair value = 0", 0, p1.getPairValue());
		assertEquals("Testing hand {4,5,3}, expecting highest single = 5", 5, p1.getHighestSingle());
	}

	@Test
	public void testSingle231()
	{
		p1.getADice(0).setValue(2);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(3);
		p1.determineHand();
		assertEquals("Testing hand {2,4,3}, expecting rank = Game.SINGLE", Game.SINGLE, p1.getRank());
		assertEquals("Testing hand {2,4,3}, expecting pair value = 0", 0, p1.getPairValue());
		assertEquals("Testing hand {2,4,3}, expecting highest single = 4", 4, p1.getHighestSingle());
	}

	@Test
	public void testSingle312()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(6);
		p1.determineHand();
		assertEquals("Testing hand {5,4,6}, expecting rank = Game.SINGLE", Game.SINGLE, p1.getRank());
		assertEquals("Testing hand {5,4,6}, expecting pair value = 0", 0, p1.getPairValue());
		assertEquals("Testing hand {5,4,6}, expecting highest single = 6", 6, p1.getHighestSingle());
	}

	@Test
	public void testSingle321()
	{
		p1.getADice(0).setValue(1);
		p1.getADice(1).setValue(2);
		p1.getADice(2).setValue(3);
		p1.determineHand();
		assertEquals("Testing hand {1,2,3}, expecting rank = Game.SINGLE", Game.SINGLE, p1.getRank());
		assertEquals("Testing hand {1,2,3}, expecting pair value = 0", 0, p1.getPairValue());
		assertEquals("Testing hand {1,2,3}, expecting highest single = 3", 3, p1.getHighestSingle());
	}

	@Test
	public void testCompareHands1()
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
	}

	@Test
	public void testCompareHands2()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(5);
		p1.determineHand();

		p2.getADice(0).setValue(4);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(4);
		p2.determineHand();

		assertTrue("Testing two Players with {5, 5, 5} and {4, 4, 4}, expecting x > 0. (player 1 wins).", p1.compareHands(p2) > 0);
	}

	@Test
	public void testCompareHands3()
	{	
		p1.getADice(0).setValue(4);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(4);
		p1.determineHand();

		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(5);
		p2.determineHand();

		assertTrue("Testing two Players with {4, 4, 4} and {5, 5, 5}, expecting x <= -1(player 2 wins).",  p1.compareHands(p2) < 0);
	}

	@Test
	public void testCompareHands4()
	{
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
	}

	@Test
	public void testCompareHands5()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(6);
		p1.determineHand();

		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(4);
		p2.determineHand();

		assertTrue("Testing two Players with {5, 5, 6} and {5, 5, 4}, expecting x >= 1(player 1 wins).", 1 <= p1.compareHands(p2));
	}

	@Test
	public void testCompareHands6()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(4);
		p1.determineHand();

		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(5);
		p2.getADice(2).setValue(6);
		p2.determineHand();

		assertTrue("Testing two Players with {5, 5, 4} and {5, 5, 6}, expecting x <= -1(player 2 wins).", -1 >= p1.compareHands(p2));
	}

	@Test
	public void testCompareHands7()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(6);
		p1.determineHand();

		p2.getADice(0).setValue(4);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(6);
		p2.determineHand();

		assertTrue("Testing two Players with {5, 5, 6} and {4, 4, 6}, expecting x >= 1(player 1 wins).", 1 <= p1.compareHands(p2));
	}

	@Test
	public void testCompareHands8()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(6);
		p1.determineHand();

		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(6);
		p2.getADice(2).setValue(4);
		p2.determineHand();

		assertTrue("Testing two Players with {5, 5, 6} and {6, 6, 4}, expecting x <= -1(player 2 wins).", -1 >= p1.compareHands(p2));
	}

	@Test
	public void testCompareHands9()
	{
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
	}

	@Test
	public void testCompareHands10()
	{
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();

		p2.getADice(0).setValue(5);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();

		assertTrue("Testing two Players with {6, 4, 2} and {5, 4, 2}, expecting x >= 1(player 1 wins).", 1 <= p1.compareHands(p2));
	}

	@Test
	public void testCompareHands11()
	{
		p1.getADice(0).setValue(5);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();

		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();

		assertTrue("Testing two Players with {5, 4, 2} and {6, 4, 2}, expecting x <= -1(player 2 wins).", -1 >= p1.compareHands(p2));
	}

	@Test
	public void testCompareHands12()
	{
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(1);
		p1.determineHand();

		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();

		assertTrue("Testing two Players with {6, 4, 1} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	}

	@Test
	public void testCompareHands13()
	{
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(3);
		p1.determineHand();

		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();

		assertTrue("Testing two Players with {6, 4, 3} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	}

	@Test
	public void testCompareHands14()
	{
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(3);
		p1.getADice(2).setValue(2);
		p1.determineHand();

		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();

		assertTrue("Testing two Players with {6, 3, 2} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	}

	@Test
	public void testCompareHands15()
	{
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(5);
		p1.getADice(2).setValue(2);
		p1.determineHand();

		p2.getADice(0).setValue(6);
		p2.getADice(1).setValue(4);
		p2.getADice(2).setValue(2);
		p2.determineHand();

		assertTrue("Testing two Players with {6, 5, 2} and {6, 4, 2}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	}

	@Test
	public void testCompareHands16()
	{
		p1.getADice(0).setValue(6);
		p1.getADice(1).setValue(4);
		p1.getADice(2).setValue(2);
		p1.determineHand();

		p2.getADice(0).setValue(2);
		p2.getADice(1).setValue(6);
		p2.getADice(2).setValue(4);
		p2.determineHand();

		assertTrue("Testing two Players with {6, 4, 2} and {2, 6, 4}, expecting x == 0(draw).", 0 == p1.compareHands(p2));
	}

	@Test
	public void testCompareHands17()
	{
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

		for(int x = 0; x < 1000; x++) {
			p1.rollDice(roller);
			assertTrue("Testing if locked die value is the same", (dice.getValue() == 0));
		}
		p1.setLock(0, false);
	}

	@Test
	public void testUnlock() {
		Dice dice = p1.getADice(0);
		dice.setValue(0);
		dice.setLock(true);


		for(int x = 0; x < 1000; x++) {
			dice.setLock(false);
			p1.rollDice(roller);
			assertTrue("Testing if unlocked die value is not the same", (dice.getValue() != 0));
			dice.setLock(true);
			dice.setValue(0);
		}
		p1.setLock(0, false);
	}
}
