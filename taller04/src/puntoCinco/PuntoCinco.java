package puntoCinco;

import java.util.Scanner;

public class PuntoCinco {
	
	public PuntoCinco(Scanner scanner) {

        // Pedir información al usuario
        System.out.print("¿Cuál es la posición de notas esta el estudiante en su institución (1 para la más alta, 2 para la segunda más alta, 0 en otro caso)? \n>>");
        int calification = scanner.nextInt();

        System.out.print("¿Cuál es la nota media del estudiante? \n>>");
        double averageNote = scanner.nextDouble();

        System.out.print("¿Cuál es la puntuación SAT del estudiante? \n>>");
        int satScore = scanner.nextInt();

        String textAdmission = "El estudiante cumple los requisitos para ingresar en la Universidad de Mountville.";

        // Comprobar si el estudiante cumple los requisitos
        if (calification == 1 || calification == 2) {
            System.out.println(textAdmission + "(1)");
        } else if (averageNote >= 4.0 && satScore >= 1100) {
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
