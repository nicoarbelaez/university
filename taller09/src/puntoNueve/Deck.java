package puntoNueve;

public class Deck {
	Card[] cardArray = new Card[52];

	Deck() { // constructor
		int suits = 4;
		int cardType = 13;
		int cardCount = 0;
		for (int i = 1; i <= suits; i++)
			for (int j = 1; j <= cardType; j++) {
				cardArray[cardCount] = new Card(i, j);
				cardCount++;
			}
	}

	public void print() {
		for (int i = 0; i < cardArray.length; i++)
			System.out.println(cardArray[i]);
	}
	
	public void mingle() {
		Card[] cardArrayOne = new Card[this.cardArray.length / 2];
		Card[] cardArrayTwo = new Card[this.cardArray.length / 2];
		
		int nextCard = 0;
		
		for(Card card: cardArray) {
			if(nextCard = 0) {
				cardArrayOne[]
			}
		}
	}

}
