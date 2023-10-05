package game;

import java.util.Scanner;

public class GameInterface {

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


	public static void displayMenu()
	{
		System.out.println("Options: ");
		System.out.println();
		System.out.println("(R)oll Hand");
		System.out.println("(L)ock Dice");
		System.out.println("(S)tay");
		System.out.println();
	}
	
	public static void displayMessage(String message) {
		System.out.print(message);
	}
	
	public static void printDice(Dice[] dice) {
		for(int x = 0; x < dice.length; x++){
			System.out.print(" -----    ");
		}
		System.out.println();
		for(Dice aDice: dice){
			System.out.print(printDiceFirst(aDice) + "   ");
		}
		System.out.println();
		for(Dice aDice: dice){
			System.out.print(printDiceSecond(aDice) + "   ");
		}
		System.out.println();
		for(Dice aDice: dice){
			System.out.print(printDiceThird(aDice) + "   ");
		}
		System.out.println();
		for(int x = 0; x < dice.length; x++){
			System.out.print(" -----    ");
		}
		System.out.println("\n");

	}
	
	public static void printLockStatus(Dice[] dice) {
		for(int i = 0; i < Game.NUMBER_OF_DICE; i++) {
			if (dice[i].getLock())
				System.out.print("LOCKED ");
			else
				System.out.print("       ");
			System.out.print("   ");

		}
		System.out.println();
	}
	
	private static String printDiceFirst(Dice dice) {
		switch(dice.getValue())
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
	
	private static String printDiceSecond(Dice dice) {
		switch(dice.getValue())
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
	
	private static String printDiceThird(Dice dice) {
		switch(dice.getValue())
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
