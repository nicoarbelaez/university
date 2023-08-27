package puntoCinco;

import java.util.Scanner;

public class PuntoCinco {

  public PuntoCinco(Scanner scanner) {

    // Pedir información al usuario
    System.out.print(
        "¿Cuál es la posición de notas esta el estudiante en su institución (1 para la más alta, 2 para la segunda más alta, 0 en otro caso)? \n>> ");
    int calification = scanner.nextInt();
    System.out.println("¿Cuál es el número de alumnos en el instituto? \n>> ");
    int numberStudents = scanner.nextInt();
    
    if (!(calification == 1 || calification == 2) || numberStudents < 1400) {
      System.out.println( 
          "El estudiante no cumple el requisito de haber sido el estudiante con la clasificación más alta o la segunda más alta de un instituto con un número de alumnos igual o superior a 1400.");
      return;
    }

    // Comprobar si el estudiante cumple los requisitos
    System.out.print("¿Cuál es la nota media del estudiante? \n>> ");
    double averageNote = scanner.nextDouble();

    System.out.print("¿Cuál es la puntuación SAT del estudiante? \n>> ");
    int satScore = scanner.nextInt();

    String textAdmission = "El estudiante cumple los requisitos para ingresar en la Universidad de Mountville.";

    if (averageNote >= 4.0 && satScore >= 1100) {
      System.out.println(textAdmission + "(2)");
    } else if (averageNote >= 3.5 && satScore >= 1300) {
      System.out.println(textAdmission + "(3)");
    } else if (averageNote >= 3.0 && satScore >= 1500) {
      System.out.println(textAdmission + "(4)");
    } else {
      System.out.println("El estudiante no cumple los requisitos para ingresar en la Universidad de Mountville.");
    }
  }
}
