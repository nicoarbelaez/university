package pointTwo;

import java.util.Scanner;

public class PointTwo {

	Scanner sc = new Scanner(System.in);

	public PointTwo() {
		System.out.println("Digite (Nombre, Edad, Sexo, Peso, Altura)");
		System.out.print("Nombre --> ");
		String nombre = sc.nextLine();

		System.out.print("Edad --> ");
		int edad = sc.nextInt();

		System.out.print("Sexo(H - M) --> ");
		char sexo = sc.next().charAt(0);

		System.out.print("Peso(Kg) --> ");
		double peso = sc.nextDouble();

		System.out.print("Altura(M) --> ");
		double altura = sc.nextDouble();

		Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
		Persona persona2 = new Persona(nombre, edad, sexo);
		Persona persona3 = new Persona();

		persona3.setNombre(nombre);
		persona3.setEdad(edad);
		persona3.setSexo(sexo);
		persona3.setPeso(peso);
		persona3.setAltura(altura);

		System.out.println("=== Información 1 ===");
		System.out.println(persona1);
		System.out.println(persona1.getNombre() + pesoIdeal(persona1));
		System.out.println(persona1.getNombre() + mayorDeEdad(persona1));

		System.out.println("=== Información 2 ===");
		System.out.println(persona2);
		System.out.println(persona2.getNombre() + pesoIdeal(persona2));
		System.out.println(persona2.getNombre() + mayorDeEdad(persona2));

		System.out.println("=== Información 3 ===");
		System.out.println(persona3);
		System.out.println(persona3.getNombre() + pesoIdeal(persona3));
		System.out.println(persona3.getNombre() + mayorDeEdad(persona3));

	}

	private String mayorDeEdad(Persona persona) {
		if (persona.esMayorDeEdad()) {
			return " Es mayor de edad";
		} else {
			return " No es mayor de edad";
		}
	}

	private String pesoIdeal(Persona persona) {
		switch (persona.calcularIMC()) {
		case 1: {
			return " Tiene sobrepeso";
		}
		case 0: {
			return " Tiene por debajo de su peso ideal";
		}
		case -1: {
			return " Tiene peso ideal";
		}
		default:
			return " ((Hubo un error))";
		}
	}
}
