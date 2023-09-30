/* 
 * What does Dice do?
 * It is a single dice entity, holds the value of itself. and possesses the capability to compare itself to others
 */
package game;

public class Dice {

	private int value;
	
	public Dice ()
	{
		value = 1;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int newValue)
	{
		value = newValue;
	}
	
	public int compareDice(Dice other)
	{
		if( this.value > other.getValue() ) {
			return 1;
		}
		else if( this.value == other.getValue() ) {
			return 0;
		}
		return -1;
	}
	
	public String printFirst() {
		switch(value)
		{
			case 1:
			return "|     |";
			case 2:
			case 3:
				return "|o    |";
			default:
				return "|o   o|";
		}
	}
	
	public String printSecond() {
		switch(value)
		{
			case 1:
			case 3:
			case 5:
				return "|  o  |";
			case 2:
			case 4:
				return "|     |";
			default:
				return "|o   o|";
		}
	}
	
	public String printThird() {
		switch(value)
		{
			case 1:
			return "|     |";
			case 2:
			case 3:
				return "|    o|";
			default:
				return "|o   o|";
		}
	}
}
