![](https://imgur.com/DTwwCeI.png) ![](https://imgur.com/Erd7DXs.png)

![](https://imgur.com/F7J0Q1r.png)

Conceptos fundamentales de Java 5-1: Scanner y sentencias condicionales Actividades prácticas

# Objetivos de la lección:

1. Usar Scanner para las entradas de usuario durante la ejecución del programa
1. Usar la lógica y las sentencias if-else
1. Aplicar la lógica y las sentencias switch en código Java
1. Usar break y default correctamente en una sentencia switch
1. Usar el operador ternario

# Vocabulario:

Identifique el término correspondiente a cada una de las definiciones a continuación.

|                  **Ternario**                  | Forma abreviada de una sentencia if/else.                                                                                                               |
| :--------------------------------------------: | :------------------------------------------------------------------------------------------------------------------------------------------------------ |
|                  **Scanner**                   | Clase Java utilizada para la lectura de teclado o la entrada de archivo durante la ejecución del programa.                                              |
|   **Estructura de control condicional (if)**   | Tipo de control de programa que permite que se ejecuten segmentos de código diferentes cuando el valor de entrada es igual a una condición determinada. |
| **Estructura de control condicional (switch)** | Tipo de control de programa que permite que se ejecuten segmentos de código diferentes cuando el valor de entrada es igual a una condición determinada. |

# Inténtelo/resuélvalo:

1. Use un operador ternario y escriba una sentencia if/else que devuelva un valor true o false si la variable x es inferior o igual a 7.

```java
package puntoUno;

public class PuntoUno {
	
	public PuntoUno() {
		int randomNum = (int) (Math.random() * 10 + 1);
		boolean lessThanOrEqual7 = randomNum <= 7;
		// esMenorIgualA7
		System.out.println("El número aleatorio generado es " + randomNum + ", entonces " + randomNum + " <= 7:");
		System.out.print(lessThanOrEqual7);
		System.out.println(" - Es " + (lessThanOrEqual7? "menor o igual a 7" : "mayor a 7"));
	}
}

```

2. Escriba un programa que pida al usuario que introduzca dos números con coma flotante (double) y un operador ( \*, +, /, %, -). Imprima los resultados de la operación en cuestión. Para leer la línea de comandos utilice la clase Scanner. Escriba el programa utilizando primero la lógica switch y, a continuación, vuelva a escribir el programa utilizando la lógica if/else.

```java
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
        "%", "módulo");

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
    // switch (operator) {
    // case '+':
    // result = numberOne + numberTwo;
    // break;
    // case '-':
    // result = numberOne - numberTwo;
    // break;
    // case '*':
    // result = numberOne * numberTwo;
    // break;
    // case '/':
    // result = numberOne / numberTwo;
    // break;
    // case '%':
    // result = numberOne % numberTwo;
    // break;
    // default:
    // System.out.print("Operador no válido: " + operator);
    // }

    // Imprimir el resultado de la operación.
    System.out.println("El resultado de la operación " + operatorNotation + " es:");
    System.out.println(numberOne + " " + operator + " " + numberTwo + " = " + result);
  }
}

```

3. Verdadero o falso: Las sentencias IF/ELSE se pueden sustituir siempre con sentencias SWITCH.

> Falso.
>
> Aunque ambas sentencias IF/ELSE y SWITCH pueden usarse para > tomar decisiones basadas en condiciones, no siempre se > pueden sustituir una por otra.
>
> La sentencia IF/ELSE es más flexible y puede manejar una > amplia gama de condiciones. Además, puede encadenar > múltiples condiciones, lo que puede ser difícil de lograr > con SWITCH.

4. Escriba un programa que determine su peso en otro planeta. El programa debe pedir el peso del usuario en la Tierra y, después, mostrar un menú con otros planetas del sistema solar. El usuario debe seleccionar uno de los planetas del menú. El programa deberá mostrar la siguiente frase: “Your weight on Mars is 55 lbs.”. Use los siguientes factores de conversión:

| Planeta  | Factor de conversión (multiplique su peso en la Tierra por este número para determinar su peso en este planeta) |
| :------- | :-------------------------------------------------------------------------------------------------------------- |
| Mercurio | 0.38                                                                                                            |
| Venus    | 0.91                                                                                                            |
| Marte    | 0.38                                                                                                            |
| Júpiter  | 2.36                                                                                                            |
| Saturno  | 0.92                                                                                                            |
| Urano    | 0.89                                                                                                            |
| Neptuno  | 1.13                                                                                                            |

```java
package puntoCuatro;

import java.util.Scanner;

public class PuntoCuatro {

  public PuntoCuatro(Scanner scanner) {
    double earthWeight, conversionFactor, planetWeight;
    int option;

    // Pedir el peso del usuario en la Tierra
    System.out.print("Ingrese su peso en la Tierra (en libras): \n>> ");
    earthWeight = scanner.nextDouble();

    // Mostrar menú de planetas
    System.out.println("Seleccione un planeta del sistema solar:");
    System.out.println("1. Mercurio");
    System.out.println("2. Venus");
    System.out.println("3. Marte");
    System.out.println("4. Júpiter");
    System.out.println("5. Saturno");
    System.out.println("6. Urano");
    System.out.println("7. Neptuno");

    // Pedir la opción seleccionada por el usuario
    System.out.print("Ingrese la opción deseada: ");
    option = scanner.nextInt();

    // Calcular el peso en el planeta seleccionado
    String planeta = "";
    if (option == 1) {
      conversionFactor = 0.38;
      planeta = "Mercurio";
    } else if (option == 2) {
      conversionFactor = 0.91;
      planeta = "Venus";
    } else if (option == 3) {
      conversionFactor = 0.38;
      planeta = "Marte";
    } else if (option == 4) {
      conversionFactor = 2.36;
      planeta = "Júpiter";
    } else if (option == 5) {
      conversionFactor = 0.92;
      planeta = "Saturno";
    } else if (option == 6) {
      conversionFactor = 0.89;
      planeta = "Urano";
    } else if (option == 7) {
      conversionFactor = 1.13;
      planeta = "Neptuno";
    } else {
      System.out.println("Opción inválida");
      return;
    }

    planetWeight = earthWeight * conversionFactor;

    // Mostrar el peso en el planeta seleccionado
    System.out.printf("Your weight on %s is %.2f lbs.", planeta, planetWeight);
  }
}

```

5. Un programa que decida si un estudiante cumple los requisitos para entrar en la Universidad de Mountville. Los estudiantes deben cumplir uno de los criterios siguientes:

   - Haber sido el estudiante con la clasificación más alta o la segunda más alta de un instituto con un número de alumnos igual o superior a 1400
   - Tener una nota media igual o superior a 4,0 y una puntuación SAT igual o superior a 1100
   - Tener una nota media igual o superior a 3,5 y una puntuación SAT igual o superior a 1300
   - Tener una nota media igual o superior a 3,0 y una puntuación SAT igual o superior a 1500

```java
package puntoCinco;

import java.util.Scanner;

public class PuntoCinco {

  public PuntoCinco(Scanner scanner) {

    // Pedir información al usuario
    System.out.print(
        "¿Cuál es la posición de notas esta el estudiante en su institución (1 para la más alta, 2 para la segunda más alta, 0 en otro caso)? \n>> ");
    int calification = scanner.nextInt();
    System.out.println("¿Cuál es el número de alumnos en el instituto? \n>> ");
    int numberStudents = scanner.nextInt();
    
    if (!(calification == 1 || calification == 2) || numberStudents < 1400) {
      System.out.println( 
          "El estudiante no cumple el requisito de haber sido el estudiante con la clasificación más alta o la segunda más alta de un instituto con un número de alumnos igual o superior a 1400.");
      return;
    }

    // Comprobar si el estudiante cumple los requisitos
    System.out.print("¿Cuál es la nota media del estudiante? \n>> ");
    double averageNote = scanner.nextDouble();

    System.out.print("¿Cuál es la puntuación SAT del estudiante? \n>> ");
    int satScore = scanner.nextInt();

    String textAdmission = "El estudiante cumple los requisitos para ingresar en la Universidad de Mountville.";

    if (averageNote >= 4.0 && satScore >= 1100) {
      System.out.println(textAdmission + "(2)");
    } else if (averageNote >= 3.5 && satScore >= 1300) {
      System.out.println(textAdmission + "(3)");
    } else if (averageNote >= 3.0 && satScore >= 1500) {
      System.out.println(textAdmission + "(4)");
    } else {
      System.out.println("El estudiante no cumple los requisitos para ingresar en la Universidad de Mountville.");
    }
  }
}

```

6. Un profesor de universidad eximirá a un estudiante de hacer el examen final si se cumple alguno de estos criterios:

   - Tiene una media igual o superior al 90 % en clase y ha faltado a un número de clases igual o inferior a 3.
   - Tiene una media igual o superior al 80 % en clase y no ha faltado a ninguna clase.
   - El programa a continuación determinará si el estudiante queda o no exento de hacer el examen.
   - Vuelva a escribir el programa utilizando solo una sentencia if.

```java
import java.util.Scanner;

public class FinalExam {

	public static void main(String[] args) {
		double average;
		int daysAbsent;
		boolean exempt = false;

		Scanner reader = new Scanner(System.in);
		System.out.println("This program will determine if you can get out of the final exam.");
		System.out.println("Please answer the following questions.");

		System.out.println("What is your average in the class?");
		average = reader.nextDouble();

		System.out.println("How class lectures have you missed?");
		daysAbsent = reader.nextInt();

		if (average >= 90){
         if (daysAbsent <= 3)
         exempt = true;
		}

		else if (average >= 80)
		{
			if (daysAbsent <= 0)
         exempt = true;
		}

		if (exempt)
         System.out.println("Congratulations! You are exempt from the final exam.");

		else
			System.out.println("You are not exempt from the final exam.");
	}// end of main
}// end of class
```

```java
package puntoSeis;

import java.util.Scanner;

public class PuntoSeis {

  public PuntoSeis(Scanner scanner) {
    double average;
    int daysAbsent;
    System.out.println("This program will determine if you can get out of the final exam.");
    // Este programa determinará si puedes salir del examen final.
    System.out.println("Please answer the following questions.");
    // Por favor, conteste a las siguientes preguntas.

    System.out.print("What is your average in the class? \n>> ");
    // ¿Cuál es su promedio en la clase?
    average = scanner.nextDouble();

    System.out.print("How many class lectures have you missed? \n>> ");
    // ¿Cuántas clases ha perdido?
    daysAbsent = scanner.nextInt();

    if ((average >= 90 && daysAbsent <= 3) || (average >= 80 && daysAbsent == 0)) {
      System.out.println("Congratulations! You are exempt from the final exam.");
      // ¡Felicidades! Estás exento del examen final.
    } else {
      System.out.println("Sorry, you are not exempt from the final exam.");
      // Lo siento, no estás exento del examen final.
    }
  }
}

```

7. Escriba un programa que calcule el número de botes de pintura necesarios para pintar una habitación y el número óptimo de botes que debe comprar.

   Tiene que preguntar por la altura, el largo y el ancho de la habitación. La habitación es rectangular. Tiene que pintar las paredes y el techo pero no el suelo. No hay ventanas ni tragaluces. Puede comprar botes de pintura de los siguientes tamaños.

   - El bote de 5 litros cuesta 15 $ y es suficiente para pintar 1500 pies cuadrados.
   - El bote de 1 litro cuesta 4 $ y es suficiente para pintar 300 pies cuadrados.

```java
package puntoSiete;

import java.util.Scanner;

public class PuntoSiete {

  public PuntoSiete(Scanner input) {
    double height, length, width;
    double totalArea, priceOneLiter, priceFiveLiter;
    int quantityOfFiveLiter, quantityOfOneLiter, optimalOneLiter, optimalFiveLiter;
    double oneLiterPrice = 4.0, fiveLiterPrice = 15.0;
    double oneLiterArea = 300, fiveLiterArea = 1500;

    // Pedir las dimensiones de la habitación
    System.out.print("Por favor, introduzca la altura de la habitación en pies: \n>> ");
    height = input.nextDouble();

    System.out.print("Por favor, introduzca la longitud de la habitación en pies: \n>> ");
    length = input.nextDouble();

    System.out.print("Por favor, introduzca el ancho de la habitación en pies: \n>> ");
    width = input.nextDouble();

    // Calcular el área total de la habitación
    totalArea = (2 * height * length) + (2 * height * width);

    quantityOfOneLiter = (int) Math.round(totalArea / oneLiterArea);
    quantityOfFiveLiter = (int) Math.round(totalArea / fiveLiterArea);

    optimalOneLiter = (int) Math.ceil((totalArea % fiveLiterArea) / oneLiterArea);
    optimalFiveLiter = (int) (Math.floor(totalArea / fiveLiterArea));

    priceOneLiter = optimalOneLiter * oneLiterPrice;
    priceFiveLiter = optimalFiveLiter * fiveLiterPrice;

    // Imprimir los resultados
    System.out.println("Para pintar una habitación de " + height + " pies de alto, " + length
        + " pies de largo y " + width + " pies de ancho:");
    System.out.println("(Area total: " + totalArea + " pies cuadrados)\n");

    System.out.print("Se necesitan " + quantityOfOneLiter + " botes de pintura de 1 litro, o ");
    System.out.println(quantityOfFiveLiter + " botes de 5 litros.");
    System.out.println(">> Para un resultado mas óptimo, se recomienda comprar " + optimalOneLiter
        + " botes de 1 litro y " + optimalFiveLiter + " botes de 5 litros.");
    System.out
        .println(">> El precio total de los botes de pintura es de $" + priceOneLiter + " por los botes de 1 litro y $"
            + priceFiveLiter + " por los botes de 5 litros. Total: $" + (priceOneLiter + priceFiveLiter));
  }
}

```
