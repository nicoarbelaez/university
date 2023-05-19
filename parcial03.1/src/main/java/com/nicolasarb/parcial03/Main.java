package main.java.com.nicolasarb.parcial03;

import java.util.Scanner;

public class Main {
	private static Inventory inventory;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			inventory = new Inventory(sc);
			while (true) {
				consoleClear();
				titleMenu();
				int option = sc.nextInt();
				consoleClear();
				switch (option) {
				case 1:
					inventory.addItem();
					break;
				case 2:
					inventory.removeItem();
					break;
				case 3:
					System.out.println(inventory.toString());
					break;
				case 4:
					inventory.searchItem();
					break;
				case 0:
				default:
					consoleClear();
					System.out.println("Exiting...");
					//System.exit(0);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println(ColorConstant.RESET);
		}
	}

	private static void titleMenu() {
		System.out.println("+------------------------------+");
		System.out.println("|     Spaceship inventory     |");
		System.out.println("+------------------------------+");
		System.out.println("[1] Add spaceship");
		System.out.println("[2] Delete spaceship");
		System.out.println("[3] View list of spaceships");
		System.out.println("[4] Search spaceship");
		System.out.println("[0] Exit");
		System.out.print(">> ");
	}

	private static void consoleClear() {
		System.out.println(ColorConstant.RESET);
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void exampleTable() {
		// Imprimir el encabezado de la tabla
		System.out.println("-------------------------------------------------");
		System.out.printf("%10s %10s", "Número", "Cuadrado");
		System.out.println();
		System.out.println("-------------------------------------------------");
		// Imprimir los datos de la tabla usando un bucle for
		for (int i = 0; i < 100; i++) {
			int cuadrado = i * i; // Calcular el cuadrado del número
			System.out.printf("%10d %10d", i, cuadrado); // Imprimir el número y su cuadrado con formato
			System.out.println(); // Saltar de línea
		}
		// Imprimir el final de la tabla
		System.out.println("-------------------------------------------------");
	}
}
