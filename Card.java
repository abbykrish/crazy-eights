
/**
 * @author abbykrishnan
 * Card class that represents one card in a 52 card deck
 */
public class Card {

	private String suit; 
	private String value; 
	private boolean inGamePlay; 
	
	/**
	 * Constructor for Card 
	 * @param suit Card suit
	 * @param value Value on card
	 */
	public Card(String suit, String value) {
		this.suit = suit; 
		this.value = value; 
		this.inGamePlay = false; 
	}
	
	/**
	 * Gets card suit 
	 * @return card suit 
	 */
	public String getSuit() {
		return suit; 
	}
	
	/**
	 * Gets card value
	 * @return card value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Gets whether the card is currently in play
	 * @return inGameStatus
	 */
	public boolean getGameStatus() {
		return inGamePlay;
	}
	
	/**
	 * Sets the card suit
	 * @param suit
	 */
	public void setSuit(String suit) {
		this.suit = suit; 
	}
	
	/**
	 * Sets the card value
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Sets the in game status
	 * @param inGamePlay
	 */
	public void setGameStatus(boolean inGamePlay) {
		this.inGamePlay = inGamePlay;
	}
	
	/**
	 * Returns string representation of a card
	 */
	public String toString() {
		return value + " of " + suit; 
	}
	
	/**
	 * Computes crazy eight win logic 
	 * @param otherCard the card being considered
	 * @return boolean of win 
	 */
	public boolean isCrazyEightMatch(Card otherCard) {
		// 8s automatically wins 
		if(otherCard.value.equals("8")) {
			return true; 
		}
		if(this.value.equals(otherCard.value) || this.suit.equals(otherCard.suit)) {
			return true; 
		}
		return false; 
	}

}
