import java.util.ArrayList;

public class CardHand {
	
	private ArrayList<Card> cardHand; 
	private int numCards; 

	public CardHand(ArrayList<Card> cardHand, int numCards) {
		this.cardHand = cardHand; 
		this.numCards = numCards; 
	}
	
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
	
	public ArrayList<Integer> getValidPlayList(Card currCard) {
		ArrayList<Integer> cardsIndex = new ArrayList<Integer>(); 
		
		for(int i = 0; i < cardHand.size(); i++) {
			if(currCard == null || currCard.isCrazyEightMatch(cardHand.get(i))) {
				cardsIndex.add(i); 
			}
		}
		
		return cardsIndex; 
		
	}
	public int getHandSize() {
		return numCards; 
	}
	
	public Card getCard(int index){
		return cardHand.get(index); 
	}
	
	public void playCard(int index) {
		cardHand.remove(index); 
	}
	
	public void drawCard(Card card) {
		cardHand.add(card); 
	}
	
	public boolean handIsEmpty() {
		return cardHand.isEmpty(); 
	}
	

}
