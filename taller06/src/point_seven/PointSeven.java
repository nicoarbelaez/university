package point_seven;

import java.util.Scanner;

public class PointSeven {
  /**
   * 7. En una clase determinada, existen 5 pruebas que valen 100 puntos cada una.
   * Escriba un programa que tome los 5 resultados de las pruebas para el usuario,
   * guarde los resultados de las pruebas en un array y, luego, calcule el
   * promedio de los estudiantes.
   */
  public PointSeven(Scanner sc) {
    int[] scores = new int[5];
    float sum = 0;
    float average;

    for (int i = 0; i < scores.length; i++) {
      System.out.print("Ingrese la calificación de la prueba " + (i + 1) + ": ");
      scores[i] = sc.nextInt();
      sum += scores[i];
    }

    average = sum / scores.length;

    System.out.println("El promedio de las pruebas es: " + average);
  }
}
