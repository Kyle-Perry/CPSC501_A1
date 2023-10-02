/* 
 * What does Dice do?
 * It is a single dice entity, holds the value of itself. and possesses the capability to compare itself to others
 */
package game;

import java.util.Random;

public class Dice {

	private int value;
	private boolean isLocked;
	public static final int NUMBER_OF_SIDES = 6;
									
	public Dice ()
	{
		value = 0;
		isLocked = false;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int newValue)
	{
		value = newValue;
	}
	
	public void setLock(boolean lockStatus) {
		isLocked = lockStatus;
	}
	
	public boolean getLock() {
		return isLocked;
	}
	
	public void roll(Random roll) {
		if(!isLocked)
			value = roll.nextInt(Dice.NUMBER_OF_SIDES) + 1;
	}
	
	public int compareDice(Dice other)
	{
		return this.getValue() - other.getValue();
	}
}
