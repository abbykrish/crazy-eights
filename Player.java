
/**
 * @author abbykrishnan
 * Player class that represents a player in a card game 
 */
public class Player {
	
	private String name; 
	private CardHand hand; 
	
	/**
	 * Constructor for player
	 * @param name name of player
	 * @param hand hand for the player 
	 */
	public Player(String name, CardHand hand) {
		this.name = name; 
		this.hand = hand; 
	}
	
	/**
	 * Gets name
	 * @return name 
	 */
	public String getName() {
		return name; 
	}
	
	/**
	 * Gets hand
	 * @return CardHand object 
	 */
	public CardHand getHand() {
		return hand; 
	}
	
	/**
	 * Sets name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name; 
	}
	
	/**
	 * Set hand 
	 * @param hand CardHand object
	 */
	public void setHand(CardHand hand) {
		this.hand = hand; 
	}
	
	/**
	 * Figures out if player has won 
	 * @return Winning boolean
	 */
	public boolean hasWon() {
		return hand.handIsEmpty(); 
	}

}
