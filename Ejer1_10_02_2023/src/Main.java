import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.print(ContarPalabras());
	}
	
	public static String ContarPalabras() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese su cadena de texto: ");
		String string = sc.next();
		
		sc.close();
		return "La cadena tiene " + string.length() + " letras.";
	}
}
