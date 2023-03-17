package puntoOcho;

import java.util.Scanner;

public class PuntoOcho {
	
	int numberRows = 0;
	int numberCols = 0;
	
	public PuntoOcho() {
		Scanner sc = new Scanner(System.in);
		int[][] arrayA = null;
		int[][] arrayB = null;
		int[][] arrayResult = null;

		char option = menu(sc);

		if (option == 'A') {
			arrayA = enterArray(sc);
		}
		if (option == 'B') {
			arrayB = enterArray(sc);
		}
		if (option == 'C') {
		}
		if (option == 'D') {
		}
		if (option == 'E') {
		}
		if (option == 'F') {
		}
		
		printMatriz(arrayA);
	}

	private int[][] arrayOperatin(int[][] arrayA, int[][] arrayB, char operation){
		int numberRows = array.length;
		int numberCols = array[0].length;
		
		return null;
	}
	
	private int[][] enterArray(Scanner sc) {
		if(numberRows == 0) {
			System.out.print("Ingre la cantidad de filas del arreglo >>");
			numberRows = sc.nextInt();
		}
		if(numberCols == 0) {
			System.out.print("Ingre la cantidad de columnas del arreglo >>");
			numberCols = sc.nextInt();
		}
		
		int[][] array = new int[this.numberRows][this.numberCols];

		for (int i = 0; i < this.numberRows; i++) {
			for (int j = 0; j < this.numberCols; j++) {
				System.out.print("Ingre el valor de la fila (" + (i + 1) + ") y columna (" + (j + 1) + ") >> ");
				array[i][j] = sc.nextInt();
			}
		}
		return array;
	}
	
	public void printMatriz(int[][] array) {
		
		for (int i = 0; i < this.numberRows; i++) {
			for (int j = 0; j < this.numberCols; j++) {
				System.out.print("(" + array[i][j] + ")");
			}
			System.out.println();
		}
	}
	
	public static char menu(Scanner sc) {
		System.out.println("A.	Enter Arreglo A");
		System.out.println("B.	Enter Arreglo B");
		System.out.println("C.	Display A + B");
		System.out.println("D.	Display A - B");
		System.out.println("E.	Display A * B");
		System.out.println("F.	Exit");
		System.out.print(">> ");

		char option = sc.next().charAt(0);
		return option;
	}
}
