package puntoSeis;

import java.util.Scanner;

public class PuntoSeis {

  public PuntoSeis(Scanner scanner) {
    double average;
    int daysAbsent;
    System.out.println("This program will determine if you can get out of the final exam.");
    // Este programa determinará si puedes salir del examen final.
    System.out.println("Please answer the following questions.");
    // Por favor, conteste a las siguientes preguntas.

    System.out.print("What is your average in the class? \n>> ");
    // ¿Cuál es su promedio en la clase?
    average = scanner.nextDouble();

    System.out.print("How many class lectures have you missed? \n>> ");
    // ¿Cuántas clases ha perdido?
    daysAbsent = scanner.nextInt();

    if ((average >= 90 && daysAbsent <= 3) || (average >= 80 && daysAbsent == 0)) {
      System.out.println("Congratulations! You are exempt from the final exam.");
      // ¡Felicidades! Estás exento del examen final.
    } else {
      System.out.println("Sorry, you are not exempt from the final exam.");
      // Lo siento, no estás exento del examen final.
    }
  }
}
