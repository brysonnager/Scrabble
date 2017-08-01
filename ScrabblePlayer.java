import java.util.ArrayList;

public class ScrabblePlayer implements ScrabbleConstants {

	public ScrabblePlayer(String name, int score, ArrayList<Tile> tiles) {
		playerName = name;
		playerScore = score;
		playerTiles = tiles;
	}

	private String playerName;
	private int playerScore;
	private ArrayList<Tile> playerTiles;
}
