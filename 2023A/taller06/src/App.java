import java.util.Scanner;

import points_one_to_four.PointOne;
import points_one_to_four.PointTwo;
import points_one_to_four.PointThree;
import points_one_to_four.PointFour;
import point_seven.PointSeven;
import point_eight.PointEight;
import point_nine.PointNine;

public class App {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int option;

    /**
     * Se usa try-chatch-finally para manejar las excepciones de entrada de datos, y
     * para reiniciar el color de la consola. De esta forma no es molesto para el
     * usuario
     */
    ColorConstant.clearConsole();
    try {
      while (true) {

        System.out.println(ColorConstant.RESET);
        System.out.println("*****************");
        System.out.println("*** Taller 6 ****");
        System.out.println("*****************");
        System.out.println("Seleccione un punto del taller entre 1 y 9, para ejecutar (excepto 5 y 6):");
        System.out.println("[1] Puntos 1 al 4 o ejecutar (Se debe entrar al codigo para ver los puntos)");
        System.out.println("[7] Punto 7");
        System.out.println("[8] Punto 8");
        System.out.println("[9] Punto 9");
        System.out.println("[0] Salir");
        System.out.print(">> ");

        option = sc.nextInt();
        ColorConstant.clearConsole();

        switch (option) {
          /*
           * Se hace de esta manera para los puntos del 1 al 4 ejecuten lo mismo, y se
           * rompa el switch en el case 4.
           */
          case 1:
          case 2:
          case 3:
          case 4:
            System.out.println(ColorConstant.GREEN);
            new PointOne();
            new PointTwo();
            new PointThree();
            new PointFour();
            break;
          case 7:
            System.out.println(ColorConstant.YELLOW);
            new PointSeven(sc);
            break;
          case 8:
            System.out.println(ColorConstant.PURPLE);
            new PointEight(sc);
            break;
          case 9:
            System.out.println(ColorConstant.YELLOW);
            new PointNine(sc);
            break;
          case 0:
            System.out.println(ColorConstant.YELLOW + "Saliendo..." + ColorConstant.RESET);
            System.exit(0);
            break;
          default:
            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            break;
        }
      }
    } catch (Exception e) {
      // Manejar la excepción y reiniciar el color de la consola
      System.out.println(ColorConstant.RESET);
      e.printStackTrace();
    } finally {
      // Reiniciar el color de la consola
      System.out.println(ColorConstant.RESET);
    }
  }
}