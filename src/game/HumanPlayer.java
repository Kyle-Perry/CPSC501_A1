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
				GameInterface.displayMessage("Number of rolls remaining: " + (2 - counter)+ "\n\n");
				Game.displayHand(this);
				GameInterface.printLockStatus(dice);

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
						GameInterface.displayMessage("Number outside of accepted range.\n");
						diceSelection = GameInterface.readInt("Enter the dice to be locked (1-3): ");	
					}
					setLock(diceSelection - 1, !getLockStatus(diceSelection - 1));
					break;
				case 'S': case's':
					determineHand();
					GameInterface.displayMessage("Your hand is: " + "{" + getADice(0).getValue() + ", " + getADice(1).getValue() + ", " + getADice(2).getValue() + "}\n\n");
					return;
				default:
					GameInterface.displayMessage("Invalid selection.\n");
					break;
				}
			}

		determineHand();
		GameInterface.displayMessage("Your hand is: " + "{" + getADice(0).getValue() + ", " + getADice(1).getValue() + ", " + getADice(2).getValue() + "}\n\n");
	}

}
