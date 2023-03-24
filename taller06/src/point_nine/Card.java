package point_nine;

public class Card {
	String suit, name;
	int points;
	private int pointAce = 11;

	Card(int n1, int n2) {
		suit = getSuit(n1);
		name = getName(n2);
		points = getPoints(name);
	}

	public String toString() {
		return "The " + name + " of " + suit;
	}

	public String getName(int i) {
		if (i == 1)
			return "Ace";
		if (i == 2)
			return "Two";
		if (i == 3)
			return "Three";
		if (i == 4)
			return "Four";
		if (i == 5)
			return "Five";
		if (i == 6)
			return "Six";
		if (i == 7)
			return "Seven";
		if (i == 8)
			return "Eight";
		if (i == 9)
			return "Nine";
		if (i == 10)
			return "Ten";
		if (i == 11)
			return "Jack";
		if (i == 12)
			return "Queen";
		if (i == 13)
			return "King";
		return "error";
	}

	public int getPoints(String n) {
		if (n == "Jack" || n == "Queen" || n == "King" || n == "Ten")
			return 10;
		if (n == "Two")
			return 2;
		if (n == "Three")
			return 3;
		if (n == "Four")
			return 4;
		if (n == "Five")
			return 5;
		if (n == "Six")
			return 6;
		if (n == "Seven")
			return 7;
		if (n == "Eight")
			return 8;
		if (n == "Nine")
			return 9;
		if (n == "Ace")
			return getPointAce();
		return -1;
	}

	public String getSuit(int i) {
		if (i == 1)
			return "Diamonds";
		if (i == 2)
			return "Clubs";
		if (i == 3)
			return "Spades";
		if (i == 4)
			return "Hearts";
		return "error";
	}

	public void setPointAce() {
		this.pointAce = 1;
	}

	public int getPointAce() {
		return this.pointAce;
	}
}
