import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayCrazyEights {
	
	
	public static void main(String[] args) {
		
		ArrayList<Player> playerList = new ArrayList<Player>(); 
		CardDeck deck = new CardDeck(); 
		CrazyEights game = new CrazyEights(playerList); 

		Scanner in = new Scanner(System.in); 
		game.setPlayerNumber(in);
		game.setUpPlayerList(in);
		game.startGame(in);
	}
	

}
