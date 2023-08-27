package point_nine;

import java.util.Scanner;

public class PointNine {
  /**
   * 9. Escriba el código y prueba. Añadir las siguientes características.
   * <p>
   * A. Agregue un método para mezclar a la clase Deck. Llame al método desde la
   * clase Main (principal) para verificar que el mazo esté verdaderamente
   * mezclado. ✅
   * <p>
   * B. Agregue una clase Hand (mano) que contenga un array de 5 referencias de
   * cartas. Haga al programa repartir dos cartas por mano y mostrarlas al
   * usuario. Indique al usuario cuántos puntos tiene y pregunte a dicho usuario
   * si quiere otra carta o no. Continúe y permítale al jugador agregar cartas
   * hasta llegar a 5 cartas o hasta que el total sea mayor a 21. ✅
   * <p>
   * C. Ajuste la clase Card (carta) para permitir a los Ases que cuenten como 11
   * para comenzar. Si la clase Hand tiene un valor mayor a 21, haga que la clase
   * Hand verifique los Ases y reduzca el valor de puntos a 1. ❌✅
   * <p>
   * D. Haga al programa crear una Mano del crupier contra la cual pueda jugar el
   * usuario. El usuario debe tratar de acercarse lo más posible a 21 sin pasarse
   * para vencer al Crupier. Si el Crupier tiene 16 o más, éste deberá dejar de
   * tomar cartas. ❌
   */
  public PointNine(Scanner sc) {
    int numPlayers = 0;
    boolean withCrupier = false;

    System.out.println("*****************");
    System.out.println("*** Blackjack ***");
    System.out.println("*****************");
    System.out.println("Please select an option:");
    System.out.println("1. Start game");
    System.out.println("2. Play 1 vs 1 against crupier");
    System.out.println("3. Exit");
    System.out.print(">> ");

    int choice = sc.nextInt();

    if (choice == 1) {
      while (numPlayers < 1 || numPlayers > 4) {
        System.out.println("How many players? (1-4)");
        System.out.print(">> ");
        numPlayers = sc.nextInt();
      }

      String response = "";
      while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
        System.out.println("Play with crupier? (y/n)");
        System.out.print(">> ");
        response = sc.next();
      }

      withCrupier = response.equalsIgnoreCase("y") ? true : false;

    } else if (choice == 2) {
      numPlayers = 1;
      withCrupier = true;
    } else if (choice == 3) {
      // System.exit(0);
    }

    // Start the game here

    new Main(numPlayers, withCrupier, sc);
  }
}
