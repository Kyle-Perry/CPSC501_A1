package game;

import java.util.Random;

public class HumanPlayer extends Player{
	
	public HumanPlayer(int diceNum) 
	{
		super(diceNum);
	}
	
	public void playersTurn(Random roll)
	{

		int counter = 0;
		char choice = ' ';
		int diceSelection = 0;

		this.rollDice(roll);
		while(counter < 2)
			{
				System.out.println("Number of rolls remaining: " + (2 - counter));
				Game.displayHand(this);
				for(int i = 0; i < Game.NUMBER_OF_DICE; i++) {
					if (getLockStatus(i))
						System.out.print("LOCKED");
					else
						System.out.print("      ");
					System.out.print("  ");

				}
				System.out.println("  ");

				GameInterface.displayMenu();
				choice = GameInterface.readChar("Please input a selection: ");
				switch(choice)
				{
				case 'R': case'r':
					rollDice(roll);
					counter++;
					break;
				case 'L': case'l':
					diceSelection = GameInterface.readInt("Enter the dice to be locked (1-3): ");
					while(diceSelection < 1 || diceSelection > 3)
					{
						System.out.println("Number outside of accepted range.");
						diceSelection = GameInterface.readInt("Enter the dice to be locked (1-3): ");	
					}
					setLock(diceSelection - 1, !getLockStatus(diceSelection - 1));
					break;
				case 'S': case's':
					return;
				default:
					System.out.println("Invalid selection.");
					break;
				}
			}

		determineHand();
		System.out.println("Your hand is: " + "{" + getADice(0).getValue() + ", " + getADice(1).getValue() + ", " + getADice(2).getValue() + "}");
		System.out.println();
	}

}
