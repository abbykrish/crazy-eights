import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardDeck {
	
	private static final String[] SUITS = {"Diamond", "Club", "Spade", "Heart"}; 
	private static final String[] VALUES = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
	
	private ArrayList<Card> cardDeck; 

	public CardDeck() {
		this.cardDeck = new ArrayList<Card>(); 
		
		for(String s: SUITS) {
			for(String v: VALUES) {
				cardDeck.add(new Card(s, v)); 
			}
		}
		this.shuffleDeck();
	}
	
	private void shuffleDeck() {
		Collections.shuffle(cardDeck); 
	}
	
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
	
	public Card drawCard() {
		if(cardDeck.isEmpty()) {
			return null; 
		}
		int cardNum = generateRandomInt(cardDeck.size()); 
		return cardDeck.remove(cardNum); 
	}
	
	public int generateRandomInt(int limit){
	    Random random = new Random();
	    return random.nextInt(limit);
	}
	

}
