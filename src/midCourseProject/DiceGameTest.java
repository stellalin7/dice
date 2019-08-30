package midCourseProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Given the following rules for the game of dice, 
//create a program that prints out whether you won or lost on each roll. 
//Below are the requirements for this program. 

class DiceGameTest {
	
	private static final long VALUES_TO_TEST = 1000;
	
	private static final int[] firstTryPoint = {4,5,6,8,9,10};
	
	
	@Test
	void testRollDie() {
		for (int i=0; i < VALUES_TO_TEST; i++) {
        	assertTrue(DiceGame.rollDie()>=1);
        	assertTrue(DiceGame.rollDie()<=6);
        }
	}

	//The player rolls two 6-sided dice 
	
	@Test
	void testRollDice() {
		for (int i=0; i < VALUES_TO_TEST; i++) {
        	assertTrue(DiceGame.rollDice()>=2);
        	assertTrue(DiceGame.rollDice()<=12);
        }
	}

	@Test
	void testFirstTry() {
		
		int[] firstTryWin = {7,11};
		int[] firstTryLoss = {2,3,12};
		
		//Rolling 7 or 11 on the first try is a WIN 
		for (int sum:firstTryWin) {
			DiceGame.keepRolling = true;
			assertTrue(DiceGame.firstTry(sum).equals("You win!"));
			assertFalse(DiceGame.keepRolling);
		}
		
		//Rolling 2, 3 or 12 on the first try is a LOSS
		for (int sum:firstTryLoss) {
			DiceGame.keepRolling = true;
			assertTrue(DiceGame.firstTry(sum).equals("You lose!"));
			assertFalse(DiceGame.keepRolling);
		}
		
		
		//Any other roll on the first try becomes the player's POINT 
		for (int sum:firstTryPoint) {
			DiceGame.keepRolling = false;
			assertTrue(DiceGame.firstTry(sum).equals("POINT is "+sum+"."));
			assertTrue(DiceGame.keepRolling);
		}

	}
	//If a player rolled POINT, the player continues to roll until one of two things happens: 
	//If a player has POINT and rolls 7, it is a LOSS
	//If a player has POINT and rolls the POINT again, it is a WIN
	
	//Example run:
	//You rolled 4. POINT is 4.
	//You rolled 3. POINT is 4.
	//You rolled 11. POINT is 4.
	//You rolled 4.
	//You win!
	@Test
	void testContinueRolling() {
		
		for (int point:firstTryPoint) {
			DiceGame.keepRolling = true;
			assertTrue(DiceGame.continueRolling(point, 7).equals("You lose!"));
			assertFalse(DiceGame.keepRolling);
		}
		
		for (int point:firstTryPoint) {
			DiceGame.keepRolling = true;
			assertTrue(DiceGame.continueRolling(point, point).equals("You win!"));
			assertFalse(DiceGame.keepRolling);
		}
		
		int[] keepRolling4= {2,3,5,6,8,9,10,11,12};
		
		for (int point:keepRolling4) {
			DiceGame.keepRolling = false;
			assertTrue(DiceGame.continueRolling(4, point).equals("POINT is 4."));
			assertTrue(DiceGame.keepRolling);
		}
		
		int[] keepRolling5= {2,3,4,6,8,9,10,11,12};
		
		for (int point:keepRolling5) {
			DiceGame.keepRolling = false;
			assertTrue(DiceGame.continueRolling(5, point).equals("POINT is 5."));
			assertTrue(DiceGame.keepRolling);
		}
		
		int[] keepRolling6= {2,3,4,5,8,9,10,11,12};
		
		for (int point:keepRolling6) {
			DiceGame.keepRolling = false;
			assertTrue(DiceGame.continueRolling(6, point).equals("POINT is 6."));
			assertTrue(DiceGame.keepRolling);
		}
		
		int[] keepRolling8= {2,3,4,5,6,9,10,11,12};
		
		for (int point:keepRolling8) {
			DiceGame.keepRolling = false;
			assertTrue(DiceGame.continueRolling(8, point).equals("POINT is 8."));
			assertTrue(DiceGame.keepRolling);
		}
		
		
		int[] keepRolling9= {2,3,4,5,6,8,10,11,12};
		
		for (int point:keepRolling9) {
			DiceGame.keepRolling = false;
			assertTrue(DiceGame.continueRolling(9, point).equals("POINT is 9."));
			assertTrue(DiceGame.keepRolling);
		}
		
		int[] keepRolling10= {2,3,4,5,6,8,9,11,12};
		
		for (int point:keepRolling10) {
			DiceGame.keepRolling = false;
			assertTrue(DiceGame.continueRolling(10, point).equals("POINT is 10."));
			assertTrue(DiceGame.keepRolling);
		}
		
	}

}
