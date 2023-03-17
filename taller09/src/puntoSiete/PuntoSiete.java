package puntoSiete;

import java.util.Scanner;

public class PuntoSiete {
	
	public PuntoSiete() {
		Scanner sc = new Scanner(System.in);
		int[] points = new int[5];
		float total = 0;
		
		for(int i = 0; i < points.length; i++) {
			System.out.print("Ingrese el resultado del usuario " + (i+1) + ": ");
			points[i] = sc.nextInt();
			total += points[i];
		}
		float average = total / points.length;
		System.out.println("El promedio de los estudiantes es de: " + average);
	}
}
