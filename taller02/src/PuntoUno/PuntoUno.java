package PuntoUno;

import java.util.Scanner;

public class PuntoUno {

    public PuntoUno(Scanner scanner) {
        System.out.print("Digite la base: ");
        int base = scanner.nextInt();
        System.out.print("Digite la altura: ");
        int altura = scanner.nextInt();

        float area = (1.0f/2) * base * altura;
        System.out.println("El área del triángulo es: " + area);
    }
}
