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
		rank = 0;
		pairValue = 0; 
		if(dice[0].compareDice(dice[1]) == 0)
		{
			rank = 1;
			pairValue = dice[0].getValue();
			highestSingle = dice[2].getValue();
			if(highestSingle == pairValue){	
				rank = 2;
				highestSingle = 0;
			}
			
		}
		else if(dice[0].compareDice(dice[2]) == 0)
		{
			rank = 1;
			pairValue = dice[0].getValue();
			highestSingle = dice[1].getValue();
		}
		else if(dice[1].compareDice(dice[2]) == 0)
		{
			rank = 1;
			pairValue = dice[1].getValue();
			highestSingle = dice[0].getValue();
		}
		else if(dice[0].compareDice(dice[1]) > 0)
		{
			if(dice[0].compareDice(dice[2]) > 0)
				highestSingle = dice[0].getValue();
			else
				highestSingle = dice[2].getValue();
		}
		else if(dice[1].compareDice(dice[2]) > 0)
			highestSingle = dice[1].getValue();
		else 
			highestSingle = dice[2].getValue();
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
	
	public void printDice() {
		for(int x = 0; x < dice.length; x++){
			System.out.print(" -----    ");
		}
		System.out.println();
		for(Dice aDice: dice){
			System.out.print(aDice.printFirst() + "   ");
		}
		System.out.println();
		for(Dice aDice: dice){
			System.out.print(aDice.printSecond() + "   ");
		}
		System.out.println();
		for(Dice aDice: dice){
			System.out.print(aDice.printThird() + "   ");
		}
		System.out.println();
		for(int x = 0; x < dice.length; x++){
			System.out.print(" -----    ");
		}
		System.out.println();

	}
	
	public abstract void playersTurn(Random roll);


}

