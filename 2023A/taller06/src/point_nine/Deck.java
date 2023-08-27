package point_nine;

import java.util.Random;

public class Deck {
  Card[] cardArray = new Card[52];
  int lastDealtCardPosition = 0; // Guarda la posición de la última carta repartida.

  Deck() { // constructor
    int suits = 4;
    int cardType = 13;
    int cardCount = 0;
    for (int i = 1; i <= suits; i++)
      for (int j = 1; j <= cardType; j++) {
        cardArray[cardCount] = new Card(i, j);
        // cardArray[cardCount] = new Card(i, 1);
        cardCount++;
      }
  }

  public void print() {
    System.out.println();
    for (int i = lastDealtCardPosition; i < cardArray.length / 4; i++)
      System.out.printf("%-25s %-25s %-25s %-25s\n", "(" + (i + 1) + ")" + cardArray[i], "(" + (i + 1 + 13) + ")"
          + cardArray[i + 13], "(" + (i + 1 + 26) + ")" + cardArray[i + 26],
          "(" + (i + 1 + 39) + ")" + cardArray[i + 39]);
  }

  /**
   * Mezcla las cartas del mazo.
   * 
   * @return true si se pudo mezclar.
   * @return false si no se pudo mezclar.
   */
  public boolean shuffle() {

    Random r = new Random();
    int max = cardArray.length; // El máximo es el tamaño del array.
    int min = lastDealtCardPosition; // El mínimo es la posición de la última carta repartida.
    int numRandom = 0;
    Card tempCard = null;

    for (int i = min; i < max; i++) {
      numRandom = r.nextInt(max - min) + min; // Ejemplo: 52 - 50 = 2. El numero random será entre 0 y 2 - 1, mas
                                              // 50.
      // Guardo la carta de la posición i en una variable temporal.
      tempCard = cardArray[i];

      // Intercambiamos las cartas de posición.
      cardArray[i] = cardArray[numRandom];
      cardArray[numRandom] = tempCard;
    }
    return true;
  }

  /**
   * Reparte dos cartas.
   * 
   * @return Un objeto Hand con las dos cartas.
   */
  public Hand dealCards(Hand hand) {
    Card card1 = cardArray[lastDealtCardPosition];
    Card card2 = cardArray[lastDealtCardPosition + 1];

    hand.addCard(card1);
    hand.addCard(card2);

    lastDealtCardPosition += 2;
    return hand;
  }

  public Hand addCardHand(Hand hand) {
    Card card = cardArray[lastDealtCardPosition];
    hand.addCard(card);
    lastDealtCardPosition++;
    return hand;
  }

}
