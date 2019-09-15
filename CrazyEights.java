import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author abbykrishnan
 * CrazyEights class that has the game mechanics to play
 */
public class CrazyEights {
	
	private static final Map<Integer, Integer> cardsPerPlayerMap = createPlayMap(); 
	private ArrayList<Player> playerList; 
	private CardDeck deck; 
	private int playerNum; 
	
	/**
	 * CrazyEights object that represents a game 
	 * @param playerList list of the players 
	 */
	public CrazyEights(ArrayList<Player> playerList) {
		this.playerList = playerList; 
		deck = new CardDeck(); 
		this.playerNum = 0; 
	}
	
	/**
	 * Gets deck
	 * @return CardDeck 
	 */
	public CardDeck getDeck() {
		return deck; 
	}
	
	/**
	 * Gets players
	 * @return player list 
	 */
	public ArrayList<Player> getPlayers() {
		return playerList; 
	}
	
	/**
	 * Gets number of players 
	 * @return number of players 
	 */
	public int getPlayerNum() {
		return playerNum; 
	}
	
	/**
	 * Prompts for user input to get the number of players 
	 * @param in Scanner object 
	 */
	public void setPlayerNumber(Scanner in) {
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
		this.playerNum = playerNum; 
	}
	
	/**
	 * Sets up the player list by prompting for the correct number of names of Players 
	 * @param in Scanner object
	 */
	public void setUpPlayerList(Scanner in) {
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
					this.playerList.add(player); 
				}
				break; 
			}
		}
	}
	
	/**
	 * Starts the game mechanics, by simulating each round. 
	 * @param in Scanner object
	 */
	public void startGame(Scanner in) {
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
				boolean ready = in.nextLine().equalsIgnoreCase("r") ? true: false; 
				if(ready) break; 
			}
			playerTurn++; 
			
			if(playerTurn == playerNum) {
				playerTurn = 0; 
			}
		}
		Player lastPlayer = playerTurn - 1 == -1 ? playerList.get(0) : playerList.get(playerTurn-1); 
		System.out.println("Game over! Congrats to player " + lastPlayer.getName()); 
	}
	
	/**
	 * Simulates the actual playing of the game
	 * @param in Scanner object
	 * @param deck CardDeck in use 
	 * @param currPlayer current player who's turn it is
	 * @param playerNum number of player
	 * @param currCard current card played down 
	 * @return Card that gets played 
	 */
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
	
	/**
	 * Fills the map that maps the number of players to the number of cards they get 
	 * @return Map
	 */
	private static Map<Integer, Integer> createPlayMap() {
	    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	    
	    map.put(2, 7); 
	    map.put(3, 5); 
	    map.put(4, 4); 
	    map.put(5, 3); 
	    map.put(7, 2); 
	    return map; 
	}
	
	/**
	 * Prints out new lines to clear the terminal 
	 */
	private static void clearScreen() {  
		for(int i = 0; i < 50; i++)
		{
		    System.out.println("\b");
		}
	}
	
	/**
	 * Determines if someone has won the game 
	 * @param playerList list of players 
	 * @return true if someone has won
	 */
	private boolean gameIsOver(ArrayList<Player> playerList) {
		for(Player player: playerList) {
			if(player.hasWon()){
				return true; 
			}
		}
		return false; 
	}


}
