//
//FIXME  file header comment

//
/**
 * This file contains testing methods for the WaTor project.
 * These methods are intended to serve several objectives:
 * 1) provide an example of a way to incrementally test your code
 * 2) provide example method calls for the WaTor methods
 * 3) provide examples of creating, accessing and modifying arrays
 *    
 * Toward these objectives, the expectation is that part of the 
 * grade for the WaTor project is to write some tests and
 * write header comments summarizing the tests that have been written. 
 * Specific places are noted with TODO but add any other comments 
 * you feel would be useful.
 * 
 * Some of the provided comments within this file explain
 * Java code as they are intended to help you learn Java.  However,
 * your comments and comments in professional code, should
 * summarize the purpose of the code, not explain the meaning
 * of the specific Java constructs.
 *    
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * This class contains a few methods for testing methods in the WaTor
 * class as they are developed. These methods are all private as they are only
 * intended for use within this class.
 * 
 * @author Jim Williams
 * @author TODO add your name here when you add tests and comment the tests
 *
 */
public class TestWaTor {
	
	/**
	 * This is the main method that runs the various tests. Uncomment the tests
	 * when you are ready for them to run.
	 * 
	 * @param args  (unused)
	 */
	public static void main(String []args) {

		//milestone 1
		testClearMoves();
		testEmptyArray();
		testCountCreatures();
		
		//The best way to test the following is probably to compare
		//output with the examples.
		//showFishAndSharks
		//placeFish        
		//placeSharks      
	   
		//milestone 2
		testUnoccupiedPositions();
		testChooseMove();
		//testFishPositions();
		
		//test code for fishPositions would be similar to test code for unoccupiedPositions
		//test fishSwimAndBreed and sharksHuntAndBreed may be easiest
		//by comparing output to examples.
		
		//milestone 3
		//comparing results of either inputting from or outputting to files
		//may be the easiest way to test.
	}
	
	/**
	 * Compares the lists to see if they are the same size and contain the same elements.
	 * @param list1 One list of coordinates.
	 * @param list2 Another list of coordinates
	 * @return Whether the lists contain the same coordinates or not.
	 */
	private static boolean matchingArrayLists(ArrayList<int[]>list1, ArrayList<int[]>list2) {
		
		boolean result = true;
		
		if (list1.size() != list2.size()) {
			System.err.println("list1 size: " + list1.size() + " list2 size:" + list2.size() + " should be the same");
			 result = false;
			 return result;
		} 
		for (int i = 0; i < list1.size(); i++) {
			int[]move1 = list1.get(i);
			int[]move2 = list2.get(i);
			if (move1[0] == move2[0] && move1[1] == move2[1]) {
				//ok
			} 
			else {
				result = false;
				System.err.println( "list1("+ i+"):" + Arrays.toString(move1) + " doesn't match in list2("+ i+"): " + Arrays.toString(move2));
			   
				break;
			}
		}
		return result;
	}
	
	/**
	 * This runs some tests on the unoccupiedPositions method. 
	 * 1. Checks to see if all spaces around fish[row][col] are empty and are then stored into unoccupied arraylist
	 * 2. This test should only only store 3 arrays into unoccupied arraylist
	 * 3. This test is checking to make sure that the board loops to the other side
	 * 4. This test should never store positions into unoccupied because fish[][] is full
	 * 5. Same as above
	 * 6. Same as above
	 * 7. There is only 1 empty place on fish[][] and this test should not store any positions into unoccupied
	 * 8. Same as above
	 * 9. This will should store one position into unoccupied
	 */
	private static void testUnoccupiedPositions() {
		boolean error = false;
		
		// TEST 1
		// Creates a fish array (board) with one fish being age 0
		int [][]fish = new int[][]{{-1,-1,-1},{-1,0,-1},{-1,-1,-1}};
		// Creates a shark array (board) with no sharks present
		int [][]sharks = new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
		
		// Creates an arraylist to hold the positions of where there are no fish or shark surrounding that position
		ArrayList<int[]> positions = WaTor.unoccupiedPositions( fish, sharks, 1, 1);
		// Creates an arraylist that matches what we want positions to look like
		ArrayList<int[]>expected = new ArrayList<>();
		expected.add( new int[]{0,1});
		expected.add( new int[]{2,1});
		expected.add( new int[]{1,0});
		expected.add( new int[]{1,2});
		
		// Checks to see if the positions array list mathes the expected array list
		if (!matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 1 :" );
		}
		// Test 2
		positions = WaTor.unoccupiedPositions( fish, sharks, 0, 1);
		expected = new ArrayList<>();
		expected.add( new int[]{2,1});
		expected.add( new int[]{0,0});
		expected.add( new int[]{0,2});
		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 2 :" );
		}
		// Test 3
		positions = WaTor.unoccupiedPositions( fish, sharks, 0, 0);
		expected = new ArrayList<>();
		expected.add( new int[]{2,0});
		expected.add( new int[]{1,0});
		expected.add( new int[]{0,2});
		expected.add( new int[]{0,1});
		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 3 :" );
		}        
		
		// Test 4
		fish = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
		sharks = new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
		
		positions = WaTor.unoccupiedPositions( fish, sharks, 1, 1);
		expected = new ArrayList<>();
		
		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 4 :" );
		}
		// Test 5
		positions = WaTor.unoccupiedPositions( fish, sharks, 0, 1);
		expected = new ArrayList<>();
	
		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 5 :" );
		}
		
		// Test 6
		positions = WaTor.unoccupiedPositions( fish, sharks, 0, 0);
		expected = new ArrayList<>();

		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 6 :" );
		}  
		
		// Test 7      
		fish = new int[][]{{0,0,0},{-1,0,0},{0,0,0}};
		sharks = new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
		
		positions = WaTor.unoccupiedPositions( fish, sharks, 1, 1);
		expected = new ArrayList<>();
		expected.add( new int[]{1,0});

		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 7 :" );
		}
		
		// Test 8
		positions = WaTor.unoccupiedPositions( fish, sharks, 0, 1);
		expected = new ArrayList<>();
		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 8 :" );
		}
		
		// Test 9
		positions = WaTor.unoccupiedPositions( fish, sharks, 0, 0);
		expected = new ArrayList<>();
		expected.add( new int[]{1,0});
		if ( !matchingArrayLists( expected, positions)) {
			error = true;
			System.err.println("testUnoccupiedPositions 9 :" );
		}
		
		// Checks to see if test passed
		if ( error) {
			// If test failed, print failed
			System.err.println("testUnoccupiedPositions failed");
		} else {
			// If test passed, print passed
			System.out.println("testUnoccupiedPositions passed");            
		}
	}
	
	/**
	 * This runs some tests on the fishPositions method. 
	 * 1. TODO describe each test in your own words. 
	 * 2.
	 */
	private static void testFishPositions() {
		
		//TODO Implement in Milestone 2
	}
	
	/**
	 * This runs some tests on the chooseMove method. 
	 * 1. TODO describe each test in your own words. 
	 * 2.
	 */    
	private static void testChooseMove() {
		boolean error = false;
		Random randGen = new Random();
		randGen.setSeed(456);
		
		
		// TEST 0
		ArrayList<int[]> input = new ArrayList<>();
		int [] expected = null;
		int [] result = WaTor.chooseMove(input, randGen);
		if (result != expected) {
			error = true;
			System.err.println("testChooseMove 0: result not null");
		}
		
		// TEST 1 (passes)
		input.clear();
		int [] oneMove = new int[] {0,1};
		input.add(oneMove);
		expected = oneMove;
		result = WaTor.chooseMove( input, randGen);
		if ( result != expected) {
			error = true;
			System.err.println("testChooseMove 1: result not " + Arrays.toString( oneMove));
		}
		
		// TEST 2
		input.clear();
		int [] move1 = new int[] {0,1};
		int [] move2 = new int[] {1,0};
		input.add(move1);
		input.add(move2);
		int move1Count = 0;
		int move2Count = 0;
		int numTrials = 1000; // Iterates through input 1000 times
		for (int i = 0; i < numTrials; i++) {
			result = WaTor.chooseMove( input, randGen);
			if ( result == move1) move1Count++;
			else if ( result == move2) move2Count++;
		}
		if ( move1Count != 513 || move2Count != 487 ) {
			error = true;
			System.err.println("testChooseMove 2: expected 513,487 move1Count=" + move1Count + " move2Count=" + move2Count);
		}
		
		// TEST 3
		input.clear();
		move1 = new int[] {0,1};
		move2 = new int[] {1,0};
		int[] move3 = new int[] {2,1};
		input.add( move1);
		input.add( move2);
		input.add( move3);
		move1Count = 0;
		move2Count = 0;
		int move3Count = 0;
		numTrials = 1000;
		for ( int i = 0; i < numTrials; i++) {
			result = WaTor.chooseMove( input, randGen);
			if ( result == move1) move1Count++; 
			else if ( result == move2) move2Count++;
			else if ( result == move3) move3Count++;
		}
		if ( move1Count != 325 || move2Count != 341 || move3Count != 334 ) {
			error = true;
			System.err.println("testChooseMove 3: expected 325,341,334 move1Count=" + move1Count + " move2Count=" + move2Count + " move3Count=" + move3Count);
		}
		
		// TEST 4
		input.clear();
		move1 = new int[] {0,1};
		move2 = new int[] {1,0};
		move3 = new int[] {2,1};
		int []move4 = new int[] {1,2};
		input.add( move1);
		input.add( move2);
		input.add( move3);
		input.add( move4);
		move1Count = 0;
		move2Count = 0;
		move3Count = 0;
		int move4Count = 0;
		numTrials = 1000;
		for ( int i = 0; i < numTrials; i++) {
			result = WaTor.chooseMove( input, randGen);
			if ( result == move1) move1Count++; 
			else if ( result == move2) move2Count++;
			else if ( result == move3) move3Count++;
			else if ( result == move4) move4Count++;
		}
		if ( move1Count != 273 || move2Count != 231 || move3Count != 234 || move4Count != 262 ) {
			error = true;
			System.err.println("testChooseMove 4: expected 325,341,334,262 move1Count=" + move1Count + " move2Count=" + move2Count + " move3Count=" + move3Count + " move4Count=" + move4Count);
		}

		if ( error) {
			System.err.println("testChooseMove failed");
		} else {
			System.out.println("testChooseMove passed");            
		}
	}
	
	/**
	 * This runs some tests on the clearMoves method. 
	 * 1. TODO describe each test in your own words. 
	 *
	 * Test 1: Tests to see if a boolean array full of 'true' all change to 'false'
	 * 
	 */        
	private static void testClearMoves() {
		
		boolean error = false;
		
		// Creates a 2D boolean array
		boolean [][] moves = new boolean[4][9];
		
		// Assigns true to every index of the array
		for (int row = 0; row < moves.length; row++) {
			for (int col = 0; col < moves[row].length; col++) {
				moves[row][col] = true;
			}
		}     
		   
		// Calls clearMoves from WaTor that changes every element of the index to false
		WaTor.clearMoves(moves);
		
		// Checks to see if clearMoves actually changes the array elements to false
		for (int row = 0; row < moves.length; row++) {
			for (int col = 0; col < moves[row].length; col++) {
				if ( moves[row][col]) {
					System.err.println("testClearMoves 0: move " + row + "," + col + " not false");
					error = true;
					break;
				}
			}
		}  
		
		// Prints whether the test passed or not
		if ( error) {
			System.err.println("testClearMoves failed");
		} else {
			System.out.println("testClearMoves passed");            
		}        
	}
	
	/**
	 * This runs some tests on the emptyArray method. 
	 * 1. TODO describe each test in your own words. 
	 *
	 * Test 1: fills an array with 1's than passes the method into EmptyArray to be 'emptied'. The test will check to see if the array was actually emptied.
	 * 
	 */        
	private static void testEmptyArray() {
		
		
		boolean error = false;
		
		// Creates int array
		int [][] moves = new int[100][99];
		
		// Assigns 1 to every index of the array
		for (int row = 0; row < moves.length; row++) {
			for (int col = 0; col < moves[row].length; col++) {
				moves[row][col] = Config.EMPTY + 2; //make sure not EMPTY
			}
		}    
		
		// Passes the array to emptyArray method in WaTor, which emptys the array  
		WaTor.emptyArray(moves);
		
		// Checks to see if the array is empty. If not, print error message
		for (int row = 0; row < moves.length; row++) {
			for (int col = 0; col < moves[row].length; col++) {
				if ( moves[row][col] != Config.EMPTY) {
					System.err.println("testEmptyArray 0: move " + row + "," + col + " not EMPTY");
					error = true;
					break;
				}
			}
		}   
		
		// Prints whether the test passed or not
		if ( error) {
			System.err.println("testEmptyArray failed");
		} else {
			System.out.println("testEmptyArray passed");            
		}            
	}
	
	/**
	 * This runs some tests on the countFish method. 
	 * 1. TODO describe each test in your own words. 
	 * 
	 * Test 1: Checks to how many fish are in an array.
	 * 
	 */        
	private static void testCountCreatures() {
		
		boolean error = false;

		// Creates an empty array of integers for fish
		int[][] fish = new int[7][3];
		
		// Passes the array to emptyArray to make sure it is clear
		WaTor.emptyArray(fish);
		
		// Assigns numbers to array to represent fish
		fish[0][0] = 1;
		fish[6][2] = 2;
		fish[0][2] = 3;
		fish[6][0] = 4;
		fish[3][1] = 5;
		
		// passes array into countCreates to see how many fish there are and assigns that number to result
		int result = WaTor.countCreatures(fish);
		
		// There are originally 5 fish, this will check to see if there are 5 fish assigned to result.
		if (result != 5) {
			System.err.println("testCountCreatures 0: expected 5 found " + result );
			error = true;
		}

		// Prints whether the test passed or not
		if (error) {
			System.err.println("testCountCreatures failed");
		} else {
			System.out.println("testCountCreatures passed");            
		}              
	}

}