package pointSevenEight;

import java.util.Scanner;

public class Main {
	private final static Scanner sc = new Scanner(System.in); 

	int suitNumber = 0;
	int faceNumber = 0;
	Main() {

		Hand hand = new Hand();
		Card[] card = null;

		generateRandomNumCard();
		hand.addCard(new Card(suitNumber, faceNumber));
		
		generateRandomNumCard();
		hand.addCard(new Card(suitNumber, faceNumber));
		
		card = hand.getCardArray();
		System.out.println(" -" + card[0]);
		System.out.println(" -" + card[1]);

		int pointCardOne = card[0].getPoints(card[0].name);
		int pointCardTwo = card[1].getPoints(card[1].name);
		int pointsCards = pointCardOne + pointCardTwo;
		System.out.println("The total of the two cards (" + card[0] + " and " + card[1] +") is " + pointsCards + ".");

		while(!(hand.getIsBusted() || hand.getIsFullHand())){
			System.out.println("==============================================");
			System.out.print("Do you want to take another card? (y/n) ");
			String response = sc.nextLine();
			response = response.substring(0, 1);

			if(response.equalsIgnoreCase("y")){
				generateRandomNumCard();
				hand.addCard(new Card(suitNumber, faceNumber));
				int lastCardPosition = hand.getCards() - 1;
				System.out.println(">> Added the \"" + card[lastCardPosition] + "\" card to the deck.");
				pointsCards += card[lastCardPosition].getPoints(card[lastCardPosition].name);
				System.out.println("The total of the cards is " + pointsCards + ".");
			}else{
				System.out.println("The total of the cards is " + pointsCards + ".");
				break;
			}
		}

		System.out.println("==============================================");
		System.out.println(hand.toString());
	}

	/**
	 * Asigna valores aleatorio a las variables suitNumber y faceNumber de la instancia.
	 */
	private void generateRandomNumCard() {
		int suitNumberMax = 4;
		int faceNumberMax = 13;

		setSuitNumber((int) (Math.random() * suitNumberMax + 1));
		setFaceNumber((int) (Math.random() * faceNumberMax + 1));
	}

	public void setSuitNumber(int suitNumber) {
		this.suitNumber = suitNumber;
	}

	public int getSuitNumber() {
		return suitNumber;
	}

	public void setFaceNumber(int faceNumber) {
		this.faceNumber = faceNumber;
	}

	public int getFaceNumber() {
		return faceNumber;
	}

}