package PuntoUno;

import java.util.Scanner;

public class PuntoUno {
	public PuntoUno() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite la base: ");
		int base = scanner.nextInt();
		System.out.print("Digite la altura: ");
		int altura = scanner.nextInt();
		
		float area = (float) (1.0/2*base*altura);
		System.out.println("La superficie del triángulo es de: " + area);
		scanner.close();
	}
}
