package point_eight;

import java.util.Scanner;

public class PointEight {

  Matriz arrayA = null;
  Matriz arrayB = null;
  Matriz arrayResult = null;

  int numRowsOfArrayA = 0;
  int numColsOfArrayA = 0;
  int numRowsOfArrayB = 0;
  int numColsOfArrayB = 0;

  /**
   * Escriba un programa que tome dos arreglas y, luego, permita al usuario elegir
   * sumar, restar o multiplicar y mostrar la respuesta. El programa mostrará el
   * siguiente menú:
   * <p>
   * A. Enter Arreglo A
   * <p>
   * B. Enter Arreglo B
   * <p>
   * C. Display A + B
   * <p>
   * D. Display A - B
   * <p>
   * E. Display A * B
   * <p>
   * F. Exit
   * 
   * <p>
   * El programa debe mostrar un ciclo y permitir al usuario continuar eligiendo
   * diferentes opciones hasta que eligen salir. El programa bien escrito colocará
   * en módulos el proceso en métodos diferentes.
   */
  public PointEight(Scanner sc) {

    while (true) {

      String option = menu(sc);

      if (option.equalsIgnoreCase("A")) {

        setArrayA(enterArray(sc));
        numRowsOfArrayA = arrayA.getRows();
        numColsOfArrayA = arrayA.getColumns();
      } else if (option.equalsIgnoreCase("B")) {

        setArrayB(enterArray(sc));
        numRowsOfArrayB = arrayB.getRows();
        numColsOfArrayB = arrayB.getColumns();
      } else if (option.equalsIgnoreCase("C")) {

        calcMatrices('+');
      } else if (option.equalsIgnoreCase("D")) {

        calcMatrices('-');
      } else if (option.equalsIgnoreCase("E")) {

        multMatrices();
      } else if (option.equalsIgnoreCase("F")) {

        System.out.println("Saliendo del programa");
        break;
      } else if (option.equalsIgnoreCase("G")) {

        test();
      } else {

        System.out.println("Opcion no valida");
        break;
      }

      System.out.println("Array A");
      printMatriz(arrayA);
      System.out.println("Array B");
      printMatriz(arrayB);
      System.out.println("Array Result");
      printMatriz(arrayResult);
    }
  }

  /**
   * Calcula la suma o resta de dos matrices
   * 
   * @param operator '+' para suma y '-' para resta
   */
  private void calcMatrices(char operator) {

    if (arrayA == null || arrayB == null) {
      System.out.println("No hay matrices para calcular");
      return;
    }

    if (numRowsOfArrayA != numRowsOfArrayB || numColsOfArrayA != numColsOfArrayB) {
      System.out.println("Las matrices no tienen las mismas dimensiones");
      return;
    }

    arrayResult = new Matriz(numRowsOfArrayB, numColsOfArrayB);
    int valueResult = 0;

    for (int i = 0; i < numRowsOfArrayA; i++) {
      for (int j = 0; j < numColsOfArrayA; j++) {
        if (operator == '+') {
          valueResult = arrayA.getElement(i, j) + arrayB.getElement(i, j);
        } else if (operator == '-') {
          valueResult = arrayA.getElement(i, j) - arrayB.getElement(i, j);
        }
        arrayResult.setElement(i, j, valueResult);
      }
    }
  }

  /**
   * Calcula a multiplicacion de dos matrices, A y B, de la clase
   */
  private void multMatrices() {
    if (arrayA == null || arrayB == null) {
      System.out.println("No hay matrices para multiplicar");
      return;
    }

    if (numColsOfArrayA != numRowsOfArrayB) {
      System.out.println("Las matrices no tienen las mismas dimensiones");
      return;
    }

    setArrayResult(new Matriz(numRowsOfArrayA, numColsOfArrayA));
    int valueResult;

    for (int i = 0; i < numRowsOfArrayA; i++) {
      for (int j = 0; j < numColsOfArrayB; j++) {
        valueResult = 0;
        for (int k = 0; k < numColsOfArrayA; k++) {
          valueResult += arrayA.getElement(i, k) * arrayB.getElement(k, j);
        }
        arrayResult.setElement(i, j, valueResult);
      }
    }

  }

  /**
   * Crea una matriz con los datos ingresados por el usuario
   * 
   * @param sc Scanner para leer datos del usuario
   * @return Matriz con los datos ingresados por el usuario
   */
  private Matriz enterArray(Scanner sc) {

    int numRows = 0, numCols = 0;

    System.out.print("Ingrese la cantidad de filas del arreglo: ");
    numRows = sc.nextInt();
    System.out.print("Ingrese la cantidad de columnas del arreglo: ");
    numCols = sc.nextInt();

    Matriz array = new Matriz(numRows, numCols);

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        array.setElement(i, j, sc.nextInt());
      }
    }

    return array;
  }

  /**
   * Imprime una matriz
   * 
   * @param array
   */
  public void printMatriz(Matriz array) {

    System.out.println("====Matriz====");
    if (array == null) {
      System.out.println("¡¡No hay matriz para mostrar!!");
    }else{
      System.out.println(array);
    }
    System.out.println("==============");

  }

  /**
   * Crea dos matrices para probar el programa, con base al ejemplo
   */
  public void test() {
    setArrayA(new Matriz(2, 2));
    setArrayB(new Matriz(2, 2));

    arrayA.setElement(0, 0, 3);
    arrayA.setElement(0, 1, 4);
    arrayA.setElement(1, 0, 5);
    arrayA.setElement(1, 1, 6);

    arrayB.setElement(0, 0, 1);
    arrayB.setElement(0, 1, 0);
    arrayB.setElement(1, 0, -2);
    arrayB.setElement(1, 1, 3);

    System.out.println("\n¡Matriz A y B creadas!\n");
  }

  private static String menu(Scanner sc) {
    System.out.println("[A] Enter Arreglo A");
    System.out.println("[B] Enter Arreglo B");
    System.out.println("[C] Display A + B");
    System.out.println("[D] Display A - B");
    System.out.println("[E] Display A * B");
    System.out.println("[F] Exit");
    System.out.println("([G] para crear las dos matrices del ejemplo A y B)");
    System.out.print(">> ");

    char option = sc.next().charAt(0);
    String optionString = Character.toString(option);
    return optionString;
  }

  public void setArrayA(Matriz array) {
    this.arrayA = array;
    this.numRowsOfArrayA = array.getRows();
    this.numColsOfArrayA = array.getColumns();
  }

  public void setArrayB(Matriz arrayB) {
    this.arrayB = arrayB;
    this.numRowsOfArrayB = arrayB.getRows();
    this.numColsOfArrayB = arrayB.getColumns();
  }

  public void setArrayResult(Matriz arrayResult) {
    this.arrayResult = arrayResult;
  }
}
