package PuntoTres;

import java.util.Scanner;

public class PuntoTres {
	
	
	public void calcularValor() {
		Scanner sc = new Scanner(System.in);
		int numPersonas = 0;
		System.out.print("Ingrese el número de personas que se han apuntado para el viaje: ");
	numPersonas = sc.nextInt();

		int numAutobuses = numPersonas / 45;
		int personasFurgonetas = numPersonas % 45;

		if (numAutobuses > 0) {
			System.out.println("Se necesitan " + numAutobuses + " autobuses para llevar a todas las personas.");
		} else {
			System.out.println("No se necesitan autobuses para el viaje.");
		}

		if (personasFurgonetas > 0) {
			System.out.println(personasFurgonetas + " personas tendrán que viajar en furgonetas.");
		} else {
			System.out.println("Todas las personas podrán viajar en autobús.");
		}
		
	}
}
