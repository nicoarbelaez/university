import java.util.Scanner;

import puntoCinco.PuntoCinco;
import puntoCuatro.PuntoCuatro;
import puntoDos.PuntoDos;
import puntoSeis.PuntoSeis;
import puntoSiete.PuntoSiete;
import puntoUno.PuntoUno;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("*******************");
    System.out.println("     Taller 04");
    System.out.println("*******************\n");

    System.out.print("Todos los puntos del taller 04, cual desea ejecutar? (1-7) \n>> ");
    int workshopPoint = scanner.nextInt();

    while (true) {
      if (workshopPoint >= 1 && workshopPoint <= 7) {

        switch (workshopPoint) {
          case 1:
            workshopPointTitle(workshopPoint);
            new PuntoUno();
            break;
          case 2:
            workshopPointTitle(workshopPoint);
            new PuntoDos(scanner);
            break;
          case 3:
            workshopPointTitle(workshopPoint);
            System.out
                .println(
                    "El punto 3 se encuentra en archivo o word o puedes visualizarlo en el README del repositorio.");
            break;
          case 4:
            workshopPointTitle(workshopPoint);
            new PuntoCuatro(scanner);
            break;
          case 5:
            workshopPointTitle(workshopPoint);
            new PuntoCinco(scanner);
            break;
          case 6:
            workshopPointTitle(workshopPoint);
            new PuntoSeis(scanner);
            break;
          case 7:
            workshopPointTitle(workshopPoint);
            new PuntoSiete(scanner);
            break;
          default:
            System.out.println("Opcion no valida");
            break;
        }

        System.out.println("\n**********************************n");
        System.out.print("Todos los puntos del taller 04, cual desea ejecutar? (1-7). 0 para salir. \n>> ");
        workshopPoint = scanner.nextInt();

        if (workshopPoint == 0) {
          System.out.println("Gracias por usar el programa");
          break;
        }

      } else {
        System.out.print("Opcion no valida, por favor ingrese un numero entre 1 y 7 \n>> ");
        workshopPoint = scanner.nextInt();
      }
    }
  }

  public static void workshopPointTitle(int pointNumber) {
    System.out.println("*****************");
    System.out.println("     Punto " + pointNumber);
    System.out.println("*****************\n");
  }
}
