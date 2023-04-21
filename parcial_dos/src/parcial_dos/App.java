package parcial_dos;

import java.util.Scanner;

import pointOne.PointOne;
import pointThree.PointThree;
import pointTwo.PointTwo;

public class App {
	public static void main(String[] args) {
		System.out.println("====================");
		System.out.println("==== Parcial Dos ===");
		System.out.println("====================");
		System.out.println("[1] Punto Uno");
		System.out.println("[2] Punto Dos");
		System.out.println("[3] Punto Tres");
		System.out.println("[0] Salir");
		System.out.print(">> ");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		switch (option) {
		case 1: {
			new PointOne();
			break;
		}
		case 2: {
			new PointTwo();
			break;
		}
		case 3: {
			new PointThree();
			break;
		}
		case 0: {
			System.out.println("Saliendo...");
			break;
		}
		default:
			System.out.println("Opcion invalida");
		}
	}
}
