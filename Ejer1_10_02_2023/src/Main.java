import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingrese su cadena de texto: ");
		String nombre = sc.next();
		System.out.print("La cadena tiene " + nombre.length() + " letras.");
		
		sc.close();
	}
}
