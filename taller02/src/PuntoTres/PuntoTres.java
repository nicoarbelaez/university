package PuntoTres;

import java.util.Scanner;

public class PuntoTres {
    private static final int CAPACIDAD_AUTOBUSES = 45;

    public PuntoTres(Scanner scanner) {
        System.out.print("Ingrese la cantidad de personas que van a viajar: ");
        int personas = scanner.nextInt();
        int autobuses = personas / CAPACIDAD_AUTOBUSES;
        int personasEnFurgoneta = personas % CAPACIDAD_AUTOBUSES;

        System.out.println("Se necesitarán " + autobuses + " autobuses y " + personasEnFurgoneta + " personas viajarán en furgoneta.");
    }
}
