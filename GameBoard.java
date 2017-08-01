import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class GameBoard extends JPanel implements ScrabbleConstants {
	private int RECT_X_STATIC = (FRAME_WIDTH - ((NUM_GAME_BOARD_ROWS * TILE_WIDTH) + (NUM_GAME_BOARD_ROWS-1 * TILE_SPACE)))/2;
	private int RECT_X = (FRAME_WIDTH - ((NUM_GAME_BOARD_ROWS * TILE_WIDTH) + (NUM_GAME_BOARD_ROWS-1 * TILE_SPACE)))/2;
	private int RECT_Y = 20;


	private static final int FRAME_WIDTH = 1280;
	private static final int FRAME_HEIGHT = 729;
	private static final int NUM_GAME_BOARD_ROWS = 15;
	private static final int TILE_SPACE = 5;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < NUM_GAME_BOARD_ROWS; i++){
			for(int j = 0; j < NUM_GAME_BOARD_ROWS; j++ ){
				g.drawRect(RECT_X, RECT_Y, TILE_WIDTH, TILE_HEIGHT);
				if(i == j || i == (NUM_GAME_BOARD_ROWS - j-1)) g.setColor(Color.MAGENTA);
				if(((i == 0 || i == 7 || i == 14) && (j == 0 || j == 7 || j == 14))) g.setColor(Color.RED); 
				if(((i == 3 || NUM_GAME_BOARD_ROWS-i-1 == 3) && j==0) || ((j == 3 || NUM_GAME_BOARD_ROWS-j-1 == 3) && i == 0)) g.setColor(Color.blue);
				if(g.getColor() != Color.BLACK) g.fillRect(RECT_X, RECT_Y, TILE_WIDTH, TILE_HEIGHT);
				RECT_X += TILE_SPACE + TILE_WIDTH;
				g.setColor(Color.BLACK);
			}
			RECT_X = RECT_X_STATIC;
			RECT_Y += TILE_SPACE + TILE_HEIGHT;
		}
	}


	public Dimension getPreferredSize() {
		// so that our GUI is big enough
		return new Dimension(TILE_WIDTH + 2 * RECT_X, TILE_HEIGHT + 2 * RECT_Y);
	}

	// create the GUI explicitly on the Swing event thread
	private static void createAndShowGui() {
		GameBoard mainPanel = new GameBoard();

		TileBag tb = new TileBag();
		Tile newTile = tb.getNext();

		JFrame frame = new JFrame("Scrabble");
		newTile.displayImage(frame);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//while(true) {
			frame.getContentPane().add(mainPanel);
			frame.pack();
			frame.setLocationByPlatform(true);
			frame.setVisible(true);
			frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		//}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}