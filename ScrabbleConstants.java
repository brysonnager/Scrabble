/**
 * File: ScrabbleConstants.java
 * -----------------------------
 * This file declares constants that are shared by the different 
 * classes in the Scrabble application. Any class that implements this
 * interface can use these constants
 */

/**
 * @author senecafriend
 *
 */
public interface ScrabbleConstants {
	/*The total number of tiles at the start of a game of Scrabble (excluding blank tiles)*/
	public static final int TOTAL_TILES_IN_GAME = 98;
	
	/*How wide each tile with a letter on it is*/
	public static final int TILE_WIDTH = 26;
	
	/*How tall each tile with a letter on it is*/
	public static final int TILE_HEIGHT = 33;
	
	/*Each player should have 7 tiles at all times*/
	public static final int NUM_TILES_PER_PLAYER = 7;
	
	/*How wide the game board is*/
	public static final int GAME_BOARD_WIDTH = 500;
	
	/*How tall the game board is*/
	public static final int GAME_BOARD_HEIGHT = 500;
}
