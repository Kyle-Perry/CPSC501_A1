package game;

import java.util.Random;

/* What is going on here?
 * 
 * This is the hand class, it belongs to a player, and holds their 3 dice and whether or not one of them is set aside(locked)
 * It can roll dice, lock a single die (determined by the player in Game), compare itself to another hand and determine its rank, pair value(if one exists
 * and the highest single die in the hand(single == not belonging to a pair, so in 6 6 5, it would be 5)
 * 
 */

public abstract class Player {

	protected Dice dice[];
	protected int rank, 
	pairValue, 
	highestSingle;	
	
	public Player(int diceNum) 
	{
		this.dice = new Dice[diceNum];
		for( int i = 0; i < 3; i++)
		{
			this.dice[i] = new Dice();
		}
		this.rank = 0;
		this.pairValue = 0;
		this.highestSingle = 0;
	}
	
	public boolean getLockStatus(int index)
	{
		return dice[index].getLock();
	}
	
	public int getRank() {
		return rank;
	}

	public int getPairValue() {
		return pairValue;
	}

	public int getHighestSingle() {
		return highestSingle;
	}

	public void rollDice(Random roll)
	{
		for( int i = 0; i < 3; i++)
			dice[i].roll(roll);
	}

	public void setLock(int diceSelected, boolean lockValue)
	{
		dice[diceSelected].setLock(lockValue);
	}
	
	public void determineHand()
	{
		rank = Game.SINGLE;
		pairValue = 0; 
		if(hasThreeKind())
		{
			setHandValues(Game.THREE_OF_A_KIND, 0, dice[0].getValue());
			return;
		}
		if(isPair(dice[0], dice[1]))
		{
			setHandValues(Game.PAIR, dice[2].getValue(),dice[0].getValue());
			return;
		}
		if(isPair(dice[0], dice[2]))
		{
			setHandValues(Game.PAIR, dice[1].getValue(),dice[0].getValue());
			return;
		}
		if(isPair(dice[1], dice[2]))
		{
			setHandValues(Game.PAIR, dice[0].getValue(),dice[1].getValue());
			return;
		}
		highestSingle = findHighestSingle(dice);
		
	}

	private void setHandValues(int rank, int highestSingle, int pairValue) {
		this.rank = rank;
		this.highestSingle = highestSingle;
		this.pairValue = pairValue;
	}
	
	
	private boolean hasThreeKind() {
		return dice[0].compareDice(dice[1]) == 0 && dice[0].compareDice(dice[2]) == 0;
	}
	
	private boolean isPair(Dice d1, Dice d2) {
		return d1.compareDice(d2) == 0;
	}
	
	private int findHighestSingle(Dice[] dice) {
		int highest = dice[0].getValue();
		for(Dice current: dice) {
			if(current.getValue() > highest)
				highest = current.getValue();
		}
		
		return highest;
	}
	
	
	public int compareHands(Player other)
	{
		if(this.rank != other.getRank())
			return this.rank - other.getRank();
		if(this.pairValue != other.getPairValue())
			return this.pairValue - other.getPairValue();
		return this.highestSingle - other.getHighestSingle();
	}
	
	public Dice getADice( int index )
	{
		return dice[index];
	}
	
	public Dice[] getAllDice() {
		return dice;
	}
	
	public abstract void playersTurn(Random roll);


}

