import java.util.*;
import java.util.Random;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class TileBag implements ScrabbleConstants{

	/*in the constructor for TileBag, there needs to be a tile */
	public TileBag() { 
		letterDistribution = new HashMap<String, Integer>();
		letterPoints = new HashMap<String, Integer>();
		tilesLeftInBag = new HashMap<String, Integer>();
		tilesLeft = new ArrayList<Tile>();
		
		/*Reads from a file and fills in the letterDistribution and letterPoints maps*/
		try {
			BufferedReader rd = new BufferedReader(new FileReader("LetterFreqAndPts.txt"));
			String letter = "";
			int frequency = 0;
			int pointValue = 0;
			while(true){
				String line = rd.readLine();
				if(line == null) break;
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()){
					letter = st.nextToken();
					frequency = Integer.parseInt((st.nextToken()));
					pointValue = Integer.parseInt((st.nextToken()));
					letterDistribution.put(letter, frequency);
					letterPoints.put(letter, pointValue);
				}
			}
			rd.close();
		}
		
		catch(IOException ex){
		}
		
		
		/*Fill in the lettersOfAlphabet array with each letter of the alphabet*/
		int index = 0;
		for(char ch = 'A'; ch <= 'Z'; ch++){
			String str = Character.toString(ch);
			lettersOfAlphabet[index] = str;
			index++;
		}
		
		/*Goes through each letter of the alphabet and makes as many number of tiles as it says it
		 * frequents in the letterDistribution map and adds all the tiles to the tilesLeft 
		 * arrayList*/
		
		for(int i = 0; i < 26; i++){
			String letter = lettersOfAlphabet[i];
			int freq = letterDistribution.get(letter);
			int pointVal = letterPoints.get(letter);
			for(int j = 0; j < freq; j++){
				Tile newTile = new Tile(letter,pointVal);
				tilesLeft.add(newTile);
			}
			tilesLeftInBag.put(letter, freq);	//the tilesInBag starts out the same as letterDistribution
		}
	}
	
	
	/*getNext() method should randomly choose a tile from tilesLeft
	 * should then decrement the frequency of that tile in tilesLeftInBag
	 * return the tile that it chose randomly
	 */
	public Tile getNext(){
		/*Random rn = new Random();
		int numTiles = tilesLeft.size();
		int randomNum = rn.nextInt(numTiles+1);	//generate a random number from 0 to numTiles inclusive
		Tile randomTile = tilesLeft.get(randomNum);	//access the randomly selected tile in the bag
		tilesLeft.remove(randomNum);	//remove the randomly selected tile from the bag
		
		String tileLetter = randomTile.getString();	//gets the letter on the tile
		int oldFreq = tilesLeftInBag.get(tileLetter);	//gets how many of that tile used to be
		tilesLeftInBag.replace(tileLetter, oldFreq-1);	//replaces that value with the decremented value
		return randomTile;	//returns the randomly selected tile*/
		return tilesLeft.get(1);
	}
	
	/*Maps from the letter to its frequency according to the Scrabble letter distribution chart*/
	private HashMap<String,Integer> letterDistribution;
	
	/*Maps from the letter to its associated point value*/
	private HashMap<String,Integer> letterPoints;
	
	/*Maps from the string for tile object to the amount of that specific tile left in the bag*/
	private HashMap<String, Integer> tilesLeftInBag;
	
	/*Contains a list of all the letters left available to be chosen*/
	private ArrayList<Tile> tilesLeft;
	
	/*Contains all the letters of the alphabet*/
	private String[] lettersOfAlphabet = new String[26];
}
