package puntoDos;

import java.util.Map;
import java.util.Scanner;

public class PuntoDos {
    
    public PuntoDos(Scanner scanner) {
        // Crear un objeto Map para crear un diccionario.
        Map<String, String> operatorsMap = Map.of(
          "+", "suma",
          "-", "resta",
          "*", "multiplicación",
          "/", "división",
          "%", "módulo"
        );

        // Imprimir los operadores disponibles.
        System.out.println("Elija un operador ingresando su clave de los siguientes:");
        // Recorrer el diccionario y mostrar las claves y valores.
        for (String key : operatorsMap.keySet()) {
            // Obtener el valor correspondiente a la clave.
            String value = operatorsMap.get(key);
            // Imprimir la clave y el valor.
            System.out.println(key + ": " + value);
        }
        
        // Pedir los números de entrada.
        
        System.out.print(">> ");
        char operator = scanner.next().charAt(0);
        String operatorNotation = operatorsMap.get(Character.toString(operator));
        
        System.out.print("Ingrese el primer número para realizar " + operatorNotation + ": ");
        double numberOne = scanner.nextDouble();
        System.out.print("Ingrese el segundo número " + numberOne + " " + operator + " ");
        double numberTwo = scanner.nextDouble();
        
        double result = 0;
        
        // Realizar la operación dependiendo del operador ingresado.
        if (operator == '+') {
            result = numberOne + numberTwo;
        } else if (operator == '-') {
            result = numberOne - numberTwo;
        } else if (operator == '*') {
            result = numberOne * numberTwo;
        } else if (operator == '/') {
            result = numberOne / numberTwo;
        } else if (operator == '%') {
            result = numberOne % numberTwo;
        } else {
            System.out.print("Operador no válido: " + operator);
        }
        
        // Utilizar un switch para realizar la operación.
      //   switch (operator) {
      //   case '+':
      //       result = numberOne + numberTwo;
      //       break;
      //   case '-':
      //       result = numberOne - numberTwo;
      //       break;
      //   case '*':
      //       result = numberOne * numberTwo;
      //       break;
      //   case '/':
      //       result = numberOne / numberTwo;
      //       break;
      //   case '%':
      //       result = numberOne % numberTwo;
      //       break;
      //   default:
      //       System.out.print("Operador no válido: " + operator);
      //   }
        
        // Imprimir el resultado de la operación.
        System.out.println("El resultado de la operación " + operatorNotation + " es:");
        System.out.println(numberOne + " " + operator + " " + numberTwo + " = " + result);
    }
}
