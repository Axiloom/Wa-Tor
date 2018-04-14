/**
 * This class contains the constants used in the WaTor program. These constants 
 * may be changed when testing and so your program should use the constants but 
 * not the values.
 * 
 * @author jimw
 */
public class Config {
	
	/**
	 * Character constants used to show what is in each ocean location.
	 * Use the constants in your code, do not use the literals (e.g., '.', 'O')
	 * in your code.
	 */    
	final static char FISH_MARK = '.';
	final static char SHARK_MARK = 'O';
	final static char WATER_MARK = ' ';
	
	/**
	 * Constant to initialize all the empty locations in the fish,
	 * shark and starve arrays.
	 */
	final static int EMPTY = -1;

	/**
	 * The maximum attempts to try to randomly place a fish or shark.
	 */
	final static int MAX_PLACE_ATTEMPTS = 5;
	
	/**
	 * The width of the population chart.
	 */
	final static int POPULATION_CHART_WIDTH = 50;
	
	/**
	 * The number of history indexes and then the constants for the 
	 * indexes into the history array for chronon, fish and shark numbers.
	 */
	final static int NUM_HISTORY_ITEMS = 3;
	final static int HISTORY_CHRONON_INDEX = 0;
	final static int HISTORY_NUM_FISH_INDEX = 1;
	final static int HISTORY_NUM_SHARKS_INDEX = 2;    
	
	/**
	 * Names of the simulation parameters. Within the program a
	 * parallel int array will have the corresponding values. The same
	 * index to both arrays will refer to the name and value of
	 * a single parameter.
	 */
	final static String [] SIM_PARAMS = {
		"seed", "ocean_width", "ocean_height", "starting_fish", "starting_sharks",
		"fish_breed", "sharks_breed", "sharks_starve" };
	
	/**
	 * Checked within if statements to see whether to print out
	 * debug information or not. Set to true and run the program
	 * to see debug output.
	 */
	final static boolean DEBUG = false;
}