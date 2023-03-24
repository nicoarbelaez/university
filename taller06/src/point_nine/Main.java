package point_nine;

import java.util.Scanner;

public class Main {
  public Main(int numPlayers, boolean isCrupier, Scanner sc) {
    int numberOfHands = isCrupier ? numPlayers + 1 : numPlayers; // Si hay crupier, se le suma 1 a las manos.
    Deck d = new Deck(); // Crear un mazo.
    Hand[] handsArray = new Hand[numberOfHands]; // Crear un arreglo de manos.
    Hand tempHand = null; // Crear una mano temporal.
    Crupier crupier = new Crupier();
    // Si hay crupier, se le resta 1 a las manos.
    int handsLength = isCrupier ? handsArray.length - 1 : handsArray.length;

    // Inicio del juego.
    System.out.print("-------------------- Deck --------------------");
    d.print();
    // Mezclar el mazo y mostrarlo.
    System.out.print("-------------------- Shuffle Deck --------------------");
    d.shuffle();
    d.print();

    // Repartir cartas.
    for (int i = 0; i < handsLength; i++) {
      handsArray[i] = new Hand("Player " + (i + 1));

      tempHand = handsArray[i]; // Guardo la mano en una variable temporal.
      tempHand = d.dealCards(tempHand); // Reparto las dos cartas a la mano actual.
      System.out.println(tempHand); // Muestro la mano.
    }
    if (isCrupier) { // Si hay un crupier, se le reparten las cartas.
      handsArray[handsArray.length - 1] = crupier.getHand();

      tempHand = handsArray[handsArray.length - 1];
      tempHand = d.dealCards(tempHand);
      System.out.println(tempHand);
    }

    System.out.print("----------------------- Playing -----------------------");

    sc.nextLine(); // Limpiar el buffer.
    for (int i = 0; i < numberOfHands; i++) {
      String response = "";
      tempHand = handsArray[i];

      System.out.println(tempHand);

      while (!tempHand.getIsBusted() && !tempHand.getIsFullHand()) {
        System.out.println("Do you want to hit? (y/n)");
        if (i >= numberOfHands - 1 && isCrupier) {
          crupier.setHand(tempHand); // Actualizo la mano que tiene el crupier.
          response = crupier.playHand() ? "y" : "n";
          System.out.println(">> " + response);
        } else {
          System.out.print(">> ");
          response = sc.nextLine();
        }

        if (response.equalsIgnoreCase("y")) {
          handsArray[i] = d.addCardHand(tempHand);
          System.out.println(tempHand);
        } else {
          break;
        }
      }
    }
    System.out.println(winnerHand(numberOfHands, handsArray));

  }

  private String winnerHand(int numberOfHands, Hand[] handsArray) {
    Hand tempHandWinner = null;
    String responseString = "";
    int maxScore = 0;
    int maxScoreIndex = 0;

    for (int i = 0; i < numberOfHands; i++) {
      tempHandWinner = handsArray[i];

      if (tempHandWinner.getScore() > maxScore && tempHandWinner.getScore() <= 21) {
        maxScore = tempHandWinner.getScore();
        maxScoreIndex = i;
      }
    }

    tempHandWinner = handsArray[maxScoreIndex];

    if (!tempHandWinner.getIsBusted())
      responseString = "The winner is " + tempHandWinner.getName() + " | Score: " + tempHandWinner.getScore();
    else
      responseString = "There is no winner";
    return responseString;
  }
}
