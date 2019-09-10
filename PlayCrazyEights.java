import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayCrazyEights {
	
	private static final Map<Integer, Integer> cardsPerPlayerMap = createPlayMap(); 
	
	public static void main(String[] args) {
		
		ArrayList<Player> playerList = new ArrayList<Player>(); 
		CardDeck deck = new CardDeck(); 
		Scanner in = new Scanner(System.in); 
		
		int playerNum; 
		
		while(true) {
			try {
				System.out.println("Welcome to Crazy Eights! How many players are playing? Valid values are 2-7");
				String playerNumStr = in.nextLine(); 
				playerNum = Integer.parseInt(playerNumStr); 
			}
			catch (Exception e){
				System.out.println("Oops! That wasn't a valid number.");
				continue; 
			}
			
			if(playerNum < 2 || playerNum > 7) {
				System.out.println("Oops! You can't play with that many people. 2-6 please!");
				continue; 
			}
			else {
				break; 
			}
		}
		
		while(true) {
			System.out.println("Awesome! Please enter " + playerNum + " names separated by a comma");
			String playerNames = in.nextLine(); 
			
			String [] nameArr = playerNames.split(","); 
			if(nameArr.length != playerNum) {
				System.out.println("Wrong number of names! Try again.");
			}
			else {
				int cardsPerPlayer = cardsPerPlayerMap.get(playerNum); 
				for(String name: nameArr) {
					Player player = new Player(name, deck.dealHandFromDeck(cardsPerPlayer)); 
					playerList.add(player); 
				}
				break; 
			}
		}
		
		int playerTurn = 0; 
		Card currCard = null;
		while(!gameIsOver(playerList)) {
			clearScreen(); 
			Player currPlayer = playerList.get(playerTurn); 
			System.out.println(currPlayer.getName() + ", it is your turn!");
			currPlayer.getHand().displayHandWithValidPlays(currCard);
			currCard = validatePlay(in, deck, currPlayer, playerNum, currCard); 
			
			
			
			while(true) {
				System.out.println("Press R for 'Ready' for next player"); 
				boolean ready = in.nextLine().equals("R") ? true: false; 
				if(ready) break; 
			}
			playerTurn++; 
			
			if(playerTurn == playerNum) {
				playerTurn = 0; 
			}
		}
		
		System.out.println("Game over! Congrats to player " + playerList.get(playerTurn).getName()); 
		
	}
	
	private static Card validatePlay(Scanner in, CardDeck deck, Player currPlayer, int playerNum, Card currCard) {
		int cardToPlay; 
		ArrayList<Integer> validPlayList; 
		while(true) {
			try {
				if(currCard == null) {
					System.out.println("\nFirst turn! Play anything\n"); 
				}
				else {
					System.out.println("\nCurrent Card is " + currCard + "\n"); 
				}

				validPlayList = currPlayer.getHand().getValidPlayList(currCard);
				if(validPlayList.isEmpty()) {
					System.out.println("No Valid Cards to Play! You just drew a card to your hand");
					Card cardDrawn = deck.drawCard(); 
					if(cardDrawn != null) {
						currPlayer.getHand().drawCard(cardDrawn); 
					}
					else {
						System.out.println("Deck is empty... Draw!"); 
						System.exit(0);
					}
					return currCard; 
				}
				System.out.println("Select the number of card to play"); 
				String cardToPlayStr = in.nextLine(); 
				cardToPlay = Integer.parseInt(cardToPlayStr); 
			}
			catch (Exception e){
				System.out.println("Oops! That wasn't a valid number.");
				continue; 
			}
			
			
			if(!validPlayList.contains(cardToPlay)) {
				System.out.println("Oops! That isn't a valid card\n");
				continue; 
			}
			else {
				CardHand hand = currPlayer.getHand(); 
				Card cardPlayed = hand.getCard(cardToPlay);
				hand.playCard(cardToPlay);
				System.out.println("\n" + cardPlayed + " played. Nice choice!\n"); 
				return cardPlayed; 
			}
		}
	}
	private static Map<Integer, Integer> createPlayMap() {
	    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	    
	    map.put(2, 7); 
	    map.put(3, 5); 
	    map.put(4, 4); 
	    map.put(5, 3); 
	    map.put(7, 2); 
	    return map; 
	}
	
	private static void clearScreen() {  
		for(int i = 0; i < 50; i++)
		{
		    System.out.println("\b");
		}
	}
	
	private static boolean gameIsOver(ArrayList<Player> playerList) {
		for(Player player: playerList) {
			if(player.hasWon()){
				return true; 
			}
		}
		return false; 
	}

}
