import java.util.ArrayList;

/**
 * @author abbykrishnan
 * CardHand class that represents the cards a player is holding. 
 */
public class CardHand {
	
	private ArrayList<Card> cardHand; 
	private int numCards; 
	
	/**
	 * Constructor for CardHand
	 * @param cardHand list to add to
	 * @param numCards number of cards to add 
	 */
	public CardHand(ArrayList<Card> cardHand, int numCards) {
		this.cardHand = cardHand; 
		this.numCards = numCards; 
	}
	
	/**
	 * Prints out the cards in this hand that are valid plays 
	 * @param currCard card we are checking against
	 */
	public void displayHandWithValidPlays(Card currCard) {
		for(int i = 0; i < cardHand.size(); i++) {
			Card card = cardHand.get(i); 
			String validStr; 
			if(currCard != null) {
				validStr = currCard.isCrazyEightMatch(card) ? " VALID" : ""; 
			}
			else {
				validStr = " VALID"; 
			}
			System.out.println(i + ": " + card + validStr); 
		}
	}
	
	/**
	 * Get all the cards that are a valid play this round 
	 * @param currCard card we are checking against
	 * @return list of valid cards 
	 */
	public ArrayList<Integer> getValidPlayList(Card currCard) {
		ArrayList<Integer> cardsIndex = new ArrayList<Integer>(); 
		
		for(int i = 0; i < cardHand.size(); i++) {
			if(currCard == null || currCard.isCrazyEightMatch(cardHand.get(i))) {
				cardsIndex.add(i); 
			}
		}
		
		return cardsIndex; 
		
	}
	
	/**
	 * Get hand size
	 * @return hand size
	 */
	public int getHandSize() {
		return numCards; 
	}
	
	/**
	 * Get card at given index
	 * @param index
	 * @return Card object
	 */
	public Card getCard(int index){
		return cardHand.get(index); 
	}
	
	/**
	 * Play a card into game play
	 * @param index
	 */
	public void playCard(int index) {
		cardHand.get(index).setGameStatus(true);
		cardHand.remove(index); 
	}
	
	/**
	 * Draws a card into the hand 
	 * @param card Card object
	 */
	public void drawCard(Card card) {
		cardHand.add(card); 
	}
	
	/**
	 * Returns whether or not the card hand is empty
	 * @return
	 */
	public boolean handIsEmpty() {
		return cardHand.isEmpty(); 
	}
	

}
