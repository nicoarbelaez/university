package pointThree;

import java.util.Scanner;

public class PointThree {
	Scanner sc = new Scanner(System.in);
	public PointThree() {
		System.out.println(">> Digite sus libros <<");
		System.out.println("=== Libro 1 ===");
		System.out.print("ISBN --> ");
		String ISBN = sc.next();

		sc.nextLine(); // Limpiar buffer
		System.out.print("Titulo --> ");
		String titulo = sc.nextLine();

		System.out.print("Autor --> ");
		String autor = sc.nextLine();

		System.out.print("Numero de paginas --> ");
		int numeroDePaginas = sc.nextInt();
		
		Libro libro1 = new Libro(ISBN, titulo, autor, numeroDePaginas);
		
		System.out.println("=== Libro 2 ===");
		System.out.print("ISBN --> ");
		ISBN = sc.next();

		sc.nextLine(); // Limpiar buffer
		System.out.print("Titulo --> ");
		titulo = sc.nextLine();

		System.out.print("Autor --> ");
		autor = sc.nextLine();

		System.out.print("Numero de paginas --> ");
		numeroDePaginas = sc.nextInt();
		
		Libro libro2 = new Libro(ISBN, titulo, autor, numeroDePaginas);

		System.out.println(libro1);
		System.out.println(libro2);
		
		if (libro1.getNumeroDePagias() > libro2.getNumeroDePagias()) {
			System.out.println("El libro " + libro1.getTitulo() + " tiene mas paginas");
		}else {
			System.out.println("El libro " + libro2.getTitulo() + " tiene mas paginas");
		}
	}
}
