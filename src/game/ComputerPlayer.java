package game;

import java.util.Random;

public class ComputerPlayer extends Player{
	
	public ComputerPlayer(int diceNum) 
	{
		super(diceNum);
	}
	
	public void playersTurn(Random roll) {

		int pairValue = 0;
		int singleValue = 0;
		int rank = 0;
		int counter = 0;
		
		this.rollDice(roll);
		determineHand();
		pairValue = getPairValue();
		singleValue = getHighestSingle();
		rank = getRank();

		while(counter < 2) {
			if(rank == Game.THREE_OF_A_KIND)
			{
				for(int x = 0; x < Game.NUMBER_OF_DICE; x++) {
					if(getADice(x).getValue() == pairValue)
						setLock(x, true);
				}
			}
			if(rank == Game.PAIR)
			{
				if(pairValue > 3) {
					for(int x = 0; x < Game.NUMBER_OF_DICE; x++) {
						if(getADice(x).getValue() == pairValue)
							setLock(x, true);
					}
				}
			}
			else if(singleValue > 4) {
				for(int x = 0; x < Game.NUMBER_OF_DICE; x++) {
					if(getADice(x).getValue() == singleValue)
						setLock(x, true);
				}
			}

			rollDice(roll);	
			counter++;
		}
	}

}
