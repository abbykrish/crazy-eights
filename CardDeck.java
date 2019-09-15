import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author abbykrishnan
 * CardDeck class that represents a conventional 52 deck of cards
 */
public class CardDeck {
	
	// represents the suits and values in a card deck
	private static final String[] SUITS = {"Diamond", "Club", "Spade", "Heart"}; 
	private static final String[] VALUES = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
	
	private ArrayList<Card> cardDeck; 
	
	/**
	 * Creates an instance of a fresh card deck 
	 */
	public CardDeck() {
		this.cardDeck = new ArrayList<Card>(); 
		
		for(String s: SUITS) {
			for(String v: VALUES) {
				cardDeck.add(new Card(s, v)); 
			}
		}
		this.shuffleDeck();
	}
	
	/**
	 * Shuffles the deck
	 */
	private void shuffleDeck() {
		Collections.shuffle(cardDeck); 
	}
	
	/**
	 * Deals out hand of cards depending on the number of cards wanted in a hand
	 * @param numCards
	 * @return CardHand object
	 */
	public CardHand dealHandFromDeck(int numCards) {
		ArrayList<Card> cardHand = new ArrayList<Card>(); 
		int cardsDealt = 0; 
		
		while(cardsDealt < numCards) {
			Card card = cardDeck.get(generateRandomInt(cardDeck.size())); 
			cardHand.add(card);
			cardDeck.remove(card); 
			cardsDealt++; 
		}
		
		return new CardHand(cardHand, numCards); 
	}
	
	/**
	 * Draws a single card from the deck 
	 * @return Card object
	 */
	public Card drawCard() {
		if(cardDeck.isEmpty()) {
			return null; 
		}
		int cardNum = generateRandomInt(cardDeck.size()); 
		return cardDeck.remove(cardNum); 
	}
	
	/**
	 * Helper method to generate a random integer
	 * @param limit upper bound 
	 * @return random int
	 */
	private int generateRandomInt(int limit){
	    Random random = new Random();
	    return random.nextInt(limit);
	}
	

}
