import java.util.Scanner;

import PuntoDos.PuntoDos;
import PuntoTres.PuntoTres;
import PuntoUno.PuntoUno;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*******************");
		System.out.println("     Taller 02");
		System.out.println("*******************\n");
		
		System.out.println("Punto 1");
		new PuntoUno(scanner);
		System.out.println("=========================");

		System.out.println("Punto 2");
		new PuntoDos();
		System.out.println("=========================");

		System.out.println("Punto 3");
		new PuntoTres(scanner);
		System.out.println("=========================");
		
		scanner.close();
	}

}
