
public class Card {

	private String suit; 
	private String value; 
	private boolean inGamePlay; 
	
	public Card(String suit, String value) {
		this.suit = suit; 
		this.value = value; 
		this.inGamePlay = false; 
	}
	
	public String getSuit() {
		return suit; 
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean getGameStatus() {
		return inGamePlay;
	}
	
	public void setSuit(String suit) {
		this.suit = suit; 
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setGameStatus(boolean inGamePlay) {
		this.inGamePlay = inGamePlay;
	}
	
	public String toString() {
		return value + " of " + suit; 
	}
	
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
