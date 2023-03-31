package pointSevenEight;

public class Main {

	public static void main(String args[]) {

		int suitNumber = (int) (Math.random() * 4.0 + 1);
		int faceNumber = (int) (Math.random() * 13.0 + 1);
		Card newCard = new Card(suitNumber, faceNumber);

		suitNumber = (int) (Math.random() * 4.0 + 1);
		faceNumber = (int) (Math.random() * 13.0 + 1);
		Card newCardTwo = new Card(suitNumber, faceNumber);
		
		System.out.println(newCard);
		System.out.println(newCardTwo);

		int pointCardOne = newCard.getPoints(newCard.name);
		int pointCardTwo = newCardTwo.getPoints(newCardTwo.name);
		int pointsCards = pointCardOne + pointCardTwo;
		System.out.println("The total of the two cards (" + newCard + " and " + newCardTwo +") is " + pointsCards);

		
	}

}