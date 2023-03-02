package puntoCuatro;

import java.util.Scanner;

public class PuntoCuatro {
	
	public PuntoCuatro(Scanner scanner) {
        double earthWeight, conversionFactor, planetWeight;
        int option;

        // Pedir el peso del usuario en la Tierra
        System.out.print("Ingrese su peso en la Tierra (en libras): \n>>");
        earthWeight = scanner.nextDouble();

        // Mostrar menú de planetas
        System.out.println("Seleccione un planeta del sistema solar:");
        System.out.println("1. Mercurio");
        System.out.println("2. Venus");
        System.out.println("3. Marte");
        System.out.println("4. Júpiter");
        System.out.println("5. Saturno");
        System.out.println("6. Urano");
        System.out.println("7. Neptuno");

        // Pedir la opción seleccionada por el usuario
        System.out.print("Ingrese la opción deseada: ");
        option = scanner.nextInt();

        // Calcular el peso en el planeta seleccionado
        String planeta = "";
        if (option == 1) {
            conversionFactor = 0.38;
            planeta = "Mercurio";
        } else if (option == 2) {
            conversionFactor = 0.91;
            planeta = "Venus";
        } else if (option == 3) {
            conversionFactor = 0.38;
            planeta = "Marte";
        } else if (option == 4) {
            conversionFactor = 2.36;
            planeta = "Júpiter";
        } else if (option == 5) {
            conversionFactor = 0.92;
            planeta = "Saturno";
        } else if (option == 6) {
            conversionFactor = 0.89;
            planeta = "Urano";
        } else if (option == 7) {
            conversionFactor = 1.13;
            planeta = "Neptuno";
        } else {
            System.out.println("Opción inválida");
            return;
        }

        planetWeight = earthWeight * conversionFactor;

        // Mostrar el peso en el planeta seleccionado
        System.out.printf("Your weight on %s is %.2f lbs.", planeta, planetWeight);
    }
}
