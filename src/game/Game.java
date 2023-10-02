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

		System.out.println("Player 1's Turn.");
		game.getPlayer(0).playersTurn(roll);
		System.out.println("Player 2's Turn.");		
		game.getPlayer(1).playersTurn(roll);
		game.determineWinner();
	}

	public static void displayHand(Player player)
	{
		player.printDice();

	}

	public static void displayMenu()
	{
		System.out.println("Options: ");
		System.out.println();
		System.out.println("(R)oll Hand");
		System.out.println("(L)ock Dice");
		System.out.println("(S)tay");
		System.out.println();
	}

	public static char readChar(String message)
	{
		char aChar = 0;
		Scanner readUser = new Scanner(System.in);

		System.out.print(message);
		aChar = readUser.next().charAt(0);
		System.out.println();
		System.out.println();

		return aChar;
	}

	
	public static int readInt(String message)
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

		displayHand(player[0]);
		System.out.println("\n\tVS.\n");
		displayHand(player[1]);

		System.out.println("\n");

		if(winner > 0)
			System.out.println("Player 1 wins!");
		else if(winner < 0)
			System.out.println("Player 2 wins!");
		else
			System.out.println("It's a draw!");

	}	
	
	public Player getPlayer(int playerNo) {
		return player[playerNo];
	}
	
}