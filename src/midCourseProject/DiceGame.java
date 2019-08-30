package midCourseProject;

public class DiceGame {
	
	//the keepRolling boolean is initially set to true to start playing the game
	static Boolean keepRolling = true;

	public static void main(String[] args) {
		//initializing the POINT int variable to zero before we start the game
		int point = 0;
		//set the point variable to the sum of the first roll of the dice
		point = rollDice();
		//print out the result of the first roll of the dice
		System.out.println(firstTry(point));
		//initializing the sum int variable for the next roll of the dice to zero
		int sum = 0;
		//if we have won or lost, the keepRolling boolean will be set to false
		//otherwise, while keepRolling is still true, we will continue rolling the dice
		while (keepRolling) {
			sum=rollDice();
			System.out.println(continueRolling(point,sum));
		}
	}
	
	//return a random int value between 1 and 6
	public static int rollDie() {
		return 1 + (int)(Math.random() * 6);
	}
	
	//prints a random value between 2 and 12 for the sum of the rolls of two six-sided dice
	//and also returns the int value to be used later
	public static int rollDice() {
		int die1 = rollDie();
		int die2 = rollDie();
		int sum = die1 + die2;
		System.out.println("You rolled "+sum+".");
		return sum;
		
	}
	
	//returns a String that we will print out with the result of the first roll
	//depending on the sum of the first roll of the two dice, passed in as the "point" int value
	//the boolean keepRolling is set to false if we have won or lost
	//otherwise, keepRolling remains true so we will continueRolling
	public static String firstTry(int point) {
		String firstMessage;
		switch(point) {
		case 7:
		case 11: 	
			firstMessage = "You win!";
			keepRolling = false;
			return firstMessage;
		case 2:
		case 3:
		case 12:
			firstMessage = "You lose!";
			keepRolling = false;
			return firstMessage;
		default:
			//redundant, added for testing purposes
			keepRolling=true;
			firstMessage = "POINT is "+point+".";
			return firstMessage;
		}
	}

	//if we did not win on the first roll of the dice, the POINT int value saved from the first roll is passed in
	//along with the sum int value of the next roll
	//returns a String that we will print out with the result of the next roll
	//the boolean keepRolling is set to false if we have won or lost
	//otherwise, keepRolling remains true so we will continueRolling
	public static String continueRolling(int point, int sum) {
		String message;
		if (sum == point) {	
			message = "You win!";
			keepRolling = false;
			return message;
		} else if (sum == 7){
			message = "You lose!";
			keepRolling = false;
			return message;
		}
		else {
			//redundant, added for testing purposes
			keepRolling = true;
			message = "POINT is "+point+".";
			return message;
		}
	}
	
}
