import java.security.SecureRandom;
// Emma Athow CSC 221 HW2

public class TortoiseAndHare {
	
	private static final int MAX_MOVES = 100;
	private static final int MAX_ITERATIONs = 2000;
	
	private static final SecureRandom Random = new SecureRandom();
	
	public static int iterations = 0;
	public static int currentPositionT = 0;
	public static int moveT = 0;
	public static int currentPositionH = 0;
	public static int moveH = 0;

	private int randomBetween(int start, int finish) {
		// returns an integer random number between two limits (inclusive)
		// the hint says to generate a random integer i in the range 0 <= i <= 9
		start = 0;
		finish = 9;
		//SecureRandom random = new SecureRandom();
		int rand = Random.nextInt(10);
		return rand;
	}
	
	private void simulateTortoiseMove() {
		// simulates the movements of the tortoise
		/** note: we need an integer to measure the time, which is equivalent 
		 * to one full iteration, so if we have a for loop it would look like
		 * for(int t=0; t<200; t++), let t be the time and 200 be max iterations */
		/** there will be a lot of similarity between Tortoise and Hare 
		 * only real difference in if statements*/
		//SecureRandom random = new SecureRandom();
		// we name the random integer i to help with our simulations
		//if(currentPositionT >= 0 && currentPositionT < 99) {
		int i = Random.nextInt(10);
		//SecureRandom randomT = new SecureRandom();
		if( i>=0 || i<=3) {
			//jump (1-3) 
			moveT += (1 + Random.nextInt(3));
		}
		if( i>=4 || i<=6) {
			//slip (1-6)
			moveT += -(1 + Random.nextInt(6));
		}
		if( i>=7 || i<=8) {
			//walk (0-1)
			moveT += Random.nextInt(1);
		}
		if( i==9 ) {
			//sleep (no movement)
			moveT += 0;
		}
		
		//}
		currentPositionT += moveT;
	}

	private void simulateHareMove() {
		// simulates the movements of the hare
		//SecureRandom random = new SecureRandom();
		// we name the random integer i to help with our simulations
		//if(currentPositionH >= 0 && currentPositionH < 99) {
		//int i = Random.nextInt(10);
		switch(Random.nextInt(10)) {
		  case 0:
		  case 2:
			//jump (1-5)
		  moveH += (1+ Random.nextInt(5));
		  break;
		  case 3:
		  case 4:
			//small slip (1-2)
		  moveH += (1+ Random.nextInt(2));
		  break;
		  case 5:
		  case 7:
			//walk (0-1)
		  moveH += Random.nextInt(1);
		  break;
		  case 8:
			//big slip (1-7)
		  moveH += (1+ Random.nextInt(7));
		  break;
		  case 9: 
			//sleep (no movement)
		  moveH += 0;
		  break;
		}
		currentPositionH += moveH;
		
	}
	
	private void printPositions() {
		/** Prints the race track and shows the position of the Tortoise 
		 * and Hare. Use the letter T for the tortoise, H for the hare, 
		 * and B if both are on the same square */
		// We want to print the positions of both racers and a boundary line 
		// To print positions:
		int move = 0;
		System.out.println("Iterations: " + iterations);
		if(moveT > moveH) {
			move = moveT - moveH;
			System.out.printf("H");
			for(int i=0; i<move; i++) {
				System.out.printf(" ");
			}
			System.out.printf("T");
		}
		if(moveH > moveT) {
			move = moveH - moveT;
			System.out.printf("T");
			for(int i=0; i<move; i++) {
				System.out.printf(" ");
			}
			System.out.printf("H");
		}
		if(moveT == moveH) {
			move = moveT;
			for(int i=0; i<move; i++) {
				System.out.printf(" ");
			}
			System.out.printf("B");
		}
		System.out.printf("\n");
		System.out.printf("-------------------------------------------------------------");
		
	}
	
	public TortoiseAndHare() {
		/** The default constructor need to have the following:
		 * the start message, both racers' positions (printPositions with simulateTortoiseMove() and 
		 * simulateHareMove()), and the results*/
		iterations = 0;
		currentPositionT = 0;
		moveT = 0;
		currentPositionH = 0;
		moveH = 0;
	System.out.printf("ON YOUR MARK, GET SET");
	System.out.printf("\n");
	System.out.printf("BANG !!!!!");
	System.out.printf("\n");
	System.out.printf("AND THEY'RE OFF !!!!!");
	System.out.printf("\n");
	// printPositions();
	// use a while loop/ if conditionals for next statements
	// until one wins, there is a tie, or it times out:
	// outside of this loop, print results
		while((currentPositionT <= MAX_MOVES) && (currentPositionH <= MAX_MOVES) && (iterations <= MAX_ITERATIONs)) {
			//okay so it must not be renewing the iterations at a certain point which is why the iterations start so large, perhaps it only restarts visible iterations
			System.out.println(" ");
			printPositions();
			simulateTortoiseMove();
			simulateHareMove();
			iterations++;
		}
		if(iterations >= MAX_ITERATIONs) {
			// This happens when the session times out. We still need to print who won
			System.out.printf("Time out!");
			if(currentPositionT >= 99) {
				System.out.printf("\n");
				System.out.printf("TORTOISE WINS !!! YAY !!!");
				System.out.printf("\n");
				System.out.printf("Time Elapsed = " + iterations);
				System.out.printf(" seconds");
			}
			if(currentPositionH >= 99) {
				System.out.printf("\n");
				System.out.printf("Hare wins. Yuch!");
				System.out.printf("\n");
				System.out.printf("Time Elapsed = " + iterations);
				System.out.printf(" seconds");
			}
			if((currentPositionT >= 99) && (currentPositionH >= 99)) {
				System.out.printf("\n");
				System.out.printf("It's a tie");
				System.out.printf("\n");
				System.out.printf("Time Elapsed = " + iterations);
				System.out.printf(" seconds");
			}
		}
		if(currentPositionT >= 99) {
			System.out.printf("\n");
			System.out.printf("TORTOISE WINS !!! YAY !!!");
			System.out.printf("\n");
			System.out.printf("Time Elapsed = " + iterations);
			System.out.printf(" seconds");
		}
		if(currentPositionH >= 99) {
			System.out.printf("\n");
			System.out.printf("Hare wins. Yuch!");
			System.out.printf("\n");
			System.out.printf("Time Elapsed = " + iterations);
			System.out.printf(" seconds");
		}
		if((currentPositionT >= 99) && (currentPositionH >= 99)) {
			System.out.printf("\n");
			System.out.printf("It's a tie");
			System.out.printf("\n");
			System.out.printf("Time Elapsed = " + iterations);
			System.out.printf(" seconds");
		}
	}

	public static void main(String[] args) {
		//Starts the race by creating an instance of class TortoiseAndHare
	TortoiseAndHare tah1 = new TortoiseAndHare();
	}
}
