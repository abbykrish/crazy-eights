
public class Player {
	
	private String name; 
	private CardHand hand; 

	public Player(String name, CardHand hand) {
		this.name = name; 
		this.hand = hand; 
	}
	
	public String getName() {
		return name; 
	}
	
	public CardHand getHand() {
		return hand; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setHand(CardHand hand) {
		this.hand = hand; 
	}
	
	public boolean hasWon() {
		return hand.handIsEmpty(); 
	}

}
