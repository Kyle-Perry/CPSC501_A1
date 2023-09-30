package game;

import java.util.Random;
import java.util.Scanner;

/*	Kyle Perry
 * 
 *  Q: What does this program do?
 *  A: Plays a game of poker dice against the program using three dice. Higher faces are worth more in scoring, and paira and triple worth more in succession
 *  The player gets 3 rounds to try to get as good a hand as possible. During each round the player can choose to lock any number of dice before rolling to keep
 *  the current value of the dice. Once a die is locked, however, it cannot be unlocked, so a player must be sure they want to beforehand.
 * 
 * 	This is the game class, this handles all of the games functionality(including what is displayed to the user(s)
 * 	Using functions found in Hand and Dice it allows the player to select from 1 of 3 options to determine their hand in a game of poker dice!
 * 	Also has the function of determining the winner of the game
 */
public class Game {

	private Player[] player;
	public static final int NUMBER_OF_DICE = 3;
	public Game()
	{
		player = new Player[2];
		player[0]= new Player(NUMBER_OF_DICE, false);
		player[1]= new Player(NUMBER_OF_DICE, true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random roll = new Random();
		Game game = new Game();

		game.playersTurn(0, roll);
		game.playersTurn(1, roll);
		game.determineWinner();
	}

	public void displayHand(int playerNumber)
	{
		player[playerNumber].printDice();

	}

	public void displayMenu()
	{
		System.out.println("Options: ");
		System.out.println();
		System.out.println("(R)oll Hand");
		System.out.println("(L)ock Dice");
		System.out.println("(S)tay");
		System.out.println();
	}

	public char readChar(String message)
	{
		char aChar = 0;
		Scanner readUser = new Scanner(System.in);

		System.out.print(message);
		aChar = readUser.next().charAt(0);
		System.out.println();
		System.out.println();

		return aChar;
	}

	public void playersTurn(int playerNo, Random roll)
	{
		int pairValue = 0;
		int singleValue = 0;
		int rank = 0;

		int counter = 0;
		boolean stay = false;
		char choice = ' ';
		int diceSelection = 0;

		player[playerNo].rollDice(roll);
		System.out.println("Player " + (playerNo + 1) + "'s Turn.");

		if(player[playerNo].getIsHuman())
		{
			while(counter < 2 && !stay)
			{
				System.out.println("Number of rolls remaining: " + (2 - counter));
				displayHand(playerNo);
				for(int i = 0; i < NUMBER_OF_DICE; i++) {
					if (player[playerNo].getLock(i))
						System.out.print("LOCKED");
					else
						System.out.print("      ");
					System.out.print("  ");

				}
				System.out.println("  ");

				displayMenu();
				choice = readChar("Please input a selection: ");
				switch(choice)
				{
				case 'R': case'r':
					player[playerNo].rollDice(roll);
					counter++;
					break;
				case 'L': case'l':
					diceSelection = readInt("Enter the dice to be locked (1-3): ");
					while(diceSelection < 1 || diceSelection > 3)
					{
						System.out.println("Number outside of accepted range.");
						diceSelection = readInt("Enter the dice to be locked (1-3): ");	
					}
					player[playerNo].setLock(diceSelection - 1, !player[playerNo].getLock(diceSelection - 1));
					break;
				case 'S': case's':
					stay = true;
					break;
				default:
					System.out.println("Invalid selection.");
					break;
				}
			}


		}
		else
		{
			player[playerNo].determineHand();
			pairValue = player[playerNo].getPairValue();
			singleValue = player[playerNo].getHighestSingle();
			rank = player[playerNo].getRank();

			while(counter < 2) {
				if(rank == 2)
				{
					for(int x = 0; x < NUMBER_OF_DICE; x++) {
						if(player[playerNo].getADice(x).getValue() == pairValue)
							player[playerNo].setLock(x, true);
					}
				}
				if(rank == 1)
				{
					if(pairValue > 3) {
						for(int x = 0; x < NUMBER_OF_DICE; x++) {
							if(player[playerNo].getADice(x).getValue() == pairValue)
								player[playerNo].setLock(x, true);
						}
					}
				}
				else if(singleValue > 4) {
					for(int x = 0; x < NUMBER_OF_DICE; x++) {
						if(player[playerNo].getADice(x).getValue() == singleValue)
							player[playerNo].setLock(x, true);
					}
				}

				player[playerNo].rollDice(roll);	
				counter++;
			}
		}

		player[playerNo].determineHand();
		System.out.println("Your hand is: " + "{" + player[playerNo].getADice(0).getValue() + ", " + player[playerNo].getADice(1).getValue() + ", " + player[playerNo].getADice(2).getValue() + "}");
		System.out.println();
	}


	public int readInt(String message)
	{
		int anInt = 0;
		boolean success = false;
		Scanner readUser = new Scanner(System.in);

		while(!success)
		{
			System.out.print(message);
			if(readUser.hasNextInt())
			{
				success = true;
				anInt = readUser.nextInt();
				System.out.println();
			}
			else
			{
				System.out.println();
				System.out.println("Invalid input.");
				readUser.next();
			}
		}

		return anInt;
	}

	public void determineWinner()
	{

		int winner;

		winner = player[0].compareHands(player[1]);

		System.out.println();

		displayHand(0);
		System.out.println("\n\tVS.\n");
		displayHand(1);

		System.out.println("\n");

		if(winner > 0)
			System.out.println("Player 1 wins!");
		else if(winner < 0)
			System.out.println("Player 2 wins!");
		else
			System.out.println("It's a draw!");

	}	

}